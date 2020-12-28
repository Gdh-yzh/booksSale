package com.wyu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wyu.mapper.ReaderMapper;
import com.wyu.pojo.ReaderAll;
import com.wyu.pojo.Reader;
import com.wyu.pojo.ReaderExample;
import com.wyu.pojo.ReaderExample.Criteria;
import com.wyu.pojo.ReaderQuery;

@Service
public class ReaderServiceImple implements ReaderService {
	@Autowired
	private ReaderMapper mapper;// 定义一个变量

	@Override
	public List<ReaderAll> findReaders() {
		// TODO Auto-generated method stub
		ReaderExample example = new ReaderExample();
		// List<Reader> list = mapper.selectBybookExamplePage(example, m, n);
		List<ReaderAll> list = mapper.selectByExampleAll(example);
		list.forEach(li -> System.out.println("原始数据" + li));
		return list;
	}

	@Override
	public List<ReaderAll> findReadersByText(String text) {
		String likeText = "%" + text + "%";
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernameLike(likeText);
		example.or().andReadernumberLike(likeText);
		// example.or().andExpirationdaysEqualTo(Integer.valueOf(text));
		List<ReaderAll> list = mapper.selectByExampleAll(example);
		list.forEach(li -> System.out.println("原始数据" + li));
		return list;
	}

	@Override
	public List<ReaderAll> findReadersBySort(String text, String sortName, String sortOrder) {
		// TODO Auto-generated method stub
		ReaderExample example = new ReaderExample();
		String likeText = "%" + text + "%";
		Criteria criteria = example.createCriteria();
		criteria.andReadernameLike(likeText);
		example.or().andReadernumberLike(likeText);
		example.setOrderByClause(sortName + " " + sortOrder);
		List<ReaderAll> list = mapper.selectByExampleAll(example);
		list.forEach(li -> System.out.println("原始数据" + li));
		return list;
	}
	//更新读者信息
	@Override
	public int updateReaderByNumber(Reader read) {
		int in = mapper.updateByPrimaryKey(read);
		// TODO Auto-generated method stub
		return in;
	}

	//查询读者们信息
	@Override
	public List<ReaderAll> findreaderByNumber(String readernumber) {
		// TODO Auto-generated method stub
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernumberEqualTo(readernumber);
		List<ReaderAll> list = mapper.selectByExampleAll(example);
		return list;
	}
	//统计读者数量
	@Override
	public int readerAmounts() {
		// TODO Auto-generated method stub
		ReaderExample example = new ReaderExample();
		/*
		Criteria criteria = example.createCriteria();
		criteria.andReadernumberLike("%%");
		*/
		System.out.println("统计读者数量");
		int in = mapper.countByExample(example);
		System.out.println("in:"+in);
		return in;
	}
	//查询读者信息
	//@Override
	public ReaderAll findReadersById(String id) {
		// TODO Auto-generated method stub
		
		//ReaderAll list = mapper.
		//return list;
		return null;
	}
	//图书是否存在
	@Override
	public int findReaderExist(String readernumber) {
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernumberEqualTo(readernumber);
		// TODO Auto-generated method stub
		int in = mapper.countByExample(example);
		return in;
	}
	/*更新读者select
	@Override
	public int updateReaderBySelect(Reader reader) {
		// TODO Auto-generated method stub
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		if(reader.getReadernumber()!=null) {
			criteria.andReadernumberEqualTo(reader.getReadernumber());
			reader.setReadernumber(null);
		}else {
			System.out.println("updateReader()中readernumber为空");
		}
		int in = mapper.updateByExampleSelective(reader, example);
		return in;
	}*/
	@Override
	public int insertReader(ReaderAll reader) {
		// TODO Auto-generated method stub

		return mapper.insert(reader);
	}
	@Override
	public List<ReaderAll> findReaderByNumber(String readernumber) {
	// TODO Auto-generated method stub
	ReaderExample example = new ReaderExample();
	Criteria criteria = example.createCriteria();
	criteria.andReadernumberEqualTo(readernumber);
	List<ReaderAll> list= mapper.selectByExampleAll(example);
	return list;
	}
	@Override
	public int deleteReaderByNumber(String number) {
		// TODO Auto-generated method stub
		int i = mapper.deleteByPrimaryKey(number);
		return i;
	}

