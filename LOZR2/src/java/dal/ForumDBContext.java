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
import model.Forum;

/**
 *
 * @author Khanh
 */
public class ForumDBContext extends DBContext {

    public ArrayList<Forum> getForums() {
        ArrayList<Forum> forums = new ArrayList<>();
        try {
            String sql_select_forums = "SELECT F.*, \n"
                    + "	(SELECT COUNT(ThreadID) FROM Thread\n"
                    + "		WHERE CONVERT(DATE, ThreadDateCreated)=CONVERT(DATE, GETDATE())\n"
                    + "			AND ThreadForumID=F.ForumID) AS ThreadToday,\n"
                    + "	(SELECT COUNT(P.PostID) FROM Post AS P\n"
                    + "		INNER JOIN Thread AS T ON P.PostThreadID=T.ThreadID\n"
                    + "		WHERE CONVERT(DATE, P.PostDateCreated)=CONVERT(DATE, GETDATE())\n"
                    + "			AND T.ThreadForumID=F.ForumID) AS PostToday\n"
                    + "FROM Forum AS F WHERE F.ForumIsActive=1";

            PreparedStatement stm_select_forums = connection.prepareStatement(sql_select_forums);
            ResultSet rs_select_forums = stm_select_forums.executeQuery();

            while (rs_select_forums.next()) {
                Forum forum = new Forum();
                forum.setForumID(rs_select_forums.getInt("ForumID"));
                forum.setName(rs_select_forums.getNString("ForumName"));
                forum.setActive(rs_select_forums.getBoolean("ForumIsActive"));
                forum.setBase64Image(rs_select_forums.getString("ForumImage"));
                forum.setNewThreads(rs_select_forums.getInt("ThreadToday"));
                forum.setNewPosts(rs_select_forums.getInt("PostToday"));

                forums.add(forum);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ForumDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return forums;
    }

    public Forum getForum(int forumID) {

        try {
            String sqlStatement = "SELECT * FROM Forum\n"
                    + "WHERE ForumID=?";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, forumID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Forum forum = new Forum();
                forum.setForumID(rs.getInt("ForumID"));
                forum.setName(rs.getNString("ForumName"));
                forum.setBase64Image(rs.getString("ForumImage"));
                forum.setActive(rs.getBoolean("ForumIsActive"));
                return forum;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForumDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean setForum(Forum forum) {
        if (forum.getName().trim().isEmpty()) {
            return false;
        }
        try {
            String sqlStatement = "INSERT INTO Forum(ForumName, ForumImage)\n"
                    + "VALUES (?,?)";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setNString(1, forum.getName());
            stm.setString(2, forum.getBase64Image());
            if (stm.executeUpdate() == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForumDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateStatus(int forumID, boolean status) {
        try {
            String sql_update_forum = "UPDATE [Forum]\n"
                    + "   SET [ForumIsActive] = ?\n"
                    + " WHERE ForumID = ?";

            PreparedStatement stm_update_forum = connection.prepareStatement(sql_update_forum);
            stm_update_forum.setBoolean(1, status);
            stm_update_forum.setInt(2, forumID);
            stm_update_forum.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ForumDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateImageCover(int forumID, String b64CoverImg) {
        try {
            String sql_update = "UPDATE [Forum]\n"
                    + "   SET [ForumImage] = ?    \n"
                    + " WHERE ForumID = ?";

            PreparedStatement stm_update = connection.prepareStatement(sql_update);
            stm_update.setString(1, b64CoverImg);
            stm_update.setInt(2, forumID);
            stm_update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ForumDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateName(int forumID, String forumName) {
        try {
            String sql_update = "UPDATE [Forum]\n"
                    + "   SET ForumName = ?    \n"
                    + " WHERE ForumID = ?";

            PreparedStatement stm_update = connection.prepareStatement(sql_update);
            stm_update.setString(1, forumName);
            stm_update.setInt(2, forumID);
            stm_update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ForumDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateNameNCover(int forumID, String forumName, String b64Img) {

        try {
            String set_forumName = "";
            String set_forumImg = "";
            if (forumName == null && b64Img == null) {
                return;
            } else if (forumName != null && b64Img != null) {
                set_forumName = " [ForumName] = ?, ";
                set_forumImg = " [ForumImage] = ? ";

            } else if (forumName != null && b64Img == null) {
                set_forumName = " [ForumName] = ? ";

            } else if (b64Img != null && forumName == null) {
                set_forumImg = " [ForumImage] = ? ";

            }
            String sql_update = "UPDATE [Forum]\n"
                    + "   SET" + set_forumName + set_forumImg
                    + " WHERE ForumID = ?";

            PreparedStatement stm_update = connection.prepareStatement(sql_update);
            System.out.println(sql_update);
            if (forumName != null && b64Img != null) {
                stm_update.setString(1, forumName);
                stm_update.setString(2, b64Img);
                stm_update.setInt(3, forumID);
            } else if (forumName != null && b64Img == null) {
                stm_update.setString(1, forumName);
                stm_update.setInt(2, forumID);
            } else if (b64Img != null && forumName == null) {
                stm_update.setString(1, b64Img);
                stm_update.setInt(2, forumID);
            }

            stm_update.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ForumDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
