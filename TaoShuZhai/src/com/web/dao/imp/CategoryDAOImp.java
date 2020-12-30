package com.web.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.web.dao.CategoryDAO;
import com.web.model.Category;
import com.web.service.ServiceDAOFactory;
import com.web.util.DBConnection;

public class CategoryDAOImp implements CategoryDAO{
	
	private static final String FIND_ALL = "select * from d_category";
//	private static final String FIND_BY_PARENT_ID = "select dc.*,count(dcp.product_id) as pnum"
//			+ "from d_category dc left outer join d_category_product dcp"
//			+ "on dc.id=dcp.cat_id"
//			+ "where dc.parent_id=?"
//			+ "group by dc.id";
	
	public List<Category> findAll() throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Category> cats = new ArrayList<Category>();
		try{
			prep = DBConnection.getConnection().prepareStatement(FIND_ALL);
			rs = prep.executeQuery();
			while(rs.next()){
				Category c = new Category();
				c.setDescription(rs.getString("description"));
				c.setEnName(rs.getString("en_name"));
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setParentId(rs.getInt("parent_id"));
				cats.add(c);
			}
		}finally{
			DBConnection.close(rs, prep, conn);
		}
		return cats;
	}
	
//	public List<Category> findByParentId(int pid) throws Exception{
//		Connection conn = null;
//		PreparedStatement prep = null;
//		ResultSet rs = null;
//		List<Category> cats = new ArrayList<Category>();
//		try{
//			prep = DBConnection.getConnection().prepareStatement(FIND_BY_PARENT_ID);
//			prep.setInt(1, pid);
//		}
//	}
	

}
