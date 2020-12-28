package com.wyu.pojo;

import java.util.Date;

public class Reader {
    private String readernumber;

    private String readername;

    private String registrationdate;

    private Integer expirationdays;

    private Integer readerstatusnumber;

    private String password;

    private Integer readertypenumber;
    
    private Date enddate;

    public String getReadernumber() {
        return readernumber;
    }

    public void setReadernumber(String readernumber) {
        this.readernumber = readernumber == null ? null : readernumber.trim();
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername == null ? null : readername.trim();
    }

    public String getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(String registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Integer getExpirationdays() {
        return expirationdays;
    }

    public void setExpirationdays(Integer expirationdays) {
        this.expirationdays = expirationdays;
    }

    public Integer getReaderstatusnumber() {
        return readerstatusnumber;
    }

    public void setReaderstatusnumber(Integer readerstatusnumber) {
        this.readerstatusnumber = readerstatusnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getReadertypenumber() {
        return readertypenumber;
    }

    public void setReadertypenumber(Integer readertypenumber) {
        this.readertypenumber = readertypenumber;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
    	this.enddate = enddate;
    }
}