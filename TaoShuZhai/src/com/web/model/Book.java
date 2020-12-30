package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book extends Product{
	
	private int id;
	private String author;
	private String publishing;
	private long publishTime;
	private String wordNumber; 
	private String whichEdtion; 
	private String totalPage; 
	private long printTime;
	private String printNumber; 
	private String isbn;
	private String authorSummary;
	private String catalogue;
	
	public String getPublishDt(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(publishTime));
	}
	
	public String getPrintDt(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(printTime));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}


	public String getWordNumber() {
		return wordNumber;
	}

	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

	public String getWhichEdtion() {
		return whichEdtion;
	}

	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public long getPrintTime() {
		return printTime;
	}

	public void setPrintTime(long printTime) {
		this.printTime = printTime;
	}

	public String getPrintNumber() {
		return printNumber;
	}

	public void setPrintNumber(String printNumber) {
		this.printNumber = printNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorSummary() {
		return authorSummary;
	}

	public void setAuthorSummary(String authorSummary) {
		this.authorSummary = authorSummary;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	
	
	
}
