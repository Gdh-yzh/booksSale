package com.wyu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyu.pojo.Book;
import com.wyu.pojo.BookAll;
import com.wyu.pojo.BookQuery;
import com.wyu.service.BookService;

@Controller
public class BookController{
	//private static final long serialVersionUID = 1L;
	
	@Autowired
	private BookService service;

	// 1.查询图书
	@RequestMapping(value = "/findBooks", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String findBooks(int pageNumber, int pageSize) {
		System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize);
		// (2,10)2为页码，10位每页的条数
		com.github.pagehelper.Page<Object> page = PageHelper.startPage(pageNumber, pageSize);

		List<BookAll> list = service.findBooks();

		list.forEach(li -> System.out.println(li));
		PageInfo<BookAll> info = new PageInfo<BookAll>(list);
		// 得到总记录数
		long total = info.getTotal();
		// 将list集合封装成json数据
		String jsonlist = JSON.toJSONString(list);
		// 构建完成的json数据
		String json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
		System.out.println(",info:" + info);
		System.out.println("page:" + page);

		return json;

	}

	// 2.添加图书
	@RequestMapping(value = "/addBook", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String addBook(BookAll book) {
		// 时间戳
		Long timeStamp = System.currentTimeMillis();
		book.setBooknumber(timeStamp.toString());
		System.out.println("qqqq" + book);
		// 当前时间
		book.setEntrydate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		book.setBorrowtimes(0);
		int in = service.insertBook(book);
		String Json="";
			if (in > 0) {
				List<BookAll> bookall = service.findBookByNumber(book.getBooknumber());
				Json = JSON.toJSONString(bookall);
				System.out.println("Json:" + Json);
				return Json;
			} 
		return Json;
	}

	// 3.更新图书信息
	@RequestMapping(value = "/updateBook", produces = "appliction/text;charset=utf-8")
	@ResponseBody()
	public String updateBook(BookAll book) {
		System.out.println("修改的用户信息是" + book);

		int in = service.updateBookByNumber(book);
		String updateInfo = "0";
		if (in > 0) {
			System.out.println("修改成功");
			updateInfo = "1";
		}
		return updateInfo;
	}

	// 4.删除图书
	@RequestMapping(value = "/deleteBook", produces = "appliction/text;charset=utf-8")
	@ResponseBody()
	public String deleteBook(String number) {
		System.out.println("要删除的number:" + number);
		// 调用service完成删除
		// int in = service.deleteBookByNumber("123");
		int in = service.deleteBookByNumber(number);
		// 定义一个变量用来存放删除结果
		// String deleteRes = "删除失败";
		if (in > 0) {
			System.out.println("删除成功");
			// deleteRes = in;
		}
		System.out.println(in);
		return in + "";
	}

	// 5.删除一些图书
	@RequestMapping(value = "/deleteBooks", produces = "appliction/json;charset=utf8")
	@ResponseBody()
	public String deleteBooks(@RequestBody String jsonNumbers) {
		System.out.println("deleteBooks要删除的numbers:" + jsonNumbers);
		// 将json的字符串转化为list
		List<String> numbers = (List<String>) JSONArray.parseArray(jsonNumbers, String.class);

		// 调用service完成删除
		int in = service.deleteBookByNumbers(numbers);
		// int in = 0;
		// 定义一个变量用来存放删除结果
		// String deleteRes = "删除失败";
		if (in > 0) {
			System.out.println("删除成功");
			// deleteRes = in;
		}
		System.out.println(in);
		return in + "";
	}

	// 6.根据条件查询图书
	@RequestMapping(value = "/findBooksByText", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String findBooksByText(int pageNumber, int pageSize, String text) {
		System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize + ",text=" + text);
		System.out.println("text" + text);
		// (2,10)2为页码，10位每页的条数
		PageHelper.startPage(pageNumber, pageSize);
		List<BookAll> list = service.findBooksByText(text);
		// list.forEach(li -> System.out.println(li));
		PageInfo<BookAll> info = new PageInfo<>(list);
		// 得到总记录数
		long total = info.getTotal();
		// 将list集合封装成json数据
		String jsonlist = JSON.toJSONString(list);
		// 构建完成的json数据
		String json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
		System.out.println("json=" + json);
		System.out.println("根据标题查询图书");
		System.out.println("info" + info);
		return json;

	}

	// 7.排序
	@RequestMapping(value = "/findBooksBySort", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String findBooksBySort(int pageNumber, int pageSize, String text, String sortOrder, String sortName,
			String title) {
		System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize + ",text=" + text + ",title=" + title);
		System.out.println("text=" + text + ",sortName=" + sortName + ",sortOrder=" + sortOrder);
		// (2,10)2为页码，10位每页的条数
		PageHelper.startPage(pageNumber, pageSize);
		List<BookAll> list = service.findBooksBySort(text, sortName, sortOrder);
		// list.forEach(li -> System.out.println(li));
		PageInfo<BookAll> info = new PageInfo<>(list);
		// 得到总记录数
		long total = info.getTotal();
		// 将list集合封装成json数据
		String jsonlist = JSON.toJSONString(list);
		// 构建完成的json数据
		String json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
		System.out.println("json=" + json);
		System.out.println("info" + info);
		return json;

	}

	// 8.多条件查询图书
	@RequestMapping(value = "/queryBooks", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String queryBooks(BookQuery book) {
		System.out.println(book.toString());
		System.out.println(book);
		// (2,10)2为页码，10位每页的条数
		int pageNumber = book.getPageNumber();
		int pageSize = book.getPageSize();
		com.github.pagehelper.Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
		List<BookAll> list;
		String json = "";
		System.out.println(pageNumber + "," + pageSize);
		try {
			list = service.queryBooks(book);
			list.forEach(li -> System.out.println(li));
			PageInfo<BookAll> info = new PageInfo<>(list);
			// 得到总记录数
			long total = info.getTotal();
			// 将list集合封装成json数据
			String jsonlist = JSON.toJSONString(list);
			json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
			System.out.println("我来到的这里对吧,total" + total);
			System.out.println("我来到的这里对吧,info" + info);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("page:" + page);
		// 构建完成的json数据
		System.out.println("多条件查询");
		System.out.println("json=" + json);
		return json;

	}

	@RequestMapping(value = "/findBooksQuery", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String findBooksQuery(int pageNumber, int pageSize, String bookString) {
		try {
			bookString = URLDecoder.decode(bookString, "utf-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		HashMap<String, String> bookMap = form2Map(bookString);
		BookQuery book = JSON.parseObject(JSON.toJSONString(bookMap), BookQuery.class);
		Book books = JSON.parseObject(JSON.toJSONString(bookMap), Book.class);
		System.out.println(book);
		System.out.println(books);

		// System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize +
		// ",text=" + text + ",title=" + title);
		// (2,10)2为页码，10位每页的条数
		PageHelper.startPage(pageNumber, pageSize);
		List<BookAll> list;
		String json = "";
		try {
			list = service.queryBooks(book);
			list.forEach(li -> System.out.println(li));
			PageInfo<BookAll> info = new PageInfo<>(list);
			// 得到总记录数
			long total = info.getTotal();
			// 将list集合封装成json数据
			String jsonlist = JSON.toJSONString(list);
			json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 构建完成的json数据

		return json;

	}

	// 9.排序
	@RequestMapping(value = "/findBooksQueryBySort", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String findBooksQueryBySort(int pageNumber, int pageSize, String bookString, String sortOrder,
			String sortName) {
		try {
			bookString = URLDecoder.decode(bookString, "utf-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		HashMap<String, String> bookMap = form2Map(bookString);
		BookQuery book = JSON.parseObject(JSON.toJSONString(bookMap), BookQuery.class);
		Book books = JSON.parseObject(JSON.toJSONString(bookMap), Book.class);
		System.out.println(book);
		System.out.println(books);

		// System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize +
		// ",text=" + text + ",title=" + title);
		// (2,10)2为页码，10位每页的条数
		PageHelper.startPage(pageNumber, pageSize);
		List<BookAll> list;
		String json = "";
		try {
			list = service.queryBooksBySort(book, sortOrder, sortName);
			list.forEach(li -> System.out.println(li));
			PageInfo<BookAll> info = new PageInfo<>(list);
			// 得到总记录数
			long total = info.getTotal();
			// 将list集合封装成json数据
			String jsonlist = JSON.toJSONString(list);
			json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 构建完成的json数据

		return json;

	}

	// 将json转化为map
	public static HashMap<String, String> form2Map(String orderinfo) {
		System.out.println("orderinfo:" + orderinfo);

		System.out.println(orderinfo);
		String listinfo[];
		HashMap<String, String> map = new HashMap<String, String>();
		listinfo = orderinfo.split("&");
		for (String s : listinfo) {
			String list[] = s.split("=");
			System.out.println("list[0]:" + list);
			if (list.length > 1) {

				map.put(list[0], list[1]);
				System.out.println("list[0], list[1]=" + list[0] + ":" + list[1]);

			} else if (list.length == 1) {
				map.put(list[0], "");
			}
		}

		return map;
	}


	// 10.查找图书编号存在且是否可借
	@RequestMapping(value = "/findBookByNumber", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public List<BookAll> findBookByNumber(String booknumber) {
		List<BookAll> list = service.findBookByNumber(booknumber);
		// TODO Auto-generated method stub
		return list;
	}
	
	//11.更新图书的状态
	@RequestMapping(value = "/updateBookStatus", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public int updateBookStatus(String booknumber,int statusNumber) {
		Book book = new Book();
		//设置为外借
		book.setBookstatusnumber(statusNumber);
		book.setBooknumber(booknumber);
		int in = service.updateBookBySelect(book);
		// TODO Auto-generated method stub
		return in;
	}
	
	public Book findBookByKey(String booknumber) {
		Book book = service.findBookByKey(booknumber);
		// TODO Auto-generated method stub
		return book;
	}
	
	public int updateBook(Book book) {
		int in =service.updateBookByNumber(book);
		return in;
	}
		
	public int updateBookBySelect(Book book) {
		int in =service.updateBookBySelect(book);
		return in;
	}

	public int findBookExist(String booknumber) {
		// TODO Auto-generated method stub
		int in = service.findBookExist(booknumber);
		return in;
	}
	
	//导入图书
	String myData ="";
	@RequestMapping(value = "/importBooks", method = RequestMethod.POST,produces = "appliction/json;charset=utf8")
	@ResponseBody
	@Bean(name = "multipartResolver")
	public String importBooks(@RequestParam("file") MultipartFile[] file, HttpSession session) {			 
	//String fileName = file.getOriginalFilename();
	List<Book> list = new ArrayList<Book>() ;
	int result = 1;		 
	try {
		//System.out.println(file.length);
		//处理接收的文件
		list = service.addBooks(file[0]);
		//System.out.println("aa");
	} catch (Exception e) {
		 e.printStackTrace();
	}
	String json = "";
	String jsonlist = JSON.toJSONString(list);
	json = "{\"total\" : " + list.size() + ",\"rows\" : " + jsonlist + "}";
	myData = json;
	if(result > 0){
		return  json;
	}else{
		return "{\"result\":\"excel文件数据导入失败！\"}";
	}
}
	
	//获取数据
	@RequestMapping(value = "/getDatas", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String getDatas() {
		System.out.println("mydata:"+myData);
		return myData;
	}		
	
	// 批量添加图书信息
	@RequestMapping(value = "/addManyBooks", produces = "appliction/text;charset=utf-8")
	@ResponseBody()
	public String addManyBooks(String books) {
	System.out.println("批量添加图书信息" + books.toString());
	List<Book> list1 = (List<Book>) JSONArray.parseArray(books, Book.class);
	//int in = service.updateBookByNumber(book);			
	/*for(int i = 0 ;i <list.size();i++) {
		Book book  = list.get(i);
		Long timeStamp = System.currentTimeMillis();
		book.setBooknumber(timeStamp.toString()+i);
		book.setBorrowtimes(0);
		book.setTypebookCfnumber(1);
		book.setBookstatusnumber(1);
		book.setEntrydate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		book.setTypecirculationnumber(1);
	}*/
	//List<Integer> list1 = new ArrayList<Integer>();
	//int in = service.updateBookByNumber(book); 
	/*for(int j = 0 ;j <list.size();j++) {
		Book book  = list.get(j);
		int amount = book.getAmount();
		list1.add(amount);
	}*/
	List<Book> list = new ArrayList<Book>();
	for(int i = 0;i < list1.size();i++) {
		Book book1  = list1.get(i);
		int amount = book1.getAmount();
			while(amount>=1) {
				Book book = new Book();
				Long timeStamp = System.currentTimeMillis();
				book.setBooknumber(timeStamp.toString()+i+amount);
				book.setBorrowtimes(0);
				book.setEntrydate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				book.setIsbn(book1.getIsbn());
				book.setTitle(book1.getTitle());
				book.setAuthor(book1.getAuthor());
				book.setTranslator(book1.getTranslator());
				book.setPublishhousenumber(book1.getPublishhousenumber());
				book.setPublishyear(book1.getPublishyear());
				book.setCallnumber(book1.getCallnumber());
				book.setTypebookCfnumber(book1.getTypebookCfnumber());
				book.setClassificationnumber(book1.getClassificationnumber());
				book.setTypecirculationnumber(book1.getTypecirculationnumber());
				book.setSummary(book1.getSummary());
				book.setBookstatusnumber(book1.getBookstatusnumber());
				System.out.println("book1---->"+book);
				list.add(book);
				System.out.println("while循环list---->"+list);
				System.out.println("amount---->"+amount);	
				amount--;
			} 
			System.out.println("for循环list---->"+list);
	} 
	System.out.println("终极list---->"+list);
	list.forEach(li -> System.out.println(li));
	int in =service.addManyBooks(list);			
	return in+"";
	}		    
}




