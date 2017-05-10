package com.gameder.app.handlers.profiles;

import java.io.Serializable;

public class Profile implements Comparable<Profile>, Serializable{
    private final String name;
    private final String img;
    private final String email;
    private final String desc;
    private int preference;
    private boolean like;

    public Profile(String name, String img,String email, int preference, boolean like, String desc) {
        this.name = name;
        this.img = img;
        this.email = email;
        this.preference = preference;
        this.like = like;
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }

    public String getImg() {
        return this.img;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getEmail() {  return this.email;}

    public int getPreference() {
        return this.preference;
    }

    public boolean getLike() { return this.like;}


    @Override
    public int compareTo(Profile p) {
        if(this.getPreference() < p.getPreference()) {
            return  -1;
        } else if (this.getPreference() > p.getPreference()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.name + " , " + this.img + " , " + this.preference;
    }

}
