package com.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.sun.mail.iap.Response;
import com.web.model.Book;
import com.web.model.Category;
import com.web.model.Product;
import com.web.model.User;
import com.web.service.ProductService;
import com.web.service.ServiceDAOFactory;
import com.web.service.UserService;
import com.web.util.Md5Code;

@WebServlet("/user/login.do")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 3196954445027396780L;
	public static final String METHOD_TOLOGIN = "0";
	public static final String METHOD_LOGIN = "1";
	public static final String METHOD_TO_MAIN = "2";
	
	@Override
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String method = req.getParameter("method");
		if(method != null){
			switch(method){
				case  LoginServlet.METHOD_TOLOGIN:
					req.getRequestDispatcher("/WEB-INF/view/user/login_form.jsp").forward(req, resp);;
					break;
				case LoginServlet.METHOD_LOGIN:
					try{
						login(req,resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					break;
				case LoginServlet.METHOD_TO_MAIN:
					productDetail(req,resp);
					break;
				default:
					break;
			}
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//��֤email�������Ƿ���ȷ������ȷ����login_form.jsp
		UserService userService = ServiceDAOFactory.getUserDAO();
		User user = userService.findByEmail(req.getParameter("email"));
		if(user == null	|| !user.getPassword().equals(Md5Code.createMD5Code(req.getParameter("password")))){
			req.setAttribute("login_err", "�û������������");
			req.getRequestDispatcher("/WEB-INF/view/user/login_form.jsp").forward(req, resp);
			return ;
		}
		//����last_login_time��last_login_ip�ֶ�
		user.setLastLoginIp(req.getRemoteAddr());
		user.setLastLoginTime(System.currentTimeMillis());
		userService.update(user);
		//��user��Ϣд��session
		req.getSession().setAttribute("s_user", user);
		//���is_email_verify�Ƿ�Ϊtrue�����û����֤���򷵻�verify_form.jsp
		if(!user.isEmailVerify()){
			req.getRequestDispatcher("/WEB-INF/view/user/login_form.jsp").forward(req, resp);
			return ;
		}
		
		Map<String,List> datas  = new HashMap<String,List>();
		//step1�������
		initCategory(datas);
		//step2�Ƽ�ͼ��
		initRecommend(datas);
		//step3����ͼ��
		initHotBooks(datas);
		//step4�����ϼ�
		initNewBooks(datas);
		req.setAttribute("datas",datas);
		
		req.getRequestDispatcher("/WEB-INF/view/home/main.jsp").forward(req, resp);
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
