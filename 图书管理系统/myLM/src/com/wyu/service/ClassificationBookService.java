package com.wyu.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.wyu.pojo.ClassificationBook;

@Service
public interface ClassificationBookService {

	List<ClassificationBook> findCirculationBook() ;

	ClassificationBook findClassificationBookByNumber(String number);
	

}
