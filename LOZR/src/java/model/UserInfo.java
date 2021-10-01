/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Column;
import javax.websocket.Decoder;

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
    private Date dateJoined;
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

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
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
