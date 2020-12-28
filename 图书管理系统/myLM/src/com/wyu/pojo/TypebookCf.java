package com.wyu.pojo;

public class TypebookCf {
    private Integer typebookCfnumber;

    private String typebookCfname;

    private Float overduedailymoney;

    public Integer getTypebookCfnumber() {
        return typebookCfnumber;
    }

    public void setTypebookCfnumber(Integer typebookCfnumber) {
        this.typebookCfnumber = typebookCfnumber;
    }

    public String getTypebookCfname() {
        return typebookCfname;
    }

    public void setTypebookCfname(String typebookCfname) {
        this.typebookCfname = typebookCfname == null ? null : typebookCfname.trim();
    }

    public Float getOverduedailymoney() {
        return overduedailymoney;
    }

    public void setOverduedailymoney(Float overduedailymoney) {
        this.overduedailymoney = overduedailymoney;
    }
}