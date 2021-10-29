/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *
 * @author Khanh
 */
public class User {

    private int userID;
    private String loginName;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String avatar;
    private Timestamp timeJoined;
    private boolean active;
    private boolean moderator;
    private ArrayList<Forum> modPermission;
    private String password;
    private int totalPosts;
    private int totalThreads;
    

    public User() {
    }

    public ArrayList<Forum> getModPermission() {
        return modPermission;
    }

    public void setModPermission(ArrayList<Forum> modPermission) {
        this.modPermission = modPermission;
    }
    
    

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public int getTotalThreads() {
        return totalThreads;
    }

    public void setTotalThreads(int totalThreads) {
        this.totalThreads = totalThreads;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String url) {
        this.avatar = url;
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

    public boolean isModerator() {
        return moderator;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
