package com.wyu.service;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.wyu.mapper.BookMapper;
import com.wyu.pojo.Book;
import com.wyu.pojo.BookAll;
import com.wyu.pojo.BookExample;
import com.wyu.pojo.BookQuery;
import com.wyu.pojo.BookExample.Criteria;

@Service
public class BookServiceImple implements BookService {
	@Autowired
	private BookMapper mapper;// 定义一个变量
	@Override
	public List<BookAll> findBooks() {
		BookExample example = new BookExample();
		// List<Book> list = mapper.selectBybookExamplePage(example, m, n);
		List<BookAll> list = mapper.selectBybookExample(example);
		list.forEach(li -> System.out.println("原始数据" + li));
		return list;
	}

	@Override
	public long countBook() {
		BookExample example = new BookExample();
		// TODO Auto-generated method stub
		return mapper.countByExample(example);
	}

	@Override
	public int insertBook(BookAll book) {
		// TODO Auto-generated method stub

		return mapper.insert(book);
	}

	@Override
	public int updateBookByNumber(BookAll book) {
		int in = mapper.updateByPrimaryKey(book);
		// TODO Auto-generated method stub
		return in;
	}

	@Override
	public int deleteBookByNumber(String number) {
		// TODO Auto-generated method stub
		int i = mapper.deleteByPrimaryKey(number);
		return i;
	}

	@Override
	public int deleteBookByNumbers(List<String> numbers) {
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		criteria.andBooknumberIn(numbers);
		// TODO Auto-generated method stub
		int i = mapper.deleteByExample(example);
		return i;
	}

	@Override
	public List<BookAll> findBooksByText(String text) {
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("entrydate desc");
		System.out.println(text + ":text");
		criteria.andTitleLike("%" + text + "%");
		example.or().andIsbnLike("%" + text + "%");
		example.or().andBooknumberLike("%" + text + "%");
		// example.or(criteria);
		List<BookAll> book = mapper.selectBybookExample(example);
		// List<Book> book = mapper.selectBybookExample(example);
		// TODO Auto-generated method stub
		return book;
	}

	@Override
	public List<BookAll> findBooksBySort(String text, String sortName, String sortOrder) {
		BookExample example = new BookExample();
		// Criteria criteria = example.createCriteria();
		example.setOrderByClause(sortName + " " + sortOrder);
		Criteria criteria = example.createCriteria();
		System.out.println(text + ":text");
		criteria.andTitleLike("%" + text + "%");
		example.or().andIsbnLike("%" + text + "%");
		// example.setOrderByClause(sortName+" "+sortOrder);
		// example.
		List<BookAll> book = mapper.selectBybookExample(example);
		// TODO Auto-generated method stub
		return book;
	}

