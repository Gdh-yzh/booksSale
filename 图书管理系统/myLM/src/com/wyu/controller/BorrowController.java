package com.wyu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyu.pojo.Book;
import com.wyu.pojo.BookAll;
import com.wyu.pojo.Borrow;
import com.wyu.pojo.BorrowAll;
import com.wyu.pojo.Reader;
import com.wyu.pojo.ReaderAll;
import com.wyu.service.BorrowService;

@Controller
public class BorrowController {
	@Autowired
	private BorrowService service;
	@Autowired
	private BookController bookController;
	@Autowired
	private ReaderController readerController;
	
	//图书借阅
	@RequestMapping(value = "/borrowQuery", produces = "appliction/json;charset=utf8")
	@ResponseBody
	@Transactional
	public String borrowQuery(String booknumber, String readernumber) {
		String tag = "";
		BookAll bookall;
		String json = "{\"tag\" : "+tag+"}";
		List<BookAll> bookList = bookController.findBookByNumber(booknumber);
		List<ReaderAll> readerList = readerController.findreaderByNumber(readernumber);
		if (bookList.isEmpty()) {
			tag="图书编号有误或者图书不存在";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}
		if (readerList.isEmpty()) {
			tag="读者编号有误或者不存在";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}

		bookall = bookList.get(0);
		String statusBook = bookall.getStatusBook().getBookstatus();
		String typecirculationBook = bookall.getTypecirculationBook().getTypecirculationname();
		if (!typecirculationBook.equals("外借")) {
			tag="图书不可外借";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		} 
		if (!statusBook.equals("在架上")) {
			tag="图书不在架上，无法外借";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}
		ReaderAll readerall;
		readerall = readerList.get(0);
		String statusReader = readerall.getStatusReader().getStatusname();
		int borrowamount = readerall.getTypeReader().getBorrowamount();
		
		
		//判断图书是否逾期
		int borrowedamount = service.countByReaderNumber(readernumber);
		if(statusReader.equals("禁用")) {
			tag="读者被禁用,无法借取图书";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}
		
		//查询读者借阅本数未归还
		int overdue = service.countOverdueByReaderNumber(readernumber);
		if(overdue>0) {
			tag="读者存在图书逾期,请先去归还图书";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}
		if(borrowamount<=borrowedamount) {
			tag="读者借阅图书已达到"+borrowamount+"本,无法借取图书";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}
		
		Borrow borrow = new Borrow();
		Long timeStamp = System.currentTimeMillis();
		borrow.setBorrownumber(timeStamp.toString());
		borrow.setBooknumber(booknumber);
		borrow.setReadernumber(readernumber);
		
		//借阅次数
		int borrowCount = service.borrowCount(booknumber);
		borrow.setBorrowingstimes(borrowCount+1);
		Date borrowdate = new Date();
		borrow.setBorrowdate(borrowdate);
		//获取读者的类型的天数
		int days = readerall.getTypeReader().getBorrowdays();
		Date returnDate = addDate(borrowdate, days);
		borrow.setReturndate(returnDate);
		//已借出
		borrow.setBorrowstatusnumber(1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date enddate;
		try {
			enddate = simpleDateFormat.parse("0000-00-00");
			borrow.setEnddate(enddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//添加借阅信息
		int in = service.addBorrowByNumbers(borrow);
		if(in>0) {
			//更新图书的信息
			int bookin=bookController.updateBookStatus(booknumber,3);
			if(bookin>0) {
				System.out.println("图书状态改变成功");
			}else {
				System.out.println("请管理员手动改动图书状态为已借出,编号为3");
			}
			
			List<BookAll> newbookList = bookController.findBookByNumber(booknumber);
			String bookLists = JSON.toJSONString(newbookList);
			String readerLists = JSON.toJSONString(readerList);
			tag="借阅成功";
			json = "{\"tag\" : \"" +tag+ "\",\"book\" : " + bookLists + ",\"reader\" : " + readerLists +"}";
			return json;
			
		}
		tag="借阅失败";
		json = "{\"tag\" : \""+tag+"\"}";
		return json;
	}
	
	

	
	//日期加上天数
	public static Date addDate(Date date,long day) {
		 long time = date.getTime(); // 得到指定日期的毫秒数
		 day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
		 time+=day; // 相加得到新的毫秒数
		 return new Date(time); // 将毫秒数转换成日期
		}
	
	
	//2.查询图书有借阅记录
	@RequestMapping(value = "/returnBorrowBybooknumber", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String returnBorrowBybooknumber(String booknumber) {
		//查询借阅记录中是否存在图书
		//String json = "{\"tag\" : "+tag+"}";
		int inbook = bookController.findBookExist(booknumber);
		String tag="";
		String json = "{\"tag\" : \""+tag+"\"}";
		if(inbook==0) {
			tag="图书不存在";
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}
		List<Borrow> borrowList = service.findBorrowBybookNumberNoReturn(booknumber);
		
		if(borrowList.isEmpty()) {
			tag="无借阅记录";
			System.out.println("borrowList为空,无借阅记录");
			System.out.println("borrowList:"+borrowList.toString());
			json = "{\"tag\" : \""+tag+"\"}";
			return json;
		}
		List<BookAll> bookAll;
		List<ReaderAll> readerAll;
		bookAll = bookController.findBookByNumber(booknumber);
		readerAll = readerController.findreaderByNumber(borrowList.get(0).getReadernumber());
		String book = JSON.toJSONString(bookAll);
		String reader = JSON.toJSONString(readerAll);
		String borrow = JSON.toJSONString(borrowList);
		tag="有借阅记录";
		json = "{\"tag\" : \"" +tag+ "\",\"book\" : " + book + ",\"reader\" : " + reader +",\"borrow\" : " + borrow +"}";
		return json;
	}
	
		@RequestMapping(value = "/returnBorrowByreadernumber", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String returnBorrowByreadernumber(String readernumber) {
			//查询借阅记录中是否存在图书
			//String json = "{\"tag\" : "+tag+"}";
			int inreader = readerController.findReaderExist(readernumber);
			String tag="";
			String json = "{\"tag\" : \""+tag+"\"}";
			if(inreader==0) {
				tag="图书不存在";
				json = "{\"tag\" : \""+tag+"\"}";
				return json;
			}
			List<Borrow> borrowList = service.findBorrowByreaderNumberNoReturn(readernumber);
			
			if(borrowList.isEmpty()) {
				tag="无借阅记录";
				System.out.println("borrowList为空,无借阅记录");
				System.out.println("borrowList:"+borrowList.toString());
				json = "{\"tag\" : \""+tag+"\"}";
				return json;
			}
			List<BookAll> bookAll;
			List<ReaderAll> readerAll;
			bookAll = bookController.findBookByNumber(borrowList.get(0).getBooknumber());
			readerAll = readerController.findreaderByNumber(readernumber);
			String book = JSON.toJSONString(bookAll);
			String reader = JSON.toJSONString(readerAll);
			String borrow = JSON.toJSONString(borrowList);
			tag="有借阅记录";
			json = "{\"tag\" : \"" +tag+ "\",\"book\" : " + book + ",\"reader\" : " + reader +",\"borrow\" : " + borrow +"}";
			return json;
		}
	
	//3.归还图书
	
	@RequestMapping(value = "/returnBook", produces = "appliction/json;charset=utf8")
	@ResponseBody
	@Transactional
	public String returnBook(String borrownumber) {
		Borrow borrow = service.findBorrowByNumber(borrownumber);
		Borrow borrow2 = new Borrow();
		Date date = new Date();
		borrow2.setEnddate(date);
		borrow2.setBorrowstatusnumber(3);
		borrow2.setBorrownumber(borrownumber);
		Book book = new Book();
		book.setBooknumber(borrow.getBooknumber());
		book.setBookstatusnumber(2);
		Reader reader = new Reader();
		reader.setReadernumber(borrow.getReadernumber());
		int inbook = bookController.updateBookBySelect(book);
		//int inreader = readerController.updateReaderBySelect(reader);
		int inborrow = service.upDateBorrowBySelect(borrow2);
		
		return inbook+inborrow+"";
	}
	
	// 5.删除一些借阅信息
			@RequestMapping(value = "/deleteBorrows", produces = "appliction/json;charset=utf8")
			@ResponseBody()
			public String deleteBorrows(@RequestBody String jsonNumbers) {
				System.out.println("deleteBorrows要删除的numbers:" + jsonNumbers);
				// 将json的字符串转化为list
				List<String> numbers = (List<String>) JSONArray.parseArray(jsonNumbers, String.class);

				// 调用service完成删除
				int in = service.deleteBorrowByNumbers(numbers);
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

			// 6.根据条件查询借阅信息
			@RequestMapping(value = "/findBorrowsByText", produces = "appliction/json;charset=utf8")
			@ResponseBody
			public String findBorrowsByText(int pageNumber, int pageSize, String text) {
				System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize + ",text=" + text);
				System.out.println("text" + text);
				// (2,10)2为页码，10位每页的条数
				PageHelper.startPage(pageNumber, pageSize);
				List<BorrowAll> list = service.findBorrowsByText(text);
				// list.forEach(li -> System.out.println(li));
				PageInfo<BorrowAll> info = new PageInfo<>(list);
				// 得到总记录数
				long total = info.getTotal();
				// 将list集合封装成json数据
				String jsonlist = JSON.toJSONString(list);
				// 构建完成的json数据
				String json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
				System.out.println("json=" + json);
				System.out.println("根据标题查询借阅信息");
				System.out.println("info" + info);
				return json;

			}
		
	
	//4.查询借阅信息 findBorrows
	
	
	@RequestMapping(value="/findBorrowsBySort",produces="appliction/json;charset=utf8")
	@ResponseBody
	public String findBorrowsBySort(int pageNumber, int pageSize, String text, String sortOrder, String sortName,
			String title) {
		System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize + ",text=" + text + ",title=" + title);
		System.out.println("text=" + text + ",sortName=" + sortName + ",sortOrder=" + sortOrder);
		// (2,10)2为页码，10位每页的条数
		PageHelper.startPage(pageNumber, pageSize);
		List<BorrowAll> list = service.findBorrowsBySort(text, sortName, sortOrder);
		// list.forEach(li -> System.out.println(li));
		PageInfo<BorrowAll> info = new PageInfo<>(list);
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
	
	//5.统计借阅数量
	
	
			@RequestMapping(value = "/borrowAmounts", produces = "appliction/text;charset=utf-8")
			@ResponseBody()
			public String borrowAmounts() {
				// TODO Auto-generated method stub
				
			//	图书借阅总数:	17个
			//	图书未归还总数:	
			//	单本图书最高借阅次数:	
			//	读者借阅个数:
				int inBorrow = service.borrowAmounts();
				int inNoReturn = service.noReturnAmounts();
				int inTopBorrow = service.topBorrowAmounts();
				int inReaderBorrow = service.readerBorrowAmounts();
				
				return "{\"borrow\" : " + inBorrow+",\"noReturn\" : " + inNoReturn + ",\"topBorrow\" : " + inTopBorrow + ",\"readerBorrow\" : " + inReaderBorrow + "}";
			}
			// 6.删除借阅信息
			@RequestMapping(value = "/deleteBorrow", produces = "appliction/text;charset=utf-8")
			@ResponseBody()
			public String deleteBoorrow(String number) {
				System.out.println("要删除的number:" + number);
				// 调用service完成删除
				// int in = service.deleteBookByNumber("123");
				int in = service.deleteBorrowByNumber(number);
				// 定义一个变量用来存放删除结果
				// String deleteRes = "删除失败";
				if (in > 0) {
					System.out.println("删除成功");
					// deleteRes = in;
				}
				System.out.println(in);
				return in + "";
			}

}
