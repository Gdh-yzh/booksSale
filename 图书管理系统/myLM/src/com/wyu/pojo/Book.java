package com.wyu.pojo;


public class Book {
    private String booknumber;

    private String isbn;

    private String title;

    private String author;

    private String translator;

    private Integer publishhousenumber;

    private String summary;

    private String callnumber;

    private String imglocation;

    private Integer classificationnumber;

    private String seclassification;

    private Integer typecirculationnumber;

    private Integer borrowtimes;

    private Integer bookstatusnumber;

    private String entrydate;

    private String publishyear;

    private Integer typebookCfnumber;
    
    private Integer amount;

    
    //¶à±í
   /* 
    private String publishhousename;

    private String typecirculationname;
    private String bookstatus;
    private String typebookcfname;
    private String classificationtype;
    private String classificationletter;
  
    public String getClassificationletter() {
		return classificationletter;
	}

	public void setClassificationletter(String classificationletter) {
		this.classificationletter = classificationletter;
	}

	public String getPublishhousename() {
		return publishhousename;
	}

	public void setPublishhousename(String publishhousename) {
		this.publishhousename = publishhousename;
	}

	public String getTypecirculationname() {
		return typecirculationname;
	}

	public void setTypecirculationname(String typecirculationname) {
		this.typecirculationname = typecirculationname;
	}

	public String getBookstatus() {
		return bookstatus;
	}

	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}

	public String getTypebookcfname() {
		return typebookcfname;
	}

	public void setTypebookcfname(String typebookcfname) {
		this.typebookcfname = typebookcfname;
	}

	public String getClassificationtype() {
		return classificationtype;
	}

	public void setClassificationtype(String classificationtype) {
		this.classificationtype = classificationtype;
	}
	
 */ 
	public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber == null ? null : booknumber.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public Integer getPublishhousenumber() {
        return publishhousenumber;
    }

    public void setPublishhousenumber(Integer publishhousenumber) {
        this.publishhousenumber = publishhousenumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
    	this.callnumber = callnumber == null ? null : callnumber.trim();
    }

    public String getImglocation() {
        return imglocation;
    }

    public void setImglocation(String imglocation) {
        this.imglocation = imglocation == null ? null : imglocation.trim();
    }

    public Integer getClassificationnumber() {
        return classificationnumber;
    }

    public void setClassificationnumber(Integer classificationnumber) {
        this.classificationnumber = classificationnumber;
    }

    public String getSeclassification() {
        return seclassification;
    }

    public void setSeclassification(String seclassification) {
        this.seclassification = seclassification == null ? null : seclassification.trim();
    }

    public Integer getTypecirculationnumber() {
        return typecirculationnumber;
    }

    public void setTypecirculationnumber(Integer typecirculationnumber) {
        this.typecirculationnumber = typecirculationnumber;
    }

    public Integer getBorrowtimes() {
        return borrowtimes;
    }

    public void setBorrowtimes(Integer borrowtimes) {
        this.borrowtimes = borrowtimes;
    }

    public Integer getBookstatusnumber() {
        return bookstatusnumber;
    }

    public void setBookstatusnumber(Integer bookstatusnumber) {
        this.bookstatusnumber = bookstatusnumber;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate;
    }

    public String getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(String publishyear) {
        this.publishyear = publishyear;
    }

    public Integer getTypebookCfnumber() {
        return typebookCfnumber;
    }

    public void setTypebookCfnumber(Integer typebookCfnumber) {
        this.typebookCfnumber = typebookCfnumber;
    }

	@Override
	public String toString() {
		return "Book [booknumber=" + booknumber + ", isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", translator=" + translator + ", publishhousenumber=" + publishhousenumber + ", summary=" + summary
				+ ", callnumber=" + callnumber + ", imglocation=" + imglocation + ", classificationnumber="
				+ classificationnumber + ", seclassification=" + seclassification + ", typecirculationnumber="
				+ typecirculationnumber + ", borrowtimes=" + borrowtimes + ", bookstatusnumber=" + bookstatusnumber
				+ ", entrydate=" + entrydate + ", publishyear=" + publishyear + ", typebookCfnumber=" + typebookCfnumber
				+ "]";
	}

	
	
    
}