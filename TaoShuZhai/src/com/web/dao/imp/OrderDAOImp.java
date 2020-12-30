package com.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.web.dao.OrderDAO;
import com.web.model.Order;
import com.web.util.DBConnection;

public class OrderDAOImp implements OrderDAO{
	
	private static final String INSERT = "insert into d_order(id,user_id,status,order_time"+","
			+ "order_desc,total_price,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?,?,?,?,?,?)";

	
		@Override
		public int save(Order order) throws Exception {
			Connection conn = null;
			PreparedStatement prep = null;
			int orderId = 0;
			try{
				conn = DBConnection.getConnection();
				prep = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
				prep.setInt(1, order.getId());
				prep.setInt(2, order.getUserId());
				prep.setInt(3, order.getStatus());
				prep.setLong(4, order.getOrderTime());
				prep.setString(5, order.getOrderDesc());
				prep.setDouble(6, order.getTotalPrice());
				prep.setString(7, order.getReceiveName());
				prep.setString(8, order.getFullAddress());
				prep.setString(9, order.getPostalCode());
				prep.setString(10, order.getMobile());
				prep.setString(11, order.getPhone());
				
				prep.executeUpdate();
				ResultSet rst = prep.getGeneratedKeys();
				rst.next();
				orderId = rst.getInt(1);
			}finally{
				DBConnection.close(prep, conn);
			}
			return orderId;
		}


}
