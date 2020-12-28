package com.wyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyu.mapper.ClassificationBookMapper;
import com.wyu.pojo.ClassificationBook;
import com.wyu.pojo.ClassificationBookExample;

@Service
public class ClassificationBookServiceImple implements ClassificationBookService {
	@Autowired
	private ClassificationBookMapper mapper;// 定义一个变量

	@Override
	public List<ClassificationBook> findCirculationBook() {
		ClassificationBookExample example = new ClassificationBookExample();
		// List<Book> list = mapper.selectByExample(example);
		List<ClassificationBook> list = mapper.selectByExample(example);
		list.forEach(li -> System.out.println("原始数据" + li));
		return list;
	}

	@Override
	public ClassificationBook findClassificationBookByNumber(String number) {
		
		// TODO Auto-generated method stub
		ClassificationBook classificationBook = mapper.selectByPrimaryKey(Integer.valueOf(number));
		return classificationBook;
	}

}
