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
import model.User;

/**
 *
 * @author area1
 */
public class ReportPostDBContext extends DBContext {

    public ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            String sqlStatement = "SELECT PR.ReportDate, P.PostID, P.PostSubject, P.PostThreadID, P.PostDateCreated,\n"
                    + "       P.PostIsActive ,P.PostUserID, U.UserLoginName, U.UserImageAvatar, P.PostReplyTo,\n"
                    + "       Rep.PostSubject AS RepPostSubject, Rep.PostDateCreated AS RepPostDateCreated, \n"
                    + "	   Rep.PostIsActive AS RepPostIsActive, Rep.PostUserID AS RepPostUserID,\n"
                    + "       URep.UserLoginName AS URepLoginName, URep.UserImageAvatar AS URepImageAvatar\n"
                    + " FROM Post_Report AS PR \n"
                    + "	INNER JOIN POST AS P ON PR.PostID=P.PostID\n"
                    + "    JOIN UserInfo AS U ON P.PostUserID=U.UserID\n"
                    + "    LEFT JOIN Post AS Rep ON P.PostReplyTo=Rep.PostID\n"
                    + "    LEFT JOIN UserInfo AS URep ON Rep.PostUserID=URep.UserID\n"
                    + "ORDER BY PR.ReportDate ASC";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
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
    
     public void setReport(int postID) {
        try {
            String sql_insertReport = "INSERT INTO [Post_Report] \n"
                    + "           ([PostID]) VALUES (?)";
            PreparedStatement stm_insertReport = connection.prepareStatement(sql_insertReport);
            stm_insertReport.setInt(1, postID);
            stm_insertReport.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void remove(int postID) {
        try {
            String sql_delete = "DELETE FROM [Post_Report]\n"
                    + "      WHERE PostID=?";
            PreparedStatement stm_delete = connection.prepareStatement(sql_delete);
            stm_delete.setInt(1, postID);
            stm_delete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
