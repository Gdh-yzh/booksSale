package com.wyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.TypebookCf;
@Service
public interface TypebookCfService {

	List<TypebookCf> findCirculationBook() ;

}
