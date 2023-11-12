package com.example.demotivators.entities;

import java.util.Date;

public class Mem {
    private int mem_id;
    private int user_id;

    private String Picture;
    private String description;

    private Date creationDate;
    private Date updateDate;

    private boolean commentsAllowed;

    public Mem(int memId, int userId, String picture, String decription, Date creationDate, Date updateDate, boolean commentsAllowed) {
        mem_id = memId;
        user_id = userId;
        Picture = picture;
        this.description = decription;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.commentsAllowed = commentsAllowed;
    }

    public Mem(int userId, String picture, String decription, Date creationDate, Date updateDate, boolean commentsAllowed) {
        mem_id = -1;
        user_id = userId;
        Picture = picture;
        this.description = decription;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.commentsAllowed = commentsAllowed;
    }

    public boolean isCommentsAllowed() {
        return commentsAllowed;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return Picture;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getMem_id() {
        return mem_id;
    }
}
