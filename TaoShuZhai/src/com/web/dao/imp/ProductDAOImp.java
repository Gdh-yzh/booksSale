package com.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.web.dao.ProductDAO;
import com.web.model.Book;
import com.web.model.Product;
import com.web.util.DBConnection;

public class ProductDAOImp implements ProductDAO{
	
	private final static String FIND_BY_ID = "select * from d_product p left join d_book b on b.id = p.id where p.id = ?";
	
	private final static String FIND_BY_HOT = "select sum(product_num) as num,p.*,b.* "
			+ "from d_item i "
			+ "join d_product p "
			+ "ON i.product_id=p.id "
			+ "JOIN d_book b "
			+ "ON i.product_id=b.id "
			+ "group by product_id " + " order by num desc LIMIT 0,? ";
	
	private final static String FIND_BY_NEW = "select p.*,b.* "
			+ "from d_product p "
			+ "join d_book b "
			+ "on p.id=b.id "
			+ "order by p.add_time desc "
			+ "limit 0,? ";

	@Override
	public Book findById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		Book book = null;
		ResultSet rst = null;
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FIND_BY_ID);
			prep.setInt(1, id);
			rst = prep.executeQuery();
			if(rst.next()){
				book = new Book();
				book.setAuthor(rst.getString("author"));
				book.setAuthorSummary(rst.getString("author_summary"));
				book.setCatalogue(rst.getString("catalogue"));
				book.setId(rst.getInt("id"));
				book.setIsbn(rst.getString("isbn"));
				book.setPrintNumber(rst.getString("print_number"));
				book.setPrintTime(rst.getLong("print_time"));
				book.setPublishing(rst.getString("publishing"));
				book.setPublishTime(rst.getLong("publish_time"));
				book.setWhichEdtion(rst.getString("which_edtion"));
				book.setTotalPage(rst.getString("total_page"));
				book.setWordNumber(rst.getString("word_number"));
				book.setProductName(rst.getString("product_name"));
				book.setDescription(rst.getString("description"));
				book.setAddTime(rst.getLong("add_time"));
				book.setFixedPrice(rst.getDouble("fixed_price"));
				book.setDangPrice(rst.getDouble("dang_price"));
				book.setKeywords(rst.getString("keywords"));
				book.setHasDeleted(rst.getInt("has_deleted"));
				book.setProductPic(rst.getString("product_pic"));
			}
		}finally{
			DBConnection.close(prep, conn);
		}
		return book;
	}
	
	public List<Product>  findByHot(int num) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		List<Product> pros = new ArrayList<Product>();
		try{
			prep = DBConnection.getConnection().prepareStatement(FIND_BY_HOT);
			prep.setInt(1, num);
			rst = prep.executeQuery();
			while(rst.next()){
				Book book = new Book();
				book.setId(rst.getInt("id"));
				book.setAuthor(rst.getString("author"));
				book.setAuthorSummary(rst.getString("author_summary"));
				book.setCatalogue(rst.getString("catalogue"));
				book.setId(rst.getInt("id"));
				book.setIsbn(rst.getString("isbn"));
				book.setPrintNumber(rst.getString("print_number"));
				book.setPrintTime(rst.getLong("print_time"));
				book.setPublishing(rst.getString("publishing"));
				book.setPublishTime(rst.getLong("publish_time"));
				book.setWhichEdtion(rst.getString("which_edtion"));
				book.setTotalPage(rst.getString("total_page"));
				book.setWordNumber(rst.getString("word_number"));
				book.setProductName(rst.getString("product_name"));
				book.setDescription(rst.getString("description"));
				book.setAddTime(rst.getLong("add_time"));
				book.setFixedPrice(rst.getDouble("fixed_price"));
				book.setDangPrice(rst.getDouble("dang_price"));
				book.setKeywords(rst.getString("keywords"));
				book.setHasDeleted(rst.getInt("has_deleted"));
				book.setProductPic(rst.getString("product_pic"));
				
				pros.add(book);
			}
		}finally{
			DBConnection.close(rst,prep,conn);
		}
		return pros;
	}
	
	public List<Product>  findByNew(int num) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		List<Product> pros = new ArrayList<Product>();
		try{
			prep = DBConnection.getConnection().prepareStatement(FIND_BY_NEW);
			prep.setInt(1, num);
			rst = prep.executeQuery();
			while(rst.next()){
				Book book = new Book();
				book.setId(rst.getInt("id"));
				book.setAuthor(rst.getString("author"));
				book.setAuthorSummary(rst.getString("author_summary"));
				book.setCatalogue(rst.getString("catalogue"));
				book.setId(rst.getInt("id"));
				book.setIsbn(rst.getString("isbn"));
				book.setPrintNumber(rst.getString("print_number"));
				book.setPrintTime(rst.getLong("print_time"));
				book.setPublishing(rst.getString("publishing"));
				book.setPublishTime(rst.getLong("publish_time"));
				book.setWhichEdtion(rst.getString("which_edtion"));
				book.setTotalPage(rst.getString("total_page"));
				book.setWordNumber(rst.getString("word_number"));
				book.setProductName(rst.getString("product_name"));
				book.setDescription(rst.getString("description"));
				book.setAddTime(rst.getLong("add_time"));
				book.setFixedPrice(rst.getDouble("fixed_price"));
				book.setDangPrice(rst.getDouble("dang_price"));
				book.setKeywords(rst.getString("keywords"));
				book.setHasDeleted(rst.getInt("has_deleted"));
				book.setProductPic(rst.getString("product_pic"));
				
				pros.add(book);
			}
		}finally{
			DBConnection.close(rst,prep,conn);
		}
		return pros;
	}
}
