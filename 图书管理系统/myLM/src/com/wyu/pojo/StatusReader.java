package com.wyu.pojo;

public class StatusReader {
    private Integer readerstatusnumber;

    private String statusname;

    public Integer getReaderstatusnumber() {
        return readerstatusnumber;
    }

    public void setReaderstatusnumber(Integer readerstatusnumber) {
        this.readerstatusnumber = readerstatusnumber;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname == null ? null : statusname.trim();
    }
}