	@Override
	public List<BookAll> queryBooks(BookQuery book) throws ParseException {
		System.out.println("book这里："+book.getTitle());
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		/*SimpleDateFormat sf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if ((book.getPublishyear() != null) && (!book.getPublishyear().trim().equals("0"))) {
			Date dateStart = sf.parse(book.getPublishyear());
			System.out.println(book.getPublishyearEnd());
			if ((book.getPublishyearEnd() != null) && (!(book.getPublishyearEnd().trim().equals("0")))) {
				Date dateEnd = sf.parse(book.getPublishyearEnd());
				System.out.println("dateStart:" + dateStart + ",dateEnd:" + dateEnd);
				// Date date=new Date(book.getPublishyear());
				criteria.andPublishyearBetween(dateStart, dateEnd);
			} else {
				criteria.andPublishyearEqualTo(dateStart);
				System.out.println("dateStart:" + dateStart);
			}
		}
		if ((book.getEntrydate() != null) && (!book.getEntrydate().trim().equals("0"))) {
			Date dateStart; 
			try {
				dateStart= sdf.parse(book.getEntrydate());
			} catch (Exception e) {
				dateStart = sdf.parse("0003-00-01");
			}
			System.out.println(book.getEntrydateEnd());
			if ((book.getEntrydateEnd() != null) && (!(book.getEntrydateEnd().trim().equals("0")))) {
				Date dateEnd;
				try {
					dateEnd= sdf.parse(book.getEntrydateEnd());
				} catch (Exception e) {
					dateEnd = sdf.parse("0003-00-01");
				}
				System.out.println("dateStart:" + dateStart + ",dateEnd:" + dateEnd);
				// Date date=new Date(book.getPublishyear());
				criteria.andEntrydateBetween(dateStart, dateEnd);
			} else {
				criteria.andEntrydateEqualTo(dateStart);
				System.out.println("dateStart:" + dateStart);
			}
		}*/
		criteria.andBooknumberLike("%" + book.getBooknumber() + "%");
		criteria.andIsbnLike("%" + book.getIsbn() + "%");
		criteria.andTitleLike("%" + book.getTitle() + "%");
		criteria.andAuthorLike("%" + book.getAuthor() + "%");
		criteria.andTranslatorLike("%" + book.getTranslator() + "%");
		criteria.andCallnumberLike("%" + book.getCallnumber() + "%");
		if (book.getBorrowtimes() != null) {
			criteria.andBorrowtimesEqualTo(book.getBorrowtimes());
		}
		if (book.getTypecirculationnumber() != null && (book.getTypecirculationnumber() != 0)) {
			System.out.println("getTypecirculationnumber" + book.getTypecirculationnumber());
			criteria.andTypecirculationnumberEqualTo(book.getTypecirculationnumber());
		}
		if (book.getTypebookCfnumber() != null && book.getTypebookCfnumber() != 0) {
			System.out.println("getTypebookCfnumber" + book.getTypebookCfnumber());
			criteria.andTypebookCfnumberEqualTo(book.getTypebookCfnumber());
		}
		if (book.getPublishhousenumber() != null && book.getPublishhousenumber() != 0) {
			System.out.println("getPublishhousenumber");
			criteria.andPublishhousenumberEqualTo(book.getPublishhousenumber());
		}
		if (book.getClassificationnumber() != null && book.getClassificationnumber() != 0) {
			System.out.println("getClassificationnumber");
			criteria.andClassificationnumberEqualTo(book.getClassificationnumber());
		}
		if (book.getBookstatusnumber() != null && book.getBookstatusnumber() != 0) {
			System.out.println("getBookstatusnumber");
			criteria.andBookstatusnumberEqualTo(book.getBookstatusnumber());
		}
		List<BookAll> list = mapper.selectBybookExample(example);
		return list;
	}
	
