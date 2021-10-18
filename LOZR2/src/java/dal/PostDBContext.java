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
import model.Post;
import model.UserInfo;

/**
 *
 * @author Khanh
 */
public class PostDBContext extends DBContext {

    public ArrayList<Post> getPosts(int threadID) {
        ArrayList<Post> posts = new ArrayList<>();
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
                    + "	WHERE P.PostThreadID=? AND P.PostIsActive = 1"
                    + "ORDER BY P.PostDateCreated ASC";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, threadID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostID(rs.getInt("PostID"));
                post.setSubject(rs.getNString("PostSubject"));
                post.setThreadId(rs.getInt("PostThreadID"));
                post.setTimeCreated(rs.getTimestamp("PostDateCreated"));
                post.setActive(rs.getBoolean("PostIsActive"));

                UserInfo user = new UserInfo();
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

                    UserInfo repUser = new UserInfo();
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

    public ArrayList<Post> getPostsByUser(int userID) {
        ArrayList<Post> posts = new ArrayList<>();
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
                    + "	WHERE P.PostUserID=? AND P.PostIsActive = 1"
                    + "ORDER BY P.PostDateCreated DESC";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, userID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostID(rs.getInt("PostID"));
                post.setSubject(rs.getNString("PostSubject"));
                post.setThreadId(rs.getInt("PostThreadID"));
                post.setTimeCreated(rs.getTimestamp("PostDateCreated"));
                post.setActive(rs.getBoolean("PostIsActive"));

                UserInfo user = new UserInfo();
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

                    UserInfo repUser = new UserInfo();
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

                UserInfo user = new UserInfo();
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

                    UserInfo repUser = new UserInfo();
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
            String sql_update_active = "UPDATE [Post]\n"
                    + "   SET [PostIsActive] = ?\n"
                    + " WHERE PostID = ?";
            PreparedStatement stm_update_active = connection.prepareStatement(sql_update_active);
            stm_update_active.setBoolean(1, status);
            stm_update_active.setInt(2, postID);
            stm_update_active.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
