package com.wyu.pojo;

public class BorrowAll extends Borrow {
	private Book Book;
	private Reader Reader;
	private Statusborrow Statusborrow;
	private MaxBorrow MaxBorrow;
	public Book getBook() {
		return Book;
	}
	public void setBook(Book book) {
		Book = book;
	}
	public Reader getReader() {
		return Reader;
	}
	public void setReader(Reader reader) {
		Reader = reader;
	}
	public Statusborrow getStatusborrow() {
		return Statusborrow;
	}
	public void setStatusborrow(Statusborrow statusborrow) {
		Statusborrow = statusborrow;
	}
	public MaxBorrow getMaxBorrow() {
		return MaxBorrow;
	}
	public void setMaxBorrow(MaxBorrow maxBorrow) {
		MaxBorrow = maxBorrow;
	}
	@Override
	public String toString() {
		return "BorrowAll [Book=" + Book + ", Reader=" + Reader + ", Statusborrow=" + Statusborrow + ", MaxBorrow="
				+ MaxBorrow + ", toString()=" + super.toString() + "]";
	}
 




}
