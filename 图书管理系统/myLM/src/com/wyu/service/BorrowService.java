package com.wyu.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.wyu.pojo.Borrow;
import com.wyu.pojo.BorrowAll;

@Service
public interface BorrowService {

	int countByReaderNumber(String readernumber);

	int countOverdueByReaderNumber(String readernumber);

	int borrowCount(String booknumber);


	List<Borrow> findBorrowBybookNumberNoReturn(String booknumber);
	
	List<Borrow> findBorrowByreaderNumberNoReturn(String readernumber);

	int addBorrowByNumbers(Borrow borrow);

	Borrow findBorrowByNumber(String borrownumber);

	int upDateBorrow(Borrow borrow);

	int upDateBorrowBySelect(Borrow borrow);

	List<BorrowAll> findBorrowsBySort(String text, String sortName, String sortOrder);

	int borrowAmounts();

	int noReturnAmounts();

	int topBorrowAmounts();

	int readerBorrowAmounts();

	int deleteBorrowByNumber(String number);

	int deleteBorrowByNumbers(List<String> numbers);

	List<BorrowAll> findBorrowsByText(String text);


}
