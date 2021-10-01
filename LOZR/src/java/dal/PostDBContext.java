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
            String sqlStatement = "EXEC getPost\n"
                    + "	@pThreadID=?";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, threadID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostID(rs.getInt("PostID"));
                post.setSubject(rs.getNString("PostSubject"));
                
                
                posts.add(post);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);

        }
        return posts;
    }

    public boolean setPost(Post post) {

        try {
            String sqlStatement = "";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
