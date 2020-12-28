package com.wyu.pojo;

public class ReaderQuery extends Reader{
	private int pageSize;
	private int pageNumber;
	private String registrationdateEnd;
	private String enddateEnd;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getRegistrationdateEnd() {
		return registrationdateEnd;
	}
	public void setRegistrationdateEnd(String registrationdateEnd) {
		this.registrationdateEnd = registrationdateEnd;
	}
	public String getEnddateEnd() {
		return enddateEnd;
	}
	public void setEnddateEnd(String enddateEnd) {
		this.enddateEnd = enddateEnd;
	}
	@Override
	public String toString() {
		return "ReaderQuery [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", registrationdateEnd="
				+ registrationdateEnd + ", enddateEnd=" + enddateEnd + "]";
	}
	
}
