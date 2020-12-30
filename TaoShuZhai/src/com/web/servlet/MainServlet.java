package com.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Book;
import com.web.model.Category;
import com.web.model.Product;
import com.web.service.ProductService;
import com.web.service.ServiceDAOFactory;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet{
	
	private static final long serialVersionUID = 169157892390903758L;
	
	@Override
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String method = req.getParameter("method");
		Map<String,List> datas = new HashMap<String,List>();
		if(method != null){
			switch(method){
				case "1":
					productDetail(req,resp);
					break;
				default:
					break;	
			}
		}else{
			//step1分类浏览
			initCategory(datas);
			
			//step2推荐图书
			initRecommend(datas);
			
			//step3热销图书
			initHotBooks(datas);
			
			//step4最新上架
			initNewBooks(datas);
			
			req.setAttribute("datas",datas);
			req.getRequestDispatcher("/WEB-INF/view/home/main.jsp").forward(req, resp);
		}
	}
	
	

	private void productDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = null;
		try{
			String id = req.getParameter("id");
			if(id != null){
				book = (Book) ServiceDAOFactory.getProductService().findById(new Integer(id));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		req.setAttribute("book", book);
		req.getRequestDispatcher("/WEB-INF/view/home/product.jsp").forward(req, resp);
	}

//	private void initNewBooks(Map<String, List> datas) {
//		List<Book> books = new ArrayList<Book>();
//		List<Product> pros;
//		try{
//			pros = ServiceDAOFactory.getProductService().findByNew(4);
//			for(Product p : pros){
//				books.add((Book) p);
//			}
//			datas.put("newBooks", books);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}

	private void initCategory(Map<String, List> datas) {
		List<Category> cats;
		try{
			List<Category> list = ServiceDAOFactory.getCategoryService().findAll();
			cats = findByParentId(list,1);
			for(Category c : cats){
				c.setSubCats(findByParentId(list,c.getId()));
			}
			datas.put("category", cats);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private List<Category> findByParentId(List<Category> list, int id) {
		List<Category> subCats = new ArrayList<Category>();
		for(Category c : list){
			if(c.getParentId() == id){
				subCats.add(c);
			}
		}
		return subCats;
	}
	
	private void initRecommend(Map<String, List> datas){
		List<Book> productList = new ArrayList<Book>();
		ProductService productService = ServiceDAOFactory.getProductService();
		try {
			productList.add((Book) productService.findById(new Random().nextInt(20)));
			productList.add((Book) productService.findById(new Random().nextInt(20)));
			datas.put("books", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
  	}
	
	private void initHotBooks(Map<String, List> datas){
		List<Book> books = new ArrayList<Book>();
		List<Product> pros;
		try {
			pros = ServiceDAOFactory.getProductService().findByHot(4);
			for(Product p : pros){
				books.add((Book) p);
			}
			datas.put("hotBooks", books); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initNewBooks(Map<String, List> datas){
		List<Book> books  = new ArrayList<Book>();
		try {
			for(Product p : ServiceDAOFactory.getProductService().findByNew(4)){
				books.add((Book) p);
			}
			datas.put("newBooks", books);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
