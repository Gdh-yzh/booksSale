package com.wyu.pojo;

import java.util.Date;

public class User {
    private String usernumber;

    private String username;

    private Date registrationdate;

    private Integer expirationdays;

    private Integer userstatusnumber;

    private String password;

    private Integer roldnumber;

    private Date enddate;

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber == null ? null : usernumber.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Integer getExpirationdays() {
        return expirationdays;
    }

    public void setExpirationdays(Integer expirationdays) {
        this.expirationdays = expirationdays;
    }

    public Integer getUserstatusnumber() {
        return userstatusnumber;
    }

    public void setUserstatusnumber(Integer userstatusnumber) {
        this.userstatusnumber = userstatusnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoldnumber() {
        return roldnumber;
    }

    public void setRoldnumber(Integer roldnumber) {
        this.roldnumber = roldnumber;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
}