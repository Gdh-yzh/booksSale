package com.wyu.pojo;

public class Publishhouse {
    private Integer publishhousenumber;

    private String publishhousename;

    private String letter;

    public Integer getPublishhousenumber() {
        return publishhousenumber;
    }

    public void setPublishhousenumber(Integer publishhousenumber) {
        this.publishhousenumber = publishhousenumber;
    }

    public String getPublishhousename() {
        return publishhousename;
    }

    public void setPublishhousename(String publishhousename) {
        this.publishhousename = publishhousename == null ? null : publishhousename.trim();
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter == null ? null : letter.trim();
    }
}