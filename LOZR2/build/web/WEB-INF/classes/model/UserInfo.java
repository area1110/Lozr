/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;


/**
 *
 * @author Khanh
 */
public class UserInfo {

    private int userID;
    private String loginName;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String base64ImageAvatar;
    private Timestamp timeJoined;
    private boolean active;
    private boolean admin;

    public UserInfo() {
    }

    public String getBase64ImageAvatar() {
        return base64ImageAvatar;
    }

    public void setBase64ImageAvatar(String base64ImageAvatar) {
        this.base64ImageAvatar = base64ImageAvatar;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Timestamp getTimeJoined() {
        return timeJoined;
    }

    public void setTimeJoined(Timestamp timeJoined) {
        this.timeJoined = timeJoined;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
