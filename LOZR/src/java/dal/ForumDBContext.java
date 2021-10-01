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
            String getTopicQuery = "SELECT [ForumID]\n"
                    + "      ,[ForumName]\n"
                    + "      ,[ForumImage]\n"
                    + "      ,[ForumIsActive]\n"
                    + "  FROM [Forum]\n"
                    + "  WHERE ForumIsActive=1";
            PreparedStatement stm = connection.prepareStatement(getTopicQuery);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Forum forum = new Forum();
                forum.setForumID(rs.getInt(1));
                forum.setName(rs.getNString(2));
                forum.setActive(rs.getBoolean(4));
                forum.setBase64Image(rs.getString(3));
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
                forum.setActive(rs.getBoolean(3));
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
}
