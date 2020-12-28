package com.wyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.StatusBook;
@Service
public interface StatusBookService {

	List<StatusBook> findCirculationBook() ;

}
