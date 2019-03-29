package com.my.vo;

public class Condition {
    private  String isHot;
    private  String pname;
    private  String category;

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "isHot='" + isHot + '\'' +
                ", pname='" + pname + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
