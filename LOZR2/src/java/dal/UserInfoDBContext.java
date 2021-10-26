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
import model.User;

/**
 *
 * @author Khanh
 */
public class UserInfoDBContext extends DBContext {

    public int createNewUser(User user) {
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

    public User getUser(String userLoginName) {

        try {
            String sqlStatement = "SELECT UserID, UserLoginName, UserFirstName, UserLastName, UserEmailAddress,\n"
                    + "UserDateJoined, UserImageAvatar , UserIsMod FROM UserInfo\n"
                    + "WHERE UserLoginName=?"; //'" + userLoginName + "'

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setNString(1, userLoginName);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                User user = new User();
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

    public User getUserLogin(String loginName, String password) {
        try {
            String sqlStatement = "EXEC verifyUser\n"
                    + "	@pLoginName=?,\n"
                    + "	@pPassword=?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setNString(1, loginName);
            stm.setNString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
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

    public int getTotalUsersByName(String query) {
        try {
            String sql_count_user = "SELECT COUNT(UserID) as TotalRecord FROM  UserInfo\n"
                    + "  WHERE UserLoginName LIKE '%' + ? + '%'\n"
                    + "  OR UserEmailAddress LIKE '%' + ? + '%'";
            PreparedStatement stm_count_user = connection.prepareStatement(sql_count_user);
            stm_count_user.setString(1, query);
            stm_count_user.setString(2, query);
            ResultSet rs_count_user = stm_count_user.executeQuery();
            if(rs_count_user.next()){
                return rs_count_user.getInt("TotalRecord");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<User> getUsersByName(String query, int pageIndex) {
        ArrayList<User> users = new ArrayList<>();
        int fromToRecord[] = PagingModule.calcFromToRecord(pageIndex);
        try {
            String sqlStatement = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER(ORDER BY UserLoginName ASC) AS Row_count,\n"
                    + "	UserID, UserLoginName, UserFirstName, UserLastName, UserEmailAddress,\n"
                    + "	UserDateJoined, UserImageAvatar , UserIsMod FROM UserInfo\n"
                    + "  WHERE (UserLoginName LIKE '%' + ? + '%'\n"
                    + "  OR UserEmailAddress LIKE '%' + ? + '%')"
                    + " AND UserIsActive = 1) AS Main\n"
                    + "WHERE Main.Row_count BETWEEN ? AND ?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setString(1, query);
            stm.setString(2, query);
            stm.setInt(3, fromToRecord[0]);
            stm.setInt(4, fromToRecord[1]);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setFirstName(rs.getNString("UserFirstName"));
                user.setLastName(rs.getNString("UserLastName"));
                user.setEmailAddress(rs.getString("UserEmailAddress"));
                user.setTimeJoined(rs.getTimestamp("UserDateJoined"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUser(int userID) {
        try {
            connection.setAutoCommit(false);
            String sqlStatement = "SELECT UserID, UserLoginName, UserFirstName, UserLastName, UserEmailAddress,\n"
                    + "UserDateJoined, UserImageAvatar , UserIsMod FROM UserInfo\n"
                    + "WHERE UserID=?"; //'" + userLoginName + "'

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, userID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setFirstName(rs.getNString("UserFirstName"));
                user.setLastName(rs.getNString("UserLastName"));
                user.setEmailAddress(rs.getString("UserEmailAddress"));
                user.setTimeJoined(rs.getTimestamp("UserDateJoined"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));

                String sql_count_PostThread = "SELECT (SELECT COUNT([ThreadID]) \n"
                        + "	FROM [Thread]\n"
                        + "	WHERE ThreadStartedBy=?) AS Threads,\n"
                        + "(SELECT COUNT([PostID])\n"
                        + "	FROM Post\n"
                        + "	WHERE PostUserID=?) AS Posts";
                PreparedStatement stm_count_PostThread = connection.prepareStatement(sql_count_PostThread);
                stm_count_PostThread.setInt(1, userID);
                stm_count_PostThread.setInt(2, userID);
                ResultSet rs_count_PostThread = stm_count_PostThread.executeQuery();
                if (rs_count_PostThread.next()) {
                    user.setTotalPosts(rs_count_PostThread.getInt("Posts"));
                    user.setTotalThreads(rs_count_PostThread.getInt("Threads"));
                }
                connection.commit();
                return user;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserInfoDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void updatePermission(User user) {
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

    public int updateUserInfo(User user) {
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
    
    public void updateStatus(int userID, boolean status) {
        try {
            connection.setAutoCommit(false);
            String sql_update_active = "UPDATE [UserInfo]\n"
                    + "   SET [UserIsActive] = ?\n"
                    + " WHERE UserID = ?";
            PreparedStatement stm_update_active = connection.prepareStatement(sql_update_active);
            stm_update_active.setBoolean(1, status);
            stm_update_active.setInt(2, userID);
            stm_update_active.executeUpdate();
            ReportUserDBContext reportUDBC = new ReportUserDBContext();
            reportUDBC.remove(userID);
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(FThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
