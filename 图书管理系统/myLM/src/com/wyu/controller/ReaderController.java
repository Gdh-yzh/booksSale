package com.wyu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyu.pojo.ReaderAll;
import com.wyu.pojo.ReaderQuery;
import com.wyu.pojo.Reader;
import com.wyu.service.ReaderService;

@Controller
public class ReaderController {
	
	@Autowired
	private ReaderService service;
	
	//1.读者功能
		@RequestMapping(value="/findReaders",produces="appliction/json;charset=utf8")
		@ResponseBody
		public String findReaders(int  pageNumber,int pageSize) {
			System.out.println("page"+pageNumber+";rows"+pageSize);
			//（1，5）查询前面五条数据，（10，5）从第10条开始查询5条数据
			PageHelper.startPage(pageNumber,pageSize);
			List<ReaderAll> list = service.findReaders();
			list.forEach(li->System.out.println(li));
			//PageInfo info = new PageInfo<>();
			PageInfo<ReaderAll> info = new PageInfo<>(list);
			//得到总记录数
			long total = info.getTotal();
			//将list集合封装成json数据
			String jsonlist = JSON.toJSONString(list);
			//构建完成的json数据
			String json = "{\"total\" : "+total+",\"rows\" : "+jsonlist+"}";
			System.out.println("json="+json);
			return json;
			
		}
		// 2.根据条件查询读者
		@RequestMapping(value = "/findReadersByText", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String findReadersByText(int pageNumber, int pageSize, String text) {
			System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize + ",text=" + text);
			System.out.println("text" + text);
			// (2,10)2为页码，10位每页的条数
			PageHelper.startPage(pageNumber, pageSize);
			List<ReaderAll> list = service.findReadersByText(text);
			// list.forEach(li -> System.out.println(li));
			PageInfo<ReaderAll> info = new PageInfo<>(list);
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
		// 3.排序
		@RequestMapping(value = "/findReadersBySort", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String findReadersBySort(int pageNumber, int pageSize, String text, String sortOrder, String sortName,
				String title) {
			System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize + ",text=" + text + ",title=" + title);
			System.out.println("text=" + text + ",sortName=" + sortName + ",sortOrder=" + sortOrder);
			// (2,10)2为页码，10位每页的条数
			PageHelper.startPage(pageNumber, pageSize);
			List<ReaderAll> list = service.findReadersBySort(text, sortName, sortOrder);
			// list.forEach(li -> System.out.println(li));
			PageInfo<ReaderAll> info = new PageInfo<>(list);
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
		// 4.更新读者信息
		@RequestMapping(value = "/updateReader", produces = "appliction/text;charset=utf-8")
		@ResponseBody()
		public String updateReader(Reader read) throws ParseException {
			System.out.println("修改的用户信息是" + read);
			int expirationdays = read.getExpirationdays();
			String registrationdate = read.getRegistrationdate();
			System.out.println("原来的注册日期是"+registrationdate);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date registrationdate1 = simpleDateFormat.parse(registrationdate);
			System.out.println("注册日期是"+registrationdate1);
			read.setEnddate(addDate(registrationdate1,expirationdays));
			int in = service.updateReaderByNumber(read);
			String updateInfo = "0";
			if (in > 0) {
				System.out.println("修改成功");
				updateInfo = "1";
			}
			return updateInfo;
		}
	
		//5.
		@RequestMapping(value = "/findreaderByNumber", produces = "appliction/text;charset=utf-8")
		@ResponseBody()
		public List<ReaderAll> findreaderByNumber(String readernumber) {
			// TODO Auto-generated method stub
			List<ReaderAll> list = service.findreaderByNumber(readernumber);
			return list;
		}
		
		//6.统计读者数量
		@RequestMapping(value = "/readerAmounts", produces = "appliction/text;charset=utf-8")
		@ResponseBody()
		public String readerAmounts() {
			// TODO Auto-generated method stub
			int in = service.readerAmounts();
			return "{\"amounts\" : " + in+"}";
		}
		
		//7.根据id查询读者信息
		@RequestMapping(value = "/findReaderByID", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String findReaderByID(String readernumber) {
			System.out.println("readernumber=" + readernumber);
			ReaderAll list = service.findReadersById(readernumber);
			// 将list集合封装成json数据
			String jsonlist = JSON.toJSONString(list);
			System.out.println(jsonlist);
			// 构建完成的json数据
			return jsonlist;
		}

		public int findReaderExist(String readernumber) {
			// TODO Auto-generated method stub
			int in = service.findReaderExist(readernumber);
			return in;
		}
		/*public int updateReaderBySelect(Reader reader) {
			int in =service.updateReaderBySelect(reader);
			return in;
		}*/
		//2.添加读者
		@RequestMapping(value = "/addReader", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String addReader(ReaderAll reader) {
			int expirationdays = reader.getExpirationdays();
			Date registrationdate = new Date();
			reader.setEnddate(addDate(registrationdate,expirationdays));
			reader.setReaderstatusnumber(1);
			// 当前时间
			reader.setRegistrationdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			int in = service.insertReader(reader);
			String Json="";
			if (in > 0) {
				List<ReaderAll> readerall = service.findReaderByNumber(reader.getReadernumber());
				Json = JSON.toJSONString(readerall);
				System.out.println("Json:" + Json);
				return Json;
			} 
			return Json;
		}
		//日期加上天数
		public static Date addDate(Date date,long day) {
			 long time = date.getTime(); // 得到指定日期的毫秒数
			 day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
			 time+=day; // 相加得到新的毫秒数
			 return new Date(time); // 将毫秒数转换成日期
			}
		
		// 4.删除读者
		@RequestMapping(value = "/deleteReader", produces = "appliction/text;charset=utf-8")
		@ResponseBody()
		public String deleteReader(String number) {
			System.out.println("要删除的number:" + number);
			// 调用service完成删除
			// int in = service.deleteBookByNumber("123");
			int in = service.deleteReaderByNumber(number);
			// 定义一个变量用来存放删除结果
			// String deleteRes = "删除失败";
			if (in > 0) {
				System.out.println("删除成功");
				// deleteRes = in;
			}
			System.out.println(in);
			return in + "";
		}

		// 5.删除一些读者
		@RequestMapping(value = "/deleteReaders", produces = "appliction/json;charset=utf8")
		@ResponseBody()
		public String deleteReaders(@RequestBody String jsonNumbers) {
			System.out.println("deleteReaders要删除的numbers:" + jsonNumbers);
			// 将json的字符串转化为list
			List<String> numbers = (List<String>) JSONArray.parseArray(jsonNumbers, String.class);

			// 调用service完成删除
			int in = service.deleteReaderByNumbers(numbers);
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
		
		// 8.多条件查询读者
		@RequestMapping(value = "/queryReaders", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String queryReaders(ReaderQuery reader) {
			System.out.println(reader.toString());
			System.out.println(reader);
			// (2,10)2为页码，10位每页的条数
			int pageNumber = reader.getPageNumber();
			int pageSize = reader.getPageSize();
			com.github.pagehelper.Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
			List<ReaderAll> list;
			String json = "";
			System.out.println(pageNumber + "," + pageSize);
			try {
				list = service.queryReaders(reader);
				list.forEach(li -> System.out.println(li));
				PageInfo<ReaderAll> info = new PageInfo<>(list);
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

		@RequestMapping(value = "/findReadersQuery", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String findReadersQuery(int pageNumber, int pageSize, String readerString) {
			System.out.println("林发发得到的数据"+readerString+"页数"+pageNumber+"大小"+pageSize);
			try {
				readerString = URLDecoder.decode(readerString, "utf-8");
			} catch (UnsupportedEncodingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			HashMap<String, String> readerMap = form2Map(readerString);
			ReaderQuery reader = JSON.parseObject(JSON.toJSONString(readerMap), ReaderQuery.class);
			Reader readers = JSON.parseObject(JSON.toJSONString(readerMap), Reader.class);
			System.out.println(reader);
			System.out.println(readers);
			// System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize +
			// ",text=" + text + ",title=" + title);
			// (2,10)2为页码，10位每页的条数
			PageHelper.startPage(pageNumber, pageSize);
			List<ReaderAll> list;
			String json = "";
			try {
				list = service.queryReaders(reader);
				list.forEach(li -> System.out.println(li));
				PageInfo<ReaderAll> info = new PageInfo<>(list);
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
		@RequestMapping(value = "/findReadersQueryBySort", produces = "appliction/json;charset=utf8")
		@ResponseBody
		public String findReadersQueryBySort(int pageNumber, int pageSize, String readerString, String sortOrder,
				String sortName) {
			try {
				readerString = URLDecoder.decode(readerString, "utf-8");
			} catch (UnsupportedEncodingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			HashMap<String, String> readerMap = form2Map(readerString);
			ReaderQuery reader = JSON.parseObject(JSON.toJSONString(readerMap), ReaderQuery.class);
			Reader readers = JSON.parseObject(JSON.toJSONString(readerMap), Reader.class);
			System.out.println(reader);
			System.out.println(readers);
			// System.out.println("pageNumber=" + pageNumber + ",pageSize=" + pageSize +
			// ",text=" + text + ",title=" + title);
			// (2,10)2为页码，10位每页的条数
			PageHelper.startPage(pageNumber, pageSize);
			List<ReaderAll> list;
			String json = "";
			try {
				list = service.queryReadersBySort(reader, sortOrder, sortName);
				list.forEach(li -> System.out.println(li));
				PageInfo<ReaderAll> info = new PageInfo<>(list);
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
		
		//读者登录
		@RequestMapping("/loginReader")
		public String login(String number,String password,Model model,HttpSession session) {
			System.out.println("number==" + number + ",password==" + password);
			Reader reader = service.findByReaderNumber(number);
			System.out.println("查询到的数据是："+ reader);
			String loginInfo = "没有这个用户";
			if(reader != null) {
				if(reader.getReaderstatusnumber() == 2)
				{
					loginInfo = "该用户已被禁用";
				}
				else {
					if(password.equals(reader.getPassword())) {
						System.out.println("登录成功");
						session.setAttribute("reader", reader);
						return "lms_bs_reader";
					}else {
						loginInfo = "密码错误";
						System.out.println("密码错误");
					}
				}
			}
			model.addAttribute("loginfo",loginInfo);
			return "login_reader";
		}		
}


