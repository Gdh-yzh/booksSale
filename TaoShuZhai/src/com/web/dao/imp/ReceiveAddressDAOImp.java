package com.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.web.dao.ReceiveAddressDAO;
import com.web.model.Order;
import com.web.model.ReceiveAddress;
import com.web.util.DBConnection;

public class ReceiveAddressDAOImp implements ReceiveAddressDAO{
	
	private final static String FIND_BY_ID = "select * from  d_receive_address where id=?";
	
	private static final String INSERT = "insert into d_receive_address(id,user_id,receive_name,full_address,postal_code"+","
			+ "mobile,phone) values(?,?,?,?,?,?,?)";
	
	private static final String FIND_BY_USER_ID = "select * from d_receive_address where user_id = ?";
 
	@Override
	public ReceiveAddress findById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ReceiveAddress ra = null;
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FIND_BY_ID);
			prep.setInt(1,id);
			ResultSet rs = prep.executeQuery();
			if(rs.next()){
				ra = new ReceiveAddress();
				ra.setId(rs.getInt("id"));
				ra.setUserId(rs.getInt("user_id"));
				ra.setReceiveName(rs.getString("receive_name"));
				ra.setFullAddress(rs.getString("full_address"));
				ra.setPostalCode(rs.getString("postal_code"));
				ra.setMobile(rs.getString("mobile"));
				ra.setPhone(rs.getString("phone"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(prep, conn);
		}
		return ra;
	}

	@Override
	public void save(ReceiveAddress addr) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, addr.getId());
			prep.setInt(2, addr.getUserId());
			prep.setString(3, addr.getReceiveName());
			prep.setString(4, addr.getFullAddress());
			prep.setString(5, addr.getMobile());
			prep.setString(6, addr.getPhone());
			prep.setString(7, addr.getPostalCode());
			
			prep.executeUpdate();
			ResultSet rst = prep.getGeneratedKeys();
			rst.next();
			int id = rst.getInt(1);
			addr.setId(id);
		}finally{
			DBConnection.close(prep, conn);
		}
	}

	@Override
	public List<ReceiveAddress> findByUserId(int userId) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		List<ReceiveAddress> addr = new ArrayList<ReceiveAddress>();
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FIND_BY_USER_ID);
			prep.setInt(1,userId);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				ReceiveAddress ra = new ReceiveAddress();
				ra.setId(rs.getInt("id"));
				ra.setUserId(rs.getInt("user_id"));
				ra.setReceiveName(rs.getString("receive_name"));
				ra.setFullAddress(rs.getString("full_address"));
				ra.setPostalCode(rs.getString("postal_code"));
				ra.setMobile(rs.getString("mobile"));
				ra.setPhone(rs.getString("phone"));
				
				addr.add(ra);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.close(prep, conn);
		}
		return addr;
	}

}
