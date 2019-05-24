package com.schandorf.elmenorah;

/**
 * Created by Schandorf on 4/21/2018.
 */

public class HomeItemPOJO {
    private String maintitle;
    private String subtitle;
    private int imageurl;
    private String category;

    public String getMaintitle() {
        return maintitle;
    }

    public void setMaintitle(String maintitle) {
        this.maintitle = maintitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "HomeItemPOJO{" +
                "maintitle='" + maintitle + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
