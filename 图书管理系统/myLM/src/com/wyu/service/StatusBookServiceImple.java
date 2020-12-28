package com.wyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyu.mapper.StatusBookMapper;
import com.wyu.pojo.StatusBook;
import com.wyu.pojo.StatusBookExample;

@Service
public class StatusBookServiceImple implements StatusBookService {
	@Autowired
	private StatusBookMapper mapper;// 定义一个变量

	@Override
	public List<StatusBook> findCirculationBook() {
		StatusBookExample example = new StatusBookExample();
		// List<Book> list = mapper.selectByExample(example);
		List<StatusBook> list = mapper.selectByExample(example);
		list.forEach(li -> System.out.println("原始数据" + li));
		return list;
	}

}
