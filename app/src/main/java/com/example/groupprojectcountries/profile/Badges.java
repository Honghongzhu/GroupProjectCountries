package com.example.groupprojectcountries.profile;

public class Badges {
       private int ID;
    private String Badge_name;
    private int Badge_image;
    private int point_requirement;
    private String continents;

    public Badges(int ID, String badge_name, int badge_image, int point_requirement, String continents) {
        this.ID = ID;
        Badge_name = badge_name;
        Badge_image = badge_image;
        this.point_requirement = point_requirement;
        this.continents = continents;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBadge_name() {
        return Badge_name;
    }

    public void setBadge_name(String badge_name) {
        Badge_name = badge_name;
    }

    public int getBadge_image() {
        return Badge_image;
    }

    public void setBadge_image(int badge_image) {
        Badge_image = badge_image;
    }

    public int getPoint_requirement() {
        return point_requirement;
    }

    public void setPoint_requirement(int point_requirement) {
        this.point_requirement = point_requirement;
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }
}
