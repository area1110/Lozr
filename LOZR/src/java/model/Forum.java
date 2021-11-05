/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Khanh
 */
public class Forum {
    private int forumID;
    private String name;
    private String cover;
    private boolean active;
    private int newPosts;
    private int newThreads;

    public Forum() {
    }

    public int getNewPosts() {
        return newPosts;
    }

    public void setNewPosts(int newPosts) {
        this.newPosts = newPosts;
    }

    public int getNewThreads() {
        return newThreads;
    }

    public void setNewThreads(int newThreads) {
        this.newThreads = newThreads;
    }
    
    public String getCover() {
        return cover;
    }

    public void setCover(String url) {
        this.cover = url;
    }

    

    public int getForumID() {
        return forumID;
    }

    public void setForumID(int forumID) {
        this.forumID = forumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
    
}
