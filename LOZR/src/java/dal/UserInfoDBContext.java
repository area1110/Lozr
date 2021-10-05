/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import controller.module.Encode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import model.Account;
import model.UserInfo;

/**
 *
 * @author Khanh
 */
public class UserInfoDBContext extends DBContext {

    public int createNewUser(UserInfo user, Account acc) {
        UserInfoDBContext userDBC = new UserInfoDBContext();
        if (user.getLoginName().isEmpty() || acc.getPassword().isEmpty()
                || user.getEmailAddress().isEmpty()) {
            return -1;
        }
        if (userDBC.getUser(user.getLoginName()) != null) {
            return -2;
        }
        try {
            String sqlStatement = "DECLARE @response NVARCHAR(10)\n"
                    + "EXEC AddUser\n"
                    + " @pLoginName=?,\n"
                    + " @pPassword=?,\n"
                    + " @pFirstName=?,\n"
                    + " @pLastName=?,\n"
                    + " @pEmail=?,\n"
                    + " @pImage=?,\n"
                    + " @responseMessage=@response OUTPUT\n"
                    + "SELECT @response AS MESSAGE";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);

            stm.setNString(1, user.getLoginName());
            stm.setString(2, acc.getPassword());
            stm.setNString(3, user.getFirstName());
            stm.setNString(4, user.getLastName());
            stm.setString(5, user.getEmailAddress());
            stm.setString(6, user.getBase64ImageAvatar());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public UserInfo getUser(String userLoginName) {

        try {
            String sqlStatement = "SELECT UserID, UserLoginName, UserFirstName, UserLastName, UserEmailAddress,\n"
                    + "UserDateJoined, UserImageAvatar , UserIsAdmin FROM UserInfo\n"
                    + "WHERE UserLoginName=?"; //'" + userLoginName + "'

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setNString(1, userLoginName);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                UserInfo user = new UserInfo();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setFirstName(rs.getNString("UserFirstName"));
                user.setLastName(rs.getNString("UserLastName"));
                user.setEmailAddress(rs.getString("UserEmailAddress"));
                user.setTimeJoined(rs.getTimestamp("UserDateJoined"));
                user.setAdmin(rs.getBoolean("UserIsAdmin"));
                user.setBase64ImageAvatar(rs.getString("UserImageAvatar"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UserInfo getUserLogin(String loginName, String password) {
        try {
            String sqlStatement = "EXEC verifyUser\n"
                    + "	@pLoginName=?,\n"
                    + "	@pPassword=?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setNString(1, loginName);
            stm.setNString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserInfo user = new UserInfo();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setFirstName(rs.getNString("UserFirstName"));
                user.setLastName(rs.getNString("UserLastName"));
                user.setEmailAddress(rs.getString("UserEmailAddress"));
                user.setTimeJoined(rs.getTimestamp("UserDateJoined"));
                user.setAdmin(rs.getBoolean("UserIsAdmin"));
                user.setBase64ImageAvatar(rs.getString("UserImageAvatar"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UserInfo getUser(int userID) {
        try {
            String sqlStatement = "SELECT UserID, UserLoginName, UserFirstName, UserLastName, UserEmailAddress,\n"
                    + "UserDateJoined, UserImageAvatar , UserIsAdmin FROM UserInfo\n"
                    + "WHERE UserID=?"; //'" + userLoginName + "'

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, userID);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                UserInfo user = new UserInfo();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setFirstName(rs.getNString("UserFirstName"));
                user.setLastName(rs.getNString("UserLastName"));
                user.setEmailAddress(rs.getString("UserEmailAddress"));
                user.setTimeJoined(rs.getTimestamp("UserDateJoined"));
                user.setAdmin(rs.getBoolean("UserIsAdmin"));
                user.setBase64ImageAvatar(rs.getString("UserImageAvatar"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
