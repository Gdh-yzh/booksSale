package com.wyu.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.ReaderAll;
import com.wyu.pojo.ReaderQuery;
import com.wyu.pojo.Reader;

@Service
public interface ReaderService {

	List<ReaderAll> findReaders();

	List<ReaderAll> findReadersByText(String text);

	List<ReaderAll> findReadersBySort(String text, String sortName, String sortOrder);

	int updateReaderByNumber(Reader read);

	List<ReaderAll> findreaderByNumber(String readernumber);

	int readerAmounts();

	ReaderAll findReadersById(String id);

	//int deleteReaderByNumber(String number);
	int findReaderExist(String readernumber);

	int insertReader(ReaderAll reader);

	List<ReaderAll> findReaderByNumber(String readernumber);

	int deleteReaderByNumber(String number);

	int deleteReaderByNumbers(List<String> numbers);

	List<ReaderAll> queryReaders(ReaderQuery reader) throws ParseException;

	List<ReaderAll> queryReadersBySort(ReaderQuery reader, String sortOrder, String sortName) throws ParseException;

	Reader findByReaderNumber(String number);

	//int updateReaderBySelect(Reader reader);

}
