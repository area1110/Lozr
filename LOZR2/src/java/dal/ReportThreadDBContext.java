/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FThread;
import model.Forum;
import model.ReportThread;
import model.UserInfo;

/**
 *
 * @author area1
 */
public class ReportThreadDBContext extends DBContext {

    public ArrayList<ReportThread> getReportThreads() {
        ArrayList<ReportThread> reportThreads = new ArrayList<>();
        try {
            String sql_select_reportthread = "SELECT TR.[TRID], TR.ReportDate,TR.[ThreadID], T.ThreadSubject, T.ThreadDateCreated,T.ThreadForumID,\n"
                    + "	T.ThreadIsActive, U.UserID, U.UserImageAvatar, U.UserLoginName	\n"
                    + "  FROM [Thread_Report] TR\n"
                    + "	INNER JOIN Thread T ON TR.ThreadID=T.ThreadID\n"
                    + "	INNER JOIN UserInfo U ON T.ThreadStartedBy=U.UserID\n"
                    + "WHERE T.ThreadIsActive=1\n"
                    + "ORDER BY TR.ReportDate DESC";
            PreparedStatement stm_select_reportthread = connection.prepareStatement(sql_select_reportthread);
            ResultSet rs = stm_select_reportthread.executeQuery();
            while (rs.next()) {
                ReportThread report = new ReportThread();
                report.setReportID(rs.getInt("TRID"));

                FThread thread = new FThread();
                thread.setThreadID(rs.getInt("ThreadID"));
                thread.setSubject(rs.getString("ThreadSubject"));
                thread.setTimeCreated(rs.getTimestamp("ThreadDateCreated"));
                Forum forum = new Forum();
                forum.setForumID(rs.getInt("ThreadForumID"));
                thread.setForum(forum);
                thread.setActive(rs.getBoolean("ThreadIsActive"));

                UserInfo started = new UserInfo();
                started.setUserID(rs.getInt("UserID"));
                started.setBase64ImageAvatar(rs.getString("UserImageAvatar"));
                started.setLoginName(rs.getString("UserLoginName"));

                thread.setStartedBy(started);
                report.setThread(thread);
                reportThreads.add(report);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportThreads;
    }

    public void setReport(int threadID) {
        try {
            String sql_insertReport = "INSERT INTO [Thread_Report]\n"
                    + "           ([ThreadID])\n"
                    + "     VALUES ?";
            PreparedStatement stm_insertReport = connection.prepareStatement(sql_insertReport);
            stm_insertReport.setInt(1, threadID);
            stm_insertReport.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
