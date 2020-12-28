package com.wyu.pojo;

public class StatusBook {
    private Integer bookstatusnumber;

    private String bookstatus;

    public Integer getBookstatusnumber() {
        return bookstatusnumber;
    }

    public void setBookstatusnumber(Integer bookstatusnumber) {
        this.bookstatusnumber = bookstatusnumber;
    }

    public String getBookstatus() {
        return bookstatus;
    }

    public void setBookstatus(String bookstatus) {
        this.bookstatus = bookstatus == null ? null : bookstatus.trim();
    }
}