	@Override
	public int deleteReaderByNumbers(List<String> numbers) {
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernumberIn(numbers);
		// TODO Auto-generated method stub
		int i = mapper.deleteByExample(example);
		return i;
	}
	
	@Override
	public List<ReaderAll> queryReaders(ReaderQuery reader) throws ParseException {
		System.out.println("reader这里："+reader.getReadername());
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if ((reader.getRegistrationdate() != null) && (!reader.getRegistrationdate().trim().equals("0"))) {
			Date dateStart = sdf.parse(reader.getRegistrationdate());
			System.out.println(reader.getRegistrationdateEnd());
			if ((reader.getRegistrationdateEnd() != null) && (!(reader.getRegistrationdateEnd().trim().equals("0")))) {
				Date dateEnd = sdf.parse(reader.getRegistrationdateEnd());
				System.out.println("dateStart:" + dateStart + ",dateEnd:" + dateEnd);
				// Date date=new Date(book.getPublishyear());
				criteria.andRegistrationdateBetween(dateStart, dateEnd);
			} else {
				criteria.andRegistrationdateEqualTo(dateStart);
				System.out.println("dateStart:" + dateStart);
			}
		}
		criteria.andReadernumberLike("%" + reader.getReadernumber() + "%");
		criteria.andReadernameLike("%" + reader.getReadername() + "%");
		if (reader.getReaderstatusnumber() != null && reader.getReaderstatusnumber() != 0) {
			System.out.println("getReaderstatusnumber");
			criteria.andReaderstatusnumberEqualTo(reader.getReaderstatusnumber());
		}
		if (reader.getReadertypenumber() != null && reader.getReadertypenumber() != 0) {
			System.out.println("getReadertypenumber");
			criteria.andReadertypenumberEqualTo(reader.getReadertypenumber());
		}
		List<ReaderAll> list = mapper.selectByExampleAll(example);
		return list;
	}
	
	@Override
	public List<ReaderAll> queryReadersBySort(ReaderQuery reader, String sortOrder, String sortName) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("reader这里："+reader.getReadername());
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if ((reader.getRegistrationdate() != null) && (!reader.getRegistrationdate().trim().equals("0"))) {
			Date dateStart = sdf.parse(reader.getRegistrationdate());
			System.out.println(reader.getRegistrationdateEnd());
			if ((reader.getRegistrationdateEnd() != null) && (!(reader.getRegistrationdateEnd().trim().equals("0")))) {
				Date dateEnd = sdf.parse(reader.getRegistrationdateEnd());
				System.out.println("dateStart:" + dateStart + ",dateEnd:" + dateEnd);
				// Date date=new Date(book.getPublishyear());
				criteria.andRegistrationdateBetween(dateStart, dateEnd);
			} else {
				criteria.andRegistrationdateEqualTo(dateStart);
				System.out.println("dateStart:" + dateStart);
			}
		}
		criteria.andReadernumberLike("%" + reader.getReadernumber() + "%");
		criteria.andReadernameLike("%" + reader.getReadername() + "%");
		if (reader.getReaderstatusnumber() != null && reader.getReaderstatusnumber() != 0) {
			System.out.println("getReaderstatusnumber");
			criteria.andReaderstatusnumberEqualTo(reader.getReaderstatusnumber());
		}
		if (reader.getReadertypenumber() != null && reader.getReadertypenumber() != 0) {
			System.out.println("getReadertypenumber");
			criteria.andReadertypenumberEqualTo(reader.getReadertypenumber());
		}
		example.setOrderByClause(sortName + " " + sortOrder);
		List<ReaderAll> list = mapper.selectByExampleAll(example);
		return list;
	}

	@Override
	public Reader findByReaderNumber(String number) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(number);
	}
}
