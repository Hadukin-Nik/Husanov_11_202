package com.example.demotivators.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.demotivators.entities.User.Role.fromInteger;

public class User {
    public enum Role{
        Commoner, Admin, SuperAdmin;
        public static Role fromInteger(int x) {
            switch(x) {
                case 0:
                    return Commoner;
                case 1:
                    return Admin;
                case 2:
                    return SuperAdmin;
            }
            return null;
        }

        public static Integer toInt(Role x) {
            switch (x){
                case Commoner:
                    return 0;
                case Admin:
                    return 1;
                case SuperAdmin:
                    return 2;
            }
            return -1;
        }
    }

    private String name;
    private String nickname;

    private String telephone_number;


    private Date date_registration;

    private Role role;

    private long userId;

    public User(String name, String nickname, String telephoneNumber, Date dateRegistration, int role, long userId) {
        this.name = name;
        this.nickname = nickname;

        this.date_registration = dateRegistration;

        this.role = fromInteger(role);
        telephone_number = telephoneNumber;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }


    public String getNickname() {
        return nickname;
    }

    public Date getDate_registration() {
        return date_registration;
    }

    public Role getRole() {
        return role;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public long getUserId() {
        return userId;
    }

}
