package com.wyu.pojo;

public class ClassificationBook {
    private Integer classificationnumber;

    private String classificationletter;

    private String classificationtype;

    public Integer getClassificationnumber() {
        return classificationnumber;
    }

    public void setClassificationnumber(Integer classificationnumber) {
        this.classificationnumber = classificationnumber;
    }

    public String getClassificationletter() {
        return classificationletter;
    }

    public void setClassificationletter(String classificationletter) {
        this.classificationletter = classificationletter == null ? null : classificationletter.trim();
    }

    public String getClassificationtype() {
        return classificationtype;
    }

    public void setClassificationtype(String classificationtype) {
        this.classificationtype = classificationtype == null ? null : classificationtype.trim();
    }
}