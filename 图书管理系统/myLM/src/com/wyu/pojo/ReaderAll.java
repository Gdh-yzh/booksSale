package com.wyu.pojo;

public class ReaderAll extends Reader {
	private StatusReader StatusReader;
	private TypeReader TypeReader;
	private StatusBook StatusBook;
	
	
	public StatusReader getStatusReader() {
		return StatusReader;
	}



	public void setStatusReader(StatusReader statusReader) {
		StatusReader = statusReader;
	}



	public TypeReader getTypeReader() {
		return TypeReader;
	}



	public void setTypeReader(TypeReader typeReader) {
		TypeReader = typeReader;
	}



	public StatusBook getStatusBook() {
		return StatusBook;
	}



	public void setStatusBook(StatusBook statusBook) {
		StatusBook = statusBook;
	}

	
	@Override
	public String toString() {
		return "ReaderAll [StatusReader=" + StatusReader + ", TypeReader=" + TypeReader + ", StatusBook=" + StatusBook
				+ ", toString()=" + super.toString() + "]";
	}



	



	
	
}
