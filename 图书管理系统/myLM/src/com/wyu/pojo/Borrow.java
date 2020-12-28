package com.wyu.pojo;

import java.util.Date;

public class Borrow {
    private String borrownumber;

    private String booknumber;

    private String readernumber;

    private Date borrowdate;

    private Date returndate;

    private Integer borrowstatusnumber;

    private Integer borrowingstimes;

    private Date enddate;

    public String getBorrownumber() {
        return borrownumber;
    }

    public void setBorrownumber(String borrownumber) {
        this.borrownumber = borrownumber == null ? null : borrownumber.trim();
    }

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber == null ? null : booknumber.trim();
    }

    public String getReadernumber() {
        return readernumber;
    }

    public void setReadernumber(String readernumber) {
        this.readernumber = readernumber == null ? null : readernumber.trim();
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public Integer getBorrowstatusnumber() {
        return borrowstatusnumber;
    }

    public void setBorrowstatusnumber(Integer borrowstatusnumber) {
        this.borrowstatusnumber = borrowstatusnumber;
    }

    public Integer getBorrowingstimes() {
        return borrowingstimes;
    }

    public void setBorrowingstimes(Integer borrowingstimes) {
        this.borrowingstimes = borrowingstimes;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
}