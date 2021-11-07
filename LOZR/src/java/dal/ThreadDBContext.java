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
import model.User;

/**
 *
 * @author Khanh
 */
public class ThreadDBContext extends DBContext {

    public int getTotalThreads(int forumID) {
        try {
            String sql_countThreads = "SELECT COUNT(ThreadID) AS TotalRecords FROM Thread\n"
                    + "WHERE ThreadForumID=? AND ThreadIsActive=1";
            PreparedStatement stm_countThreads = connection.prepareStatement(sql_countThreads);
            stm_countThreads.setInt(1, forumID);
            ResultSet rs_countThreads = stm_countThreads.executeQuery();
            if (rs_countThreads.next()) {
                return rs_countThreads.getInt("TotalRecords");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<FThread> getFThreads(int forumID, int pageIndex) {
        int[] recordFromTo = PagingModule.calcFromToRecord(pageIndex);
        ArrayList<FThread> fThreads = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM \n"
                    + "(SELECT ROW_NUMBER() OVER (ORDER BY T.ThreadDateCreated DESC) AS Row_count,\n"
                    + "	T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID,\n"
                    + "	U.UserID, U.UserLoginName, U.UserIsMod, U.UserImageAvatar, T.ThreadIsActive,\n"
                    + "	(SELECT COUNT(PostID) FROM Post\n"
                    + "			WHERE PostThreadID=T.ThreadID) AS TotalPosts\n"
                    + "FROM Thread AS T JOIN UserInfo AS U\n"
                    + "	ON T.ThreadStartedBy=U.UserID\n"
                    + "WHERE T.ThreadForumID=? AND T.ThreadIsActive=1) AS Main\n"
                    + "WHERE Main.Row_count BETWEEN ? AND ?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, forumID);
            stm.setInt(2, recordFromTo[0]);
            stm.setInt(3, recordFromTo[1]);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                FThread fThread = new FThread();
                fThread.setThreadID(rs.getInt("ThreadID"));
                fThread.setSubject(rs.getNString("ThreadSubject"));
                fThread.setTimeCreated(rs.getTimestamp("ThreadDateCreated"));

                Forum forum = new Forum();
                forum.setForumID(rs.getInt("ThreadForumID"));
                fThread.setForum(forum);
                fThread.setActive(rs.getBoolean("ThreadIsActive"));

                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                fThread.setStartedBy(user);
                fThread.setNumPosts(rs.getInt("TotalPosts"));
                fThreads.add(fThread);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fThreads;
    }

    public int getTotalThread(String querySubject) {
        try {
            String sql_count_thread = "SELECT COUNT(ThreadID) AS TotalThread FROM Thread\n"
                    + "WHERE ThreadIsActive=1 AND ThreadSubject LIKE  ? + '%'";
            PreparedStatement stm_count_thread = connection.prepareStatement(sql_count_thread);
            stm_count_thread.setString(1, querySubject);
            ResultSet rs_count_thread = stm_count_thread.executeQuery();
            if (rs_count_thread.next()) {
                return rs_count_thread.getInt("TotalThread");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<FThread> getFThreads(String querySubject, int pageIndex) {
        int[] fromToRecord = PagingModule.calcFromToRecord(pageIndex);
        ArrayList<FThread> fThreads = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER (ORDER BY T.ThreadDateCreated DESC) AS Row_count, T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID,\n"
                    + "    U.UserID, U.UserLoginName, U.UserIsMod, U.UserImageAvatar, T.ThreadIsActive,\n"
                    + "    (SELECT COUNT(PostID) FROM Post\n"
                    + "WHERE PostThreadID=T.ThreadID) AS TotalPosts\n"
                    + "     FROM Thread AS T JOIN UserInfo AS U\n"
                    + "     ON T.ThreadStartedBy=U.UserID\n"
                    + "WHERE  T.ThreadIsActive=1 AND T.ThreadSubject LIKE  ? + '%') AS Main\n"
                    + "WHERE Main.Row_count BETWEEN ? AND ?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setString(1, querySubject);
            stm.setInt(2, fromToRecord[0]);
            stm.setInt(3, fromToRecord[1]);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                FThread fThread = new FThread();
                fThread.setThreadID(rs.getInt("ThreadID"));
                fThread.setSubject(rs.getNString("ThreadSubject"));
                fThread.setTimeCreated(rs.getTimestamp("ThreadDateCreated"));

                Forum forum = new Forum();
                forum.setForumID(rs.getInt("ThreadForumID"));
                fThread.setForum(forum);
                fThread.setActive(rs.getBoolean("ThreadIsActive"));

                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                fThread.setStartedBy(user);
                fThread.setNumPosts(rs.getInt("TotalPosts"));
                fThreads.add(fThread);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fThreads;
    }

    public int getTotalThreadsByUser(int userID) {
        try {
            String sql_count_thread = "SELECT COUNT(ThreadID) AS TotalThread FROM Thread\n"
                    + "WHERE ThreadIsActive=1 AND ThreadStartedBy=?";
            PreparedStatement stm_count_thread = connection.prepareStatement(sql_count_thread);
            stm_count_thread.setInt(1, userID);
            ResultSet rs_count_thread = stm_count_thread.executeQuery();
            if (rs_count_thread.next()) {
                return rs_count_thread.getInt("TotalThread");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<FThread> getFThreadsByUser(int userID, int pageIndex) {
        int[] fromToRecord = PagingModule.calcFromToRecord(pageIndex);
        ArrayList<FThread> fThreads = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER ( ORDER BY T.ThreadDateCreated DESC) AS Row_count,\n"
                    + "	T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID,\n"
                    + "    U.UserID, U.UserLoginName, U.UserIsMod, U.UserImageAvatar, T.ThreadIsActive,\n"
                    + "    (SELECT COUNT(PostID) FROM Post\n"
                    + "	WHERE PostThreadID=T.ThreadID) AS TotalPosts\n"
                    + "    FROM Thread AS T JOIN UserInfo AS U\n"
                    + "    ON T.ThreadStartedBy=U.UserID\n"
                    + "WHERE U.UserID=? AND T.ThreadIsActive=1) AS Main\n"
                    + "WHERE Main.Row_count BETWEEN ? AND ?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, userID);
            stm.setInt(2, fromToRecord[0]);
            stm.setInt(3, fromToRecord[1]);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                FThread fThread = new FThread();
                fThread.setThreadID(rs.getInt("ThreadID"));
                fThread.setSubject(rs.getNString("ThreadSubject"));
                fThread.setTimeCreated(rs.getTimestamp("ThreadDateCreated"));

                Forum forum = new Forum();
                forum.setForumID(rs.getInt("ThreadForumID"));
                fThread.setForum(forum);
                fThread.setActive(rs.getBoolean("ThreadIsActive"));

                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                fThread.setStartedBy(user);
                fThread.setNumPosts(rs.getInt("TotalPosts"));
                fThreads.add(fThread);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fThreads;
    }

    public int getTotalFollowedThreads(int userID) {
        try {
            String sql_count_thread = "SELECT  COUNT(B.ThreadID) AS TotalThread\n"
                    + "  FROM [BookMark] AS B INNER JOIN Thread AS T\n"
                    + "	ON B.ThreadID=T.ThreadID\n"
                    + "  WHERE ThreadIsActive=1 AND B.UserID=?";
            PreparedStatement stm_count_thread = connection.prepareStatement(sql_count_thread);
            stm_count_thread.setInt(1, userID);
            ResultSet rs_count_thread = stm_count_thread.executeQuery();
            if (rs_count_thread.next()) {
                return rs_count_thread.getInt("TotalThread");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<FThread> getFollowedThreads(int userID, int pageIndex) {
        int[] fromToRecord = PagingModule.calcFromToRecord(pageIndex);
        ArrayList<FThread> fThreads = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM\n"
                    + "  (SELECT ROW_NUMBER() OVER ( ORDER BY T.ThreadDateCreated DESC) AS Row_count,\n"
                    + "   T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID,\n"
                    + "    U.UserID, U.UserLoginName, U.UserIsMod, U.UserImageAvatar, T.ThreadIsActive,\n"
                    + "    (SELECT COUNT(PostID) FROM Post\n"
                    + "    WHERE PostThreadID=T.ThreadID) AS TotalPosts\n"
                    + "    FROM BookMark AS B \n"
                    + "	JOIN Thread AS T ON B.ThreadID=T.ThreadID\n"
                    + "	JOIN UserInfo AS U ON T.ThreadStartedBy=U.UserID\n"
                    + "    WHERE B.UserID=? AND T.ThreadIsActive=1) AS Main\n"
                    + "    WHERE Main.Row_count BETWEEN ? AND ?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, userID);
            stm.setInt(2, fromToRecord[0]);
            stm.setInt(3, fromToRecord[1]);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                FThread fThread = new FThread();
                fThread.setThreadID(rs.getInt("ThreadID"));
                fThread.setSubject(rs.getNString("ThreadSubject"));
                fThread.setTimeCreated(rs.getTimestamp("ThreadDateCreated"));

                Forum forum = new Forum();
                forum.setForumID(rs.getInt("ThreadForumID"));
                fThread.setForum(forum);
                fThread.setActive(rs.getBoolean("ThreadIsActive"));

                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                fThread.setStartedBy(user);
                fThread.setNumPosts(rs.getInt("TotalPosts"));
                fThreads.add(fThread);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fThreads;
    }

    public FThread getFThread(int threadID) {
        try {
            String sql_select_thread = "SELECT T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID,\n"
                    + "	T.ThreadIsActive, F.ForumName,\n"
                    + "    U.UserID, U.UserLoginName, U.UserIsMod, U.UserImageAvatar\n"
                    + "    FROM Thread AS T JOIN UserInfo AS U\n"
                    + "    ON T.ThreadStartedBy=U.UserID\n"
                    + "	JOIN Forum AS F ON T.ThreadForumID=F.ForumID\n"
                    + "    WHERE T.ThreadID=?";
            PreparedStatement stm_select_thread = connection.prepareStatement(sql_select_thread);
            stm_select_thread.setInt(1, threadID);
            ResultSet rs_select_thread = stm_select_thread.executeQuery();
            if (rs_select_thread.next()) {
                FThread fthread = new FThread();
                fthread.setThreadID(rs_select_thread.getInt("ThreadID"));
                fthread.setSubject(rs_select_thread.getString("ThreadSubject"));
                fthread.setTimeCreated(rs_select_thread.getTimestamp("ThreadDateCreated"));

                Forum forum = new Forum();
                forum.setForumID(rs_select_thread.getInt("ThreadForumID"));
                forum.setName(rs_select_thread.getString("ForumName"));
                fthread.setForum(forum);
                User user = new User();
                user.setUserID(rs_select_thread.getInt("UserID"));
                user.setLoginName(rs_select_thread.getString("UserLoginName"));
                fthread.setStartedBy(user);
                fthread.setActive(rs_select_thread.getBoolean("ThreadIsActive"));
                return fthread;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatus(int threadID, boolean status) {
        try {
            connection.setAutoCommit(false);
            String sql_update_active = "UPDATE [Thread]\n"
                    + "   SET [ThreadIsActive] = ?\n"
                    + " WHERE ThreadID = ?";
            PreparedStatement stm_update_active = connection.prepareStatement(sql_update_active);
            stm_update_active.setBoolean(1, status);
            stm_update_active.setInt(2, threadID);
            stm_update_active.executeUpdate();
            ReportThreadDBContext reportTDBC = new ReportThreadDBContext();
            reportTDBC.remove(threadID);
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void updateThread(FThread thread) {
        try {
            String sql_update = "UPDATE [Thread]\n"
                    + "   SET [ThreadSubject] = ?\n"
                    + " WHERE ThreadID = ?";

            PreparedStatement stm_update = connection.prepareStatement(sql_update);
            stm_update.setString(1, thread.getSubject());
            stm_update.setInt(2, thread.getThreadID());

            stm_update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFollowThread(int userId, int threadId) {
        try {
            String sql_insert = "INSERT INTO [BookMark]\n"
                    + "           ([UserID]\n"
                    + "           ,[ThreadID])\n"
                    + "     VALUES (?, ?)";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, userId);
            stm_insert.setInt(2, threadId);
            stm_insert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unFollowThread(int userId, int threadId) {
        try {
            String sql_insert = "DELETE FROM [BookMark]\n"
                    + "      WHERE UserID=? AND ThreadID=?";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            stm_insert.setInt(1, userId);
            stm_insert.setInt(2, threadId);
            stm_insert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
