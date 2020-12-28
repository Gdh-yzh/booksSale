package com.wyu.pojo;

public class BookQuery extends Book {
	private int pageSize;
	private int pageNumber;
	private String publishyearEnd;
	private String entrydateEnd;
	

	public String getPublishyearEnd() {
		return publishyearEnd;
	}

	public void setPublishyearEnd(String publishyearEnd) {
		this.publishyearEnd = publishyearEnd;
	}

	public String getEntrydateEnd() {
		return entrydateEnd;
	}

	public void setEntrydateEnd(String entrydateEnd) {
		this.entrydateEnd = entrydateEnd;
	}

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

	@Override
	public String toString() {
		return "BookQuery [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", publishyearEnd=" + publishyearEnd
				+ ", entrydateEnd=" + entrydateEnd + ", toString()=" + super.toString() + "]";
	}

}
