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
import model.Post;
import model.User;

/**
 *
 * @author Khanh
 */
public class PostDBContext extends DBContext {

    public int getTotalPosts(int threadID) {
        try {
            String sql_countPosts = "SELECT COUNT(PostID) AS TotalPost FROM Post\n"
                    + "	WHERE PostThreadID=? AND PostIsActive=1";
            PreparedStatement stm_countPosts = connection.prepareStatement(sql_countPosts);
            stm_countPosts.setInt(1, threadID);
            ResultSet rs_countPosts = stm_countPosts.executeQuery();
            if (rs_countPosts.next()) {
                return rs_countPosts.getInt("TotalPost");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Post> getPosts(int threadID, int pageIndex) {
        int[] recordFromTo = PagingModule.calcFromToRecord(pageIndex);
        ArrayList<Post> posts = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM\n"
                    + "	(SELECT ROW_NUMBER() OVER (ORDER BY P.PostDateCreated) AS Row_count, P.PostID, P.PostSubject, P.PostThreadID, P.PostDateCreated,\n"
                    + "	P.PostIsActive ,P.PostUserID, U.UserLoginName, U.UserImageAvatar, U.UserIsMod, P.PostReplyTo,\n"
                    + " 	Rep.PostSubject AS RepPostSubject, Rep.PostDateCreated AS RepPostDateCreated,\n"
                    + "         	Rep.PostIsActive AS RepPostIsActive, Rep.PostUserID AS RepPostUserID,\n"
                    + "            URep.UserLoginName AS URepLoginName, URep.UserImageAvatar AS URepImageAvatar\n"
                    + "            FROM POST AS P\n"
                    + "            JOIN UserInfo AS U ON P.PostUserID=U.UserID\n"
                    + "            LEFT JOIN Post AS Rep ON P.PostReplyTo=Rep.PostID\n"
                    + "            LEFT JOIN UserInfo AS URep ON Rep.PostUserID=URep.UserID\n"
                    + "            WHERE P.PostThreadID=? AND P.PostIsActive = 1) AS Main\n"
                    + "	WHERE Main.Row_count BETWEEN ? AND ?";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, threadID);
            stm.setInt(2, recordFromTo[0]);
            stm.setInt(3, recordFromTo[1]);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostID(rs.getInt("PostID"));
                post.setSubject(rs.getNString("PostSubject"));
                post.setThreadId(rs.getInt("PostThreadID"));
                post.setTimeCreated(rs.getTimestamp("PostDateCreated"));
                post.setActive(rs.getBoolean("PostIsActive"));

                User user = new User();
                user.setUserID(rs.getInt("PostUserID"));
                user.setLoginName(rs.getString("UserLoginName"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                post.setUser(user);

                if (rs.getInt("PostReplyTo") != 0) {
                    Post reply = new Post();
                    reply.setPostID(rs.getInt("PostReplyTo"));
                    reply.setSubject(rs.getString("RepPostSubject"));
                    reply.setTimeCreated(rs.getTimestamp("RepPostDateCreated"));
                    reply.setActive(rs.getBoolean("RepPostIsActive"));

                    User repUser = new User();
                    repUser.setUserID(rs.getInt("RepPostUserID"));
                    repUser.setLoginName(rs.getString("URepLoginName"));
                    repUser.setAvatar(rs.getString("URepImageAvatar"));
                    reply.setUser(repUser);

                    post.setReplyPost(reply);
                }
                posts.add(post);
            }
            return posts;
        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalPostsByUser(int userID) {
        try {
            String sql_countPosts = "SELECT COUNT(PostID) AS TotalPost FROM Post\n"
                    + "	WHERE PostUserID=? AND PostIsActive=1";
            PreparedStatement stm_countPosts = connection.prepareStatement(sql_countPosts);
            stm_countPosts.setInt(1, userID);
            ResultSet rs_countPosts = stm_countPosts.executeQuery();
            if (rs_countPosts.next()) {
                return rs_countPosts.getInt("TotalPost");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Post> getPostsByUser(int userID, int pageIndex) {
        int[] fromToRecord = PagingModule.calcFromToRecord(pageIndex);
        ArrayList<Post> posts = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER ( ORDER BY P.PostDateCreated DESC) AS Row_count,\n"
                    + "	 P.PostID, P.PostSubject, P.PostThreadID, P.PostDateCreated,\n"
                    + "     P.PostIsActive ,P.PostUserID, U.UserLoginName, U.UserImageAvatar, U.UserIsMod, P.PostReplyTo,\n"
                    + "     Rep.PostSubject AS RepPostSubject, Rep.PostDateCreated AS RepPostDateCreated,\n"
                    + "     Rep.PostIsActive AS RepPostIsActive, Rep.PostUserID AS RepPostUserID,\n"
                    + "     URep.UserLoginName AS URepLoginName, URep.UserImageAvatar AS URepImageAvatar\n"
                    + "     FROM POST AS P\n"
                    + "     JOIN UserInfo AS U ON P.PostUserID=U.UserID\n"
                    + "     LEFT JOIN Post AS Rep ON P.PostReplyTo=Rep.PostID\n"
                    + "     LEFT JOIN UserInfo AS URep ON Rep.PostUserID=URep.UserID\n"
                    + "     WHERE P.PostUserID=? AND P.PostIsActive = 1) AS Main\n"
                    + "WHERE Main.Row_count BETWEEN ? AND ?";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, userID);
            stm.setInt(2, fromToRecord[0]);
            stm.setInt(3, fromToRecord[1]);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostID(rs.getInt("PostID"));
                post.setSubject(rs.getNString("PostSubject"));
                post.setThreadId(rs.getInt("PostThreadID"));
                post.setTimeCreated(rs.getTimestamp("PostDateCreated"));
                post.setActive(rs.getBoolean("PostIsActive"));

                User user = new User();
                user.setUserID(rs.getInt("PostUserID"));
                user.setLoginName(rs.getString("UserLoginName"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                post.setUser(user);

                if (rs.getInt("PostReplyTo") != 0) {
                    Post reply = new Post();
                    reply.setPostID(rs.getInt("PostReplyTo"));
                    reply.setSubject(rs.getString("RepPostSubject"));
                    reply.setTimeCreated(rs.getTimestamp("RepPostDateCreated"));
                    reply.setActive(rs.getBoolean("RepPostIsActive"));

                    User repUser = new User();
                    repUser.setUserID(rs.getInt("RepPostUserID"));
                    repUser.setLoginName(rs.getString("URepLoginName"));
                    repUser.setAvatar(rs.getString("URepImageAvatar"));
                    reply.setUser(repUser);

                    post.setReplyPost(reply);
                }
                posts.add(post);
            }
            return posts;
        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Post getPost(int postID) {
        try {
            String sqlStatement = "SELECT P.PostID, P.PostSubject, P.PostThreadID, P.PostDateCreated,\n"
                    + "	P.PostIsActive ,P.PostUserID, U.UserLoginName, U.UserImageAvatar, P.PostReplyTo,\n"
                    + "	Rep.PostSubject AS RepPostSubject, Rep.PostDateCreated AS RepPostDateCreated, \n"
                    + "	Rep.PostIsActive AS RepPostIsActive, Rep.PostUserID AS RepPostUserID,\n"
                    + "	URep.UserLoginName AS URepLoginName, URep.UserImageAvatar AS URepImageAvatar\n"
                    + "	FROM POST AS P \n"
                    + "		JOIN UserInfo AS U ON P.PostUserID=U.UserID\n"
                    + "		LEFT JOIN Post AS Rep ON P.PostReplyTo=Rep.PostID\n"
                    + "		LEFT JOIN UserInfo AS URep ON Rep.PostUserID=URep.UserID\n"
                    + "	WHERE P.PostID=? AND P.PostIsActive = 1";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, postID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Post post = new Post();
                post.setPostID(rs.getInt("PostID"));
                post.setSubject(rs.getNString("PostSubject"));
                post.setThreadId(rs.getInt("PostThreadID"));
                post.setTimeCreated(rs.getTimestamp("PostDateCreated"));
                post.setActive(rs.getBoolean("PostIsActive"));

                User user = new User();
                user.setUserID(rs.getInt("PostUserID"));
                user.setLoginName(rs.getString("UserLoginName"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                post.setUser(user);

                if (rs.getInt("PostReplyTo") != 0) {
                    Post reply = new Post();
                    reply.setPostID(rs.getInt("PostReplyTo"));
                    reply.setSubject(rs.getString("RepPostSubject"));
                    reply.setTimeCreated(rs.getTimestamp("RepPostDateCreated"));
                    reply.setActive(rs.getBoolean("RepPostIsActive"));

                    User repUser = new User();
                    repUser.setUserID(rs.getInt("RepPostUserID"));
                    repUser.setLoginName(rs.getString("URepLoginName"));
                    repUser.setAvatar(rs.getString("URepImageAvatar"));
                    reply.setUser(repUser);

                    post.setReplyPost(reply);
                }
                return post;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean setPost(Post post) {
        try {
            if (post.getReplyPost() == null) {
                String sql_insert_post = "INSERT INTO [Post]\n"
                        + "           ([PostSubject]\n"
                        + "           ,[PostUserID]\n"
                        + "           ,[PostThreadID])\n"
                        + "     VALUES (?,?,?)";
                PreparedStatement stm_insert_post = connection.prepareStatement(sql_insert_post);
                stm_insert_post.setString(1, post.getSubject());
                stm_insert_post.setInt(2, post.getUser().getUserID());
                stm_insert_post.setInt(3, post.getThreadId());
                stm_insert_post.executeUpdate();
            } else {
                String sql_insert_post = "INSERT INTO [Post]\n"
                        + "           ([PostSubject]\n"
                        + "           ,[PostUserID]\n"
                        + "           ,[PostThreadID]\n"
                        + "           ,[PostReplyTo])\n"
                        + "     VALUES (?,?,?,?)";
                PreparedStatement stm_insert_post = connection.prepareStatement(sql_insert_post);
                stm_insert_post.setString(1, post.getSubject());
                stm_insert_post.setInt(2, post.getUser().getUserID());
                stm_insert_post.setInt(3, post.getThreadId());
                stm_insert_post.setInt(4, post.getReplyPost().getPostID());
                stm_insert_post.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public void updateStatus(int postID, boolean status) {
        try {
            connection.setAutoCommit(false);
            String sql_update_active = "UPDATE [Post]\n"
                    + "   SET [PostIsActive] = ?\n"
                    + " WHERE PostID = ?";
            PreparedStatement stm_update_active = connection.prepareStatement(sql_update_active);
            stm_update_active.setBoolean(1, status);
            stm_update_active.setInt(2, postID);
            stm_update_active.executeUpdate();
            ReportPostDBContext reportPDBC = new ReportPostDBContext();
            reportPDBC.remove(postID);
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
