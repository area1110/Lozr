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
import model.ReportUser;
import model.User;

/**
 *
 * @author area1
 */
public class ReportUserDBContext extends DBContext {
    
    public int getTotalUser(){
        try {
            String sql = "SELECT COUNT(ID) AS TotalRecord FROM User_Report";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return rs.getInt("TotalRecord");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportUserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<ReportUser> getUsers( int pageIndex) {
        ArrayList<ReportUser> reports = new ArrayList<>();
        int fromToRecord[] = PagingModule.calcFromToRecord(pageIndex);
        try {
            String sqlStatement = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER(ORDER BY R.ReportTime DESC) AS Row_count,\n"
                    + "R.ID, R.Reason, R.ReportTime,\n"
                    + " U.UserID, U.UserLoginName, U.UserFirstName, U.UserLastName, U.UserEmailAddress,\n"
                    + " U.UserDateJoined, U.UserImageAvatar , U.UserIsMod \n"
                    + " FROM User_Report AS R INNER JOIN UserInfo AS U\n"
                    + " ON R.UserID = U.UserID\n"
                    + ") AS Main\n"
                    + "WHERE Main.Row_count BETWEEN ? AND ?";

            PreparedStatement stm = connection.prepareStatement(sqlStatement);
            stm.setInt(1, fromToRecord[0]);
            stm.setInt(2, fromToRecord[1]);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ReportUser report = new ReportUser();
                report.setId(rs.getInt("ID"));
                report.setReason(rs.getString("Reason"));
                
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setLoginName(rs.getNString("UserLoginName"));
                user.setFirstName(rs.getNString("UserFirstName"));
                user.setLastName(rs.getNString("UserLastName"));
                user.setEmailAddress(rs.getString("UserEmailAddress"));
                user.setTimeJoined(rs.getTimestamp("UserDateJoined"));
                user.setModerator(rs.getBoolean("UserIsMod"));
                user.setAvatar(rs.getString("UserImageAvatar"));
                report.setTime(rs.getTimestamp("ReportTime"));
                report.setUser(user);
  
                reports.add(report);
            }
            return reports;
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public void setReport(int userID, String reason) {
        try {
            String sql_insertReport = "INSERT INTO [User_Report]\n"
                    + "           ([UserID], [Reason])\n"
                    + "     VALUES (?, ?)";
            PreparedStatement stm_insertReport = connection.prepareStatement(sql_insertReport);
            stm_insertReport.setInt(1, userID);
            stm_insertReport.setString(2, reason);
            stm_insertReport.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void remove(int userID) {
        try {
            String sql_delete = "DELETE FROM [User_Report]\n"
                    + "      WHERE UserID=?";
            PreparedStatement stm_delete = connection.prepareStatement(sql_delete);
            stm_delete.setInt(1, userID);
            stm_delete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}
