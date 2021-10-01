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
import model.UserInfo;

/**
 *
 * @author Khanh
 */
public class FThreadDBContext extends DBContext {

    public ArrayList<FThread> getFThreads(int forumID) {
        ArrayList<FThread> fThreads = new ArrayList<>();
        try {
            String sqlStatement = "SELECT T.ThreadID, T.ThreadSubject, T.ThreadDateCreated, T.ThreadForumID,\n"
                    + "U.UserID, U.UserLoginName, U.UserIsAdmin\n"
                    + "FROM Thread AS T JOIN UserInfo AS U\n"
                    + "	ON T.ThreadStartedBy=U.UserID\n"
                    + "	WHERE T.ThreadForumID=?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, forumID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                FThread fThread = new FThread();
                fThread.setThreadID(rs.getInt(1));
                fThread.setSubject(rs.getNString(2));
                fThread.setDateCreated(rs.getDate(3));
                fThread.setForumID(rs.getInt(4));

                UserInfo user = new UserInfo();
                user.setUserID(rs.getInt(5));
                user.setLoginName(rs.getNString(6));           
                user.setAdmin(rs.getBoolean(7));
     
                fThread.setStartedBy(user);
                fThreads.add(fThread);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fThreads;
    }
}
