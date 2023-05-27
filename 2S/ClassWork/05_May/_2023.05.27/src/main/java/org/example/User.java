package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private String city;

    private Integer birthDate;

    private String mainInterest;
    private String BIO;
    private String favouriteColor;
    private Boolean isHavePet;
    private String futureProfession;


    public User(String name, String city, Integer birthDate, String mainInterest, String BIO, String favouriteColor, Boolean isHavePet, String futureProfession) {
        this.name = name;
        this.city = city;
        this.birthDate = birthDate;
        this.mainInterest = mainInterest;
        this.BIO = BIO;
        this.favouriteColor = favouriteColor;
        this.isHavePet = isHavePet;
        this.futureProfession = futureProfession;

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", birthDate=" + birthDate +
                ", mainInterest='" + mainInterest + '\'' +
                ", BIO='" + BIO + '\'' +
                ", favouriteColor='" + favouriteColor + '\'' +
                ", isHavePet=" + isHavePet +
                ", futureProfession='" + futureProfession + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public String getMainInterest() {
        return mainInterest;
    }

    public String getBIO() {
        return BIO;
    }

    public String getFavouriteColor() {
        return favouriteColor;
    }

    public Boolean getHavePet() {
        return isHavePet;
    }

    public String getFutureProfession() {
        return futureProfession;
    }

    public List<String> getStrings() {
        String[] s = new String[] {name, city, birthDate.toString(), mainInterest, BIO, favouriteColor, (isHavePet ? "YES" : "NO"), futureProfession};
        return Arrays.asList(s);
    }
}
