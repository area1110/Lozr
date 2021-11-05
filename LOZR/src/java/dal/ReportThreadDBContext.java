/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import controller.module.PagingModule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FThread;
import model.Forum;
import model.ReportThread;
import model.User;

/**
 *
 * @author area1
 */
public class ReportThreadDBContext extends DBContext {
    
    public int getTotalReportThreads(){
        try {
            String sql_count_report = "SELECT COUNT([ID]) AS TotalRecord FROM [Thread_Report]";
            PreparedStatement stm_count_report = connection.prepareStatement(sql_count_report);
            ResultSet rs_count_report = stm_count_report.executeQuery();
            if(rs_count_report.next()){
                return rs_count_report.getInt("TotalRecord");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<ReportThread> getReportThreads(int pageIndex) {
        int[] fromToRecord = PagingModule.calcFromToRecord(pageIndex);
        ArrayList<ReportThread> reportThreads = new ArrayList<>();
        try {
            String sql_select_reportthread = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER (ORDER BY TR.ReportTime DESC) AS Row_count,\n"
                    + "	TR.ID, TR.Reason, TR.ReportTime,TR.[ThreadID], T.ThreadSubject, T.ThreadDateCreated,T.ThreadForumID,\n"
                    + "    T.ThreadIsActive, U.UserID, U.UserImageAvatar, U.UserLoginName,\n"
                    + "     (SELECT COUNT(PostID) FROM Post\n"
                    + "     WHERE PostThreadID=TR.ThreadID) AS TotalPosts\n"
                    + "FROM [Thread_Report] TR\n"
                    + "     INNER JOIN Thread T ON TR.ThreadID=T.ThreadID\n"
                    + "     INNER JOIN UserInfo U ON T.ThreadStartedBy=U.UserID\n"
                    + "WHERE T.ThreadIsActive=1) AS Main\n"
                    + "WHERE Main.Row_count BETWEEN ? AND ?";
            PreparedStatement stm_select_reportthread = connection.prepareStatement(sql_select_reportthread);
            stm_select_reportthread.setInt(1, fromToRecord[0]);
            stm_select_reportthread.setInt(2, fromToRecord[1]);
            ResultSet rs = stm_select_reportthread.executeQuery();
            while (rs.next()) {
                ReportThread report = new ReportThread();
                report.setReportID(rs.getInt("ID"));
                report.setReason(rs.getString("Reason"));

                FThread thread = new FThread();
                thread.setThreadID(rs.getInt("ThreadID"));
                thread.setSubject(rs.getString("ThreadSubject"));
                thread.setTimeCreated(rs.getTimestamp("ThreadDateCreated"));
                thread.setNumPosts(rs.getInt("TotalPosts"));
                Forum forum = new Forum();
                forum.setForumID(rs.getInt("ThreadForumID"));
                thread.setForum(forum);
                thread.setActive(rs.getBoolean("ThreadIsActive"));

                User started = new User();
                started.setUserID(rs.getInt("UserID"));
                started.setAvatar(rs.getString("UserImageAvatar"));
                started.setLoginName(rs.getString("UserLoginName"));
                thread.setStartedBy(started);
                report.setThread(thread);;

                reportThreads.add(report);
            }
            return reportThreads;
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setReport(int threadID, String reason) {
        try {
            String sql_insertReport = "INSERT INTO [Thread_Report]\n"
                    + "           ([ThreadID], [Reason])\n"
                    + "     VALUES (?, ?)";
            PreparedStatement stm_insertReport = connection.prepareStatement(sql_insertReport);
            stm_insertReport.setInt(1, threadID);
            stm_insertReport.setString(2, reason);
            stm_insertReport.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(int threadID) {
        try {
            String sql_delete = "DELETE FROM [Thread_Report]\n"
                    + "      WHERE ThreadID=?";
            PreparedStatement stm_delete = connection.prepareStatement(sql_delete);
            stm_delete.setInt(1, threadID);
            stm_delete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
