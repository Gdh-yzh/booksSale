package com.wyu.pojo;

public class Rold {
    private Integer roldnumber;

    private String roldname;

    public Integer getRoldnumber() {
        return roldnumber;
    }

    public void setRoldnumber(Integer roldnumber) {
        this.roldnumber = roldnumber;
    }

    public String getRoldname() {
        return roldname;
    }

    public void setRoldname(String roldname) {
        this.roldname = roldname == null ? null : roldname.trim();
    }
}