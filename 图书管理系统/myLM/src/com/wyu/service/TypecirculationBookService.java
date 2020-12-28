package com.wyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.TypecirculationBook;
@Service
public interface TypecirculationBookService {

	List<TypecirculationBook> findCirculationBook() ;

}
