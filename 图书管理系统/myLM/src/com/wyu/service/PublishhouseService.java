package com.wyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyu.pojo.Publishhouse;
@Service
public interface PublishhouseService {

	List<Publishhouse> findCirculationBook() ;

}
