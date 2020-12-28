package com.wyu.pojo;

public class Statusborrow {
    private Integer statusborrownumber;

    private String statusborrowname;

    public Integer getStatusborrownumber() {
        return statusborrownumber;
    }

    public void setStatusborrownumber(Integer statusborrownumber) {
        this.statusborrownumber = statusborrownumber;
    }

    public String getStatusborrowname() {
        return statusborrowname;
    }

    public void setStatusborrowname(String statusborrowname) {
        this.statusborrowname = statusborrowname == null ? null : statusborrowname.trim();
    }
}