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
import model.UserInfo;

/**
 *
 * @author Khanh
 */
public class FThreadDBContext extends DBContext {

    public ArrayList<FThread> getFThreads(int forumID) {
        ArrayList<FThread> fThreads = new ArrayList<>();
        try {
            String sqlStatement = "SELECT T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID, \n"
                    + "U.UserID, U.UserLoginName, U.UserIsAdmin, U.UserImageAvatar, T.ThreadIsActive\n"
                    + "FROM Thread AS T JOIN UserInfo AS U\n"
                    + "	ON T.ThreadStartedBy=U.UserID\n"
                    + "	WHERE T.ThreadForumID=? AND T.ThreadIsActive=1";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, forumID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                FThread fThread = new FThread();
                fThread.setThreadID(rs.getInt(1));
                fThread.setSubject(rs.getNString(2));
                fThread.setTimeCreated(rs.getTimestamp(3));

                Forum forum = new Forum();
                forum.setForumID(rs.getInt(4));
                fThread.setForum(forum);
                fThread.setActive(rs.getBoolean("ThreadIsActive"));

                UserInfo user = new UserInfo();
                user.setUserID(rs.getInt(5));
                user.setLoginName(rs.getNString(6));
                user.setAdmin(rs.getBoolean(7));
                user.setBase64ImageAvatar(rs.getString("UserImageAvatar"));

                fThread.setStartedBy(user);
                fThreads.add(fThread);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fThreads;
    }

    public FThread getFThread(int threadID) {
        FThread fthread = null;
        try {
            String sql_select_thread = "SELECT T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID,\n"
                    + "U.UserID, U.UserLoginName, U.UserIsAdmin, U.UserImageAvatar\n"
                    + "FROM Thread AS T JOIN UserInfo AS U\n"
                    + "	ON T.ThreadStartedBy=U.UserID\n"
                    + "	WHERE T.ThreadID=?";
            PreparedStatement stm_select_thread = connection.prepareStatement(sql_select_thread);
            stm_select_thread.setInt(1, threadID);
            ResultSet rs_select_thread = stm_select_thread.executeQuery();
            if (rs_select_thread.next()) {
                fthread = new FThread();
                fthread.setThreadID(rs_select_thread.getInt("ThreadID"));
                fthread.setSubject(rs_select_thread.getString("ThreadSubject"));
                fthread.setTimeCreated(rs_select_thread.getTimestamp("ThreadDateCreated"));

                UserInfo user = new UserInfo();
                user.setUserID(rs_select_thread.getInt("UserID"));
                user.setLoginName(rs_select_thread.getString("UserLoginName"));
                fthread.setStartedBy(user);
            }
            return fthread;
        } catch (SQLException ex) {
            Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fthread;
    }

    public void setFThread(FThread fthread) {
        try {
            connection.setAutoCommit(true);
            try {
                String sql_insert_thread = "INSERT INTO Thread"
                        + "(ThreadSubject, ThreadStartedBy, ThreadForumID)\n"
                        + "VALUES(?, ?, ?)";

                PreparedStatement stm_insert_thread = connection.prepareStatement(sql_insert_thread);
                stm_insert_thread.setString(1, fthread.getSubject());
                stm_insert_thread.setInt(2, fthread.getStartedBy().getUserID());
                stm_insert_thread.setInt(3, fthread.getForum().getForumID());
                stm_insert_thread.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatus(int threadID, boolean status) {
        try {
            String sql_update_active = "UPDATE [Thread]\n"
                    + "   SET [ThreadIsActive] = ?\n"
                    + " WHERE ThreadID = ?";
            PreparedStatement stm_update_active = connection.prepareStatement(sql_update_active);
            stm_update_active.setBoolean(1, status);
            stm_update_active.setInt(2, threadID);
            stm_update_active.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
