package com.wyu.pojo;

public class TypeReader {
    private Integer readertypenumber;

    private String readertype;

    private Integer borrowamount;

    private Integer borrowdays;

    private Integer renewtimestimes;

    private Integer renewdays;

    private Integer renewamount;

    public Integer getReadertypenumber() {
        return readertypenumber;
    }

    public void setReadertypenumber(Integer readertypenumber) {
        this.readertypenumber = readertypenumber;
    }

    public String getReadertype() {
        return readertype;
    }

    public void setReadertype(String readertype) {
        this.readertype = readertype == null ? null : readertype.trim();
    }

    public Integer getBorrowamount() {
        return borrowamount;
    }

    public void setBorrowamount(Integer borrowamount) {
        this.borrowamount = borrowamount;
    }

    public Integer getBorrowdays() {
        return borrowdays;
    }

    public void setBorrowdays(Integer borrowdays) {
        this.borrowdays = borrowdays;
    }

    public Integer getRenewtimestimes() {
        return renewtimestimes;
    }

    public void setRenewtimestimes(Integer renewtimestimes) {
        this.renewtimestimes = renewtimestimes;
    }

    public Integer getRenewdays() {
        return renewdays;
    }

    public void setRenewdays(Integer renewdays) {
        this.renewdays = renewdays;
    }

    public Integer getRenewamount() {
        return renewamount;
    }

    public void setRenewamount(Integer renewamount) {
        this.renewamount = renewamount;
    }
}