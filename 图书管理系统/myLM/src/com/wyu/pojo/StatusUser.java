package com.wyu.pojo;

public class StatusUser {
    private Integer userstatusnumber;

    private String statusname;

    public Integer getUserstatusnumber() {
        return userstatusnumber;
    }

    public void setUserstatusnumber(Integer userstatusnumber) {
        this.userstatusnumber = userstatusnumber;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname == null ? null : statusname.trim();
    }
}