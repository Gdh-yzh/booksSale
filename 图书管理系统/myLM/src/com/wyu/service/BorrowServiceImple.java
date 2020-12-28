package com.wyu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wyu.mapper.BorrowMapper;
import com.wyu.pojo.Borrow;
import com.wyu.pojo.BorrowAll;
import com.wyu.pojo.BorrowExample;
import com.wyu.pojo.BorrowExample.Criteria;

@Service
public class BorrowServiceImple implements BorrowService {
	@Autowired
	private BorrowMapper mapper;// 定义一个变量
	
	
//1.查询读者借阅本数未归还	
@Override
public int countByReaderNumber(String readernumber) {
	// TODO Auto-generated method stub
	BorrowExample example = new BorrowExample();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateTime;
	try {
		dateTime = simpleDateFormat.parse("0003-00-01");
		//读者编号和endDate为空
		example.createCriteria().andReadernumberEqualTo(readernumber).andEnddateLessThan(dateTime);
		System.out.println("我来执行这里");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//读者编号和归还日期>今日
	//example.createCriteria().andReadernumberEqualTo(readernumber).andReturndateGreaterThan(new Date());
	
	int in = mapper.countByExample(example);
	return in;
}
//2.查询读者的图书是否逾期
@Override
public int countOverdueByReaderNumber(String readernumber) {
	// TODO Auto-generated method stub
	BorrowExample example = new BorrowExample();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateTime;
	try {
		dateTime = simpleDateFormat.parse("0003-00-01");
		//读者编号和endDate为空
		example.createCriteria().andReadernumberEqualTo(readernumber).andEnddateLessThan(dateTime).andReturndateLessThan(new Date());
		System.out.println("我来执行是否逾期");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	int in = mapper.countByExample(example);
	return in;
}
//3.添加借阅信息
@Override
public int addBorrowByNumbers(Borrow borrow) {
	int in = mapper.insert(borrow);
	
	// TODO Auto-generated method stub
	return in;
}
//4.图书借阅的次数
@Override
public int borrowCount(String booknumber) {
	BorrowExample example = new BorrowExample();
	Criteria criteria = example.createCriteria();
	criteria.andBooknumberEqualTo(booknumber);
	int in = mapper.countByExample(example);
	// TODO Auto-generated method stub
	return in;
}
//5.查询未归还的图书-根据图书编号
@Override
public List<Borrow> findBorrowBybookNumberNoReturn(String booknumber) {
	// TODO Auto-generated method stub
	BorrowExample example = new BorrowExample();
	Criteria criteria = example.createCriteria();
	//图书
	criteria.andBooknumberEqualTo(booknumber);
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateTime;
	try {
		System.out.println("归还时间小于0003-00-01");
		dateTime = simpleDateFormat.parse("0003-00-01");
		//读者编号和endDate为空
		
		criteria.andEnddateLessThan(dateTime);
		System.out.println("归还时间try-catch");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<Borrow> borrow = mapper.selectByExample(example);
	
	
	return borrow;
}

//5.查询未归还的图书-根据读者编号
@Override
public List<Borrow> findBorrowByreaderNumberNoReturn(String readernumber) {
	// TODO Auto-generated method stub
	BorrowExample example = new BorrowExample();
	Criteria criteria = example.createCriteria();
	//图书
	criteria.andReadernumberEqualTo(readernumber);
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateTime;
	try {
		System.out.println("归还时间小于0003-00-01");
		dateTime = simpleDateFormat.parse("0003-00-01");
		//读者编号和endDate为空
		
		criteria.andEnddateLessThan(dateTime);
		System.out.println("归还时间try-catch");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<Borrow> borrow = mapper.selectByExample(example);
	
	
	return borrow;
}

//6.根据借阅编号查询图书
@Override
public Borrow findBorrowByNumber(String borrownumber) {
	Borrow borrow = mapper.selectByPrimaryKey(borrownumber);
	// TODO Auto-generated method stub
	return borrow;
}
@Override
public int upDateBorrow(Borrow borrow) {
	
	int in = mapper.updateByPrimaryKey(borrow);
	// TODO Auto-generated method stub
	return in;
}
//7.更新图书通过select Column
@Override
public int upDateBorrowBySelect(Borrow borrow) {
	BorrowExample example = new BorrowExample();
	Criteria criteria = example.createCriteria();
	if(borrow.getBorrownumber()!=null) {
		criteria.andBorrownumberEqualTo(borrow.getBorrownumber());
		borrow.setBorrownumber(null);
	}else {
		System.out.println("updateBook()中borrownumber为空");
	}
	int in = mapper.updateByExampleSelective(borrow, example);
	return in;
}

//8.查询借阅
@Override
public int deleteBorrowByNumbers(List<String> numbers) {
	BorrowExample example = new BorrowExample();
	Criteria criteria = example.createCriteria();
	criteria.andBorrownumberIn(numbers);
	// TODO Auto-generated method stub
	int i = mapper.deleteByExample(example);
	return i;
}

@Override
public List<BorrowAll> findBorrowsByText(String text) {

	BorrowExample example = new BorrowExample();
	String likeText = "%" + text + "%";
	Criteria criteria = example.createCriteria();
	System.out.println(text + ":text");

	criteria.andBooknumberLike(likeText);
	example.or().andBorrownumberLike(likeText);
	example.or().andReadernumberLike(likeText);
	// example.or(criteria);

	List<BorrowAll> borrow = mapper.selectByExampleBorrowAll(example);
	// List<Book> book = mapper.selectBybookExample(example);
	// TODO Auto-generated method stub
	return borrow;
}

@Override
public List<BorrowAll> findBorrowsBySort(String text, String sortName, String sortOrder) {
	// TODO Auto-generated method stub
	BorrowExample example = new BorrowExample();
	String likeText = "%" + text + "%";
	Criteria criteria = example.createCriteria();
	criteria.andBooknumberLike(likeText);
	example.or().andBorrownumberLike(likeText);
	example.or().andReadernumberLike(likeText);

	//criteria.andReadernameLike(likeText);
	//example.or().andReadernumberLike(likeText);
	if(sortName!=null&&sortOrder!=null&&!sortName.equals("")&&!sortOrder.equals("")) {
		example.setOrderByClause(sortName + " " + sortOrder);
	}

	List<BorrowAll> list = mapper.selectByExampleBorrowAll(example);

	list.forEach(li -> System.out.println("原始数据" + li));
	return list;
}		
		
//图书借阅总数:	17个
@Override
public int borrowAmounts() {
	// TODO Auto-generated method stub
	BorrowExample example = new BorrowExample();
	int in = mapper.countByExample(example);
	return in;
}
//图书未归还总数:
@Override
public int noReturnAmounts() {
	// TODO Auto-generated method stub
	BorrowExample example = new BorrowExample();
	Criteria criteria = example.createCriteria();
	//图书
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateTime;
	try {
		System.out.println("归还时间小于0003-00-01");
		dateTime = simpleDateFormat.parse("0003-00-01");
		//读者编号和endDate为空
		criteria.andEnddateLessThan(dateTime);
		System.out.println("归还时间try-catch");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	int in = mapper.countByExample(example);
	return in;
}
//单本图书最高借阅次数:	
@Override
public int topBorrowAmounts() {
	// TODO Auto-generated method stub
	
	BorrowAll ins = mapper.countMaxBookBorrow();
	//int in = Integer.parseInt(ins);
	System.out.println("11ins"+ins);
	int in = ins.getMaxBorrow().getMaxBook();
	return in;
}
//读者数量:
@Override
public int readerBorrowAmounts() {
	// TODO Auto-generated method stub
	BorrowAll ins = mapper.countReaderAmountBorrow();
	System.out.println("22ins"+ins);
	int in = ins.getMaxBorrow().getReaderAmount();
	//int in = Integer.parseInt(ins);
	return in;
}
@Override
public int deleteBorrowByNumber(String number) {
	// TODO Auto-generated method stub
		int in = mapper.deleteByPrimaryKey(number);
		return in;
	}
	
	
}
