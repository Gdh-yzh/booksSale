package com.wyu.pojo;

public class TypecirculationBook {
    private Integer typecirculationnumber;

    private String typecirculationname;

    public Integer getTypecirculationnumber() {
        return typecirculationnumber;
    }

    public void setTypecirculationnumber(Integer typecirculationnumber) {
        this.typecirculationnumber = typecirculationnumber;
    }

    public String getTypecirculationname() {
        return typecirculationname;
    }

    public void setTypecirculationname(String typecirculationname) {
        this.typecirculationname = typecirculationname == null ? null : typecirculationname.trim();
    }
}