	@Override
	public List<BookAll> queryBooksBySort(BookQuery book, String sortOrder, String sortName) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("book这里："+book.getTitle());
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		/*SimpleDateFormat sf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if ((book.getPublishyear() != null) && (!book.getPublishyear().trim().equals("0"))) {
			Date dateStart = sf.parse(book.getPublishyear());
			System.out.println(book.getPublishyearEnd());
			if ((book.getPublishyearEnd() != null) && (!(book.getPublishyearEnd().trim().equals("0")))) {
				Date dateEnd = sf.parse(book.getPublishyearEnd());
				System.out.println("dateStart:" + dateStart + ",dateEnd:" + dateEnd);
				// Date date=new Date(book.getPublishyear());
				criteria.andPublishyearBetween(dateStart, dateEnd);
			} else {
				criteria.andPublishyearEqualTo(dateStart);
				System.out.println("dateStart:" + dateStart);
			}
		}
		if ((book.getEntrydate() != null) && (!book.getEntrydate().trim().equals("0"))) {
			Date dateStart; 
			try {
				dateStart= sdf.parse(book.getEntrydate());
			} catch (Exception e) {
				dateStart = sdf.parse("0000-00-00");
			}
			System.out.println(book.getEntrydateEnd());
			if ((book.getEntrydateEnd() != null) && (!(book.getEntrydateEnd().trim().equals("0")))) {
				Date dateEnd;
				try {
					dateEnd= sdf.parse(book.getEntrydateEnd());
				} catch (Exception e) {
					dateEnd = sdf.parse("0000-00-00");
				}
				System.out.println("dateStart:" + dateStart + ",dateEnd:" + dateEnd);
				// Date date=new Date(book.getPublishyear());
				criteria.andEntrydateBetween(dateStart, dateEnd);
			} else {
				criteria.andEntrydateEqualTo(dateStart);
				System.out.println("dateStart:" + dateStart);
			}
		}*/
		criteria.andBooknumberLike("%" + book.getBooknumber() + "%");
		criteria.andIsbnLike("%" + book.getIsbn() + "%");
		criteria.andTitleLike("%" + book.getTitle() + "%");
		criteria.andAuthorLike("%" + book.getAuthor() + "%");
		criteria.andTranslatorLike("%" + book.getTranslator() + "%");
		if (book.getBorrowtimes() != null) {
			criteria.andBorrowtimesEqualTo(book.getBorrowtimes());
		}
		if (book.getTypecirculationnumber() != null && (book.getTypecirculationnumber() != 0)) {
			System.out.println("getTypecirculationnumber" + book.getTypecirculationnumber());
			criteria.andTypecirculationnumberEqualTo(book.getTypecirculationnumber());
		}
		if (book.getTypebookCfnumber() != null && book.getTypebookCfnumber() != 0) {
			System.out.println("getTypebookCfnumber" + book.getTypebookCfnumber());
			criteria.andTypebookCfnumberEqualTo(book.getTypebookCfnumber());
		}
		if (book.getPublishhousenumber() != null && book.getPublishhousenumber() != 0) {
			System.out.println("getPublishhousenumber");
			criteria.andPublishhousenumberEqualTo(book.getPublishhousenumber());
		}
		if (book.getClassificationnumber() != null && book.getClassificationnumber() != 0) {
			System.out.println("getClassificationnumber");
			criteria.andClassificationnumberEqualTo(book.getClassificationnumber());
		}
		if (book.getBookstatusnumber() != null && book.getBookstatusnumber() != 0) {
			System.out.println("getBookstatusnumber");
			criteria.andBookstatusnumberEqualTo(book.getBookstatusnumber());
		}
		example.setOrderByClause(sortName + " " + sortOrder);
		List<BookAll> list = mapper.selectBybookExample(example);
		return list;
	}

@Override
	public List<BookAll> findBookByNumber(String booknumber) {
	// TODO Auto-generated method stub
	BookExample example = new BookExample();
	Criteria criteria = example.createCriteria();
	criteria.andBooknumberEqualTo(booknumber);
	List<BookAll> list= mapper.selectBybookExample(example);
	return list;
}

@Override
public Book findBookByKey(String booknumber) {
	// TODO Auto-generated method stub
	Book book= mapper.selectByPrimaryKey(booknumber);
	return book;
}

//更新图书根据key
@Override
public int updateBookByNumber(Book book) {
	
	// TODO Auto-generated method stub
	int in = mapper.updateByPrimaryKey(book);
	return in;
}

//更新图书select
@Override
public int updateBookBySelect(Book book) {
	// TODO Auto-generated method stub
//	Book book2 = new Book();
	BookExample example = new BookExample();
	Criteria criteria = example.createCriteria();
	if(book.getBooknumber()!=null) {
		criteria.andBooknumberEqualTo(book.getBooknumber());
		book.setBooknumber(null);
	}else {
		System.out.println("updateBook()中booknumber为空");
	}
	int in = mapper.updateByExampleSelective(book, example);
	return in;
}

