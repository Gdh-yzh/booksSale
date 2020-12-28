package com.wyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyu.mapper.TypebookCfMapper;
import com.wyu.pojo.TypebookCf;
import com.wyu.pojo.TypebookCfExample;

@Service
public class TypebookCfServiceImple implements TypebookCfService {
	@Autowired
	private TypebookCfMapper mapper;// 定义一个变量

	@Override
	public List<TypebookCf> findCirculationBook() {
		TypebookCfExample example = new TypebookCfExample();
		// List<Book> list = mapper.selectByExample(example);
		List<TypebookCf> list = mapper.selectByExample(example);
		list.forEach(li -> System.out.println("原始数据" + li));
		return list;
	}

}
