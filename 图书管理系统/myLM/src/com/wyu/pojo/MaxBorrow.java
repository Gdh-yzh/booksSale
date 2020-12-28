package com.wyu.pojo;

public class MaxBorrow {
	int maxBook;
	int readerAmount;

	public int getMaxBook() {
		return maxBook;
	}

	public void setMaxBook(int maxBook) {
		this.maxBook = maxBook;
	}

	public int getReaderAmount() {
		return readerAmount;
	}

	public void setReaderAmount(int readerAmount) {
		this.readerAmount = readerAmount;
	}

	@Override
	public String toString() {
		return "MaxBorrow [maxBook=" + maxBook + ", readerAmount=" + readerAmount + "]";
	}

}
