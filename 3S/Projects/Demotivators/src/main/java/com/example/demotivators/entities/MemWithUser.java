package com.example.demotivators.entities;

import com.example.demotivators.dao_s.UsersDAO;

import java.util.ArrayList;
import java.util.Date;

public class MemWithUser extends Mem{
    private User user;

    public MemWithUser(Mem mem) {
        super(mem.getMem_id(), mem.getUser_id(), mem.getPicture(), mem.getDescription(), mem.getTags(), mem.getCreationDate(), mem.getUpdateDate(), mem.isCommentsAllowed());

        user = UsersDAO.findUser(mem.getUser_id());
    }

    public User getUser() {
        return user;
    }
}
