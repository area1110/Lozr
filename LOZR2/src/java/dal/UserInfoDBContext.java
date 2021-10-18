/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserInfo;

/**
 *
 * @author Khanh
 */
public class UserInfoDBContext extends DBContext {

    public int createNewUser(UserInfo user) {
        UserInfoDBContext userDBC = new UserInfoDBContext();
        if (user.getLoginName().isEmpty() || user.getPassword().isEmpty()
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
            stm.setString(2, user.getPassword());
            stm.setNString(3, user.getFirstName());
            stm.setNString(4, user.getLastName());
            stm.setString(5, user.getEmailAddress());
            stm.setString(6, user.getAvatar());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public UserInfo getUser(String userLoginName) {

        try {
            String sqlStatement = "SELECT UserID, UserLoginName, UserFirstName, UserLastName, UserEmailAddress,\n"
                    + "UserDateJoined, UserImageAvatar , UserIsMod FROM UserInfo\n"
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
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
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
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
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
                    + "UserDateJoined, UserImageAvatar , UserIsMod FROM UserInfo\n"
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
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updatePermission(UserInfo user) {
        try {
            String sql_update_isAdmin = "UPDATE [UserInfo]\n"
                    + "   SET [UserIsMod] = ?\n"
                    + " WHERE UserID = ?";
            PreparedStatement stm_update_isAdmin = connection.prepareStatement(sql_update_isAdmin);
            stm_update_isAdmin.setBoolean(1, user.isModerator());
            stm_update_isAdmin.setInt(2, user.getUserID());
            stm_update_isAdmin.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int updateUserInfo(UserInfo user) {
        UserInfoDBContext userDBC = new UserInfoDBContext();
        if (userDBC.getUser(user.getLoginName()) != null) {
            return -2;
        }
        try {
            String sqlStatement = "UPDATE [UserInfo]\n"
                    + "   SET [UserLoginName] = COALESCE(?, UserLoginName)\n"
                    + "      ,[UserPasswordHash] = COALESCE(HASHBYTES('SHA2_512', CAST(? AS VARCHAR(40))), [UserPasswordHash])\n"
                    + "      ,[UserFirstName] = COALESCE(?,[UserFirstName])\n"
                    + "      ,[UserLastName] = COALESCE(?,[UserLastName])\n"
                    + "      ,[UserEmailAddress] = COALESCE(?,[UserEmailAddress])\n"
                    + "      ,[UserImageAvatar] = COALESCE(?,[UserImageAvatar])\n"
                    + " WHERE UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sqlStatement);

            stm.setNString(1, user.getLoginName());
            stm.setString(2, user.getPassword());
            stm.setNString(3, user.getFirstName());
            stm.setNString(4, user.getLastName());
            stm.setString(5, user.getEmailAddress());
            stm.setString(6, user.getAvatar());
            stm.setInt(7, user.getUserID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

//    public void updateUserPassword(UserInfo user) {
//        try {
//            String sql_update_pass = "UPDATE [UserInfo]\n"
//                    + "   SET [UserPasswordHash] = HASHBYTES('SHA2_512', ?)\n"
//                    + " WHERE UserID = ?";
//
//            PreparedStatement stm_update_pass = connection.prepareStatement(sql_update_pass);
//            stm_update_pass.setString(1, user.getPassword());
//            stm_update_pass.setInt(2, user.getUserID());
//
//            stm_update_pass.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