//图书是否存在
@Override
public int findBookExist(String booknumber) {
	BookExample example = new BookExample();
	Criteria criteria = example.createCriteria();
	criteria.andBooknumberEqualTo(booknumber);
	// TODO Auto-generated method stub
	int in = mapper.countByExample(example);
	return in;
}

//导入图书
@Override
public List<Book> addBooks(MultipartFile file) throws Exception {
	System.out.println("。。。。我来到这里了。。。");
	//int result = 0;
	//存放excel表中所有user数据
	//List<BookAll> studentList = new ArrayList<>();
	//file.getOriginalFilename()方法 得到上传时的文件名
	String fileName = file.getOriginalFilename();
	//截取文件名的后缀
	String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
	//file.getInputStream()方法  返回InputStream对象 读取文件的内容
	InputStream ins = file.getInputStream();
	Workbook wb = null;
	/*判断文件后缀
	XSSF － 提供读写Microsoft Excel OOXML XLSX格式档案的功能。
	HSSF － 提供读写Microsoft Excel XLS格式档案的功能。*/
	if(suffix.equals("xlsx")){
		wb = new XSSFWorkbook(ins);
		//wb = new HSSFWorkbook(ins);
	}else{
		wb = new HSSFWorkbook(ins);
	}
	//获取excel表单的sheet对象
	Sheet sheet = wb.getSheetAt(0);
	//如果sheet不为空，就开始遍历表中的数据
	List<Book> list = new ArrayList<Book>();	
	if(null != sheet){
		//line = 2 :从表的第三行开始获取记录  		
		for(int line = 1; line <= sheet.getLastRowNum();line++){
		//excel表单的sheet的行对象
			Row row = sheet.getRow(line);
			//如果某行为空，跳出本行
			if(null == row){
				continue;
			}
			Book book = new Book();
			//获取第一个单元格的内容
			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			book.setBooknumber(row.getCell(0).getStringCellValue()) ;
			//获取第二个单元格的内容
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);          
			book.setIsbn(row.getCell(1).getStringCellValue()) ;
			//获取第三个单元格的内容
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			book.setTitle(row.getCell(2).getStringCellValue()) ;          
			//获取第四个单元格的内容
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
			book.setAuthor(row.getCell(3).getStringCellValue());        
			//获取第五个单元格的内容
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
			book.setTranslator(row.getCell(4).getStringCellValue()); 
			//获取第六个单元格的内容
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			book.setPublishhousenumber(Integer.valueOf(row.getCell(5).getStringCellValue())) ;      
			//获取第七个单元格的内容
		 	row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			book.setPublishyear(row.getCell(6).getStringCellValue()) ; 			   
			//获取第八个单元格的内容
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
			book.setCallnumber(row.getCell(7).getStringCellValue()) ; 
			//获取第九个单元格的内容
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
			book.setTypebookCfnumber(Integer.valueOf(row.getCell(8).getStringCellValue())) ;
			//获取第十个单元格的内容
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
			book.setClassificationnumber(Integer.valueOf(row.getCell(9).getStringCellValue())) ;
			//获取第十一个单元格的内容
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			book.setTypecirculationnumber(Integer.valueOf(row.getCell(10).getStringCellValue())) ;    
			//获取第十二个单元格的内容
			row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
			book.setBookstatusnumber(Integer.valueOf(row.getCell(11).getStringCellValue())) ; 
			//获取第十二个单元格的内容
			row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
			book.setSummary(row.getCell(12).getStringCellValue()) ;
			//获取第十四个单元格的内容
			row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
			book.setAmount(Integer.valueOf(row.getCell(13).getStringCellValue())) ;                 
		 	System.out.println(book.toString());          
			list.add(book);
			}
		}
	list.forEach(li -> System.out.println("原始数据" + li));  
	return list;
	}

	//批量添加图书
	public int addManyBooks(List<Book> list) {
		int i = mapper.insertMany(list);
		System.out.println(i);
		return i;
	}
}





