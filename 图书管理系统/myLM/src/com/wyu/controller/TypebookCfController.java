package com.wyu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wyu.pojo.TypebookCf;
import com.wyu.service.TypebookCfService;

@Controller
public class TypebookCfController {
	@Autowired
	private TypebookCfService service;

	// 1.用户功能
	@RequestMapping(value = "/findTypebookCf", produces = "appliction/json;charset=utf8")
	@ResponseBody
	public String findTypebookCf() {
		//System.out.println("page" + page + ";rows" + rows);
		// （1，5）查询前面五条数据，（10，5）从第10条开始查询5条数据
		//PageHelper.startPage(page, rows);
		List<TypebookCf> list = service.findCirculationBook();
		list.forEach(li -> System.out.println(li));
		PageInfo<TypebookCf> info = new PageInfo<>(list);
		// 得到总记录数
		long total = info.getTotal();
		// 将list集合封装成json数据
		String jsonlist = JSON.toJSONString(list);
		// 构建完成的json数据
		
		String json = "{\"total\" : " + total + ",\"rows\" : " + jsonlist + "}";
		System.out.println("json=" + json);
		return jsonlist;

	}

}
