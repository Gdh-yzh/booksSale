package com.web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.web.dao.UserDAO;
import com.web.model.User;
import com.web.util.DBConnection;

public class UserDAOImp implements UserDAO{
	
	private static final String INSERT = "insert into d_user(email,nickname,password,user_integral"+","
			+ "is_email_verify,email_verify_code,last_login_time,last_login_ip) values(?,?,?,?,?,?,?,?)";
	private static final String FINDBYEMAIL = "select * from  d_user where email=?";
	private static final String FINDBYID = "select * from  d_user where id=?";
	private static final String UPDATE = "update d_user set email=?,nickname=?,password=?,user_integral=?,"
			+ "is_email_verify=?,email_verify_code=?,last_login_time=?,last_login_ip=? where id=?";
	
	@SuppressWarnings("finally")
	@Override
	public User findByEmail(String email) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		User u = null;
		ResultSet rst = null;
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FINDBYEMAIL);
			prep.setString(1, email);
			rst = prep.executeQuery();
			if(rst.next()){
				u = new User();
				u.setId(rst.getInt("id"));
				u.setEmail(rst.getString("email"));
				u.setNickname(rst.getString("nickname"));
				u.setPassword(rst.getString("password"));
				u.setUserIntegral(rst.getInt("user_integral"));
				u.setEmailVerify(rst.getBoolean("is_email_verify"));
				u.setEmailVerifyCode(rst.getString("email_verify_code"));
				u.setLastLoginTime(rst.getLong("last_login_time"));
				u.setLastLoginIp(rst.getString("last_login_ip"));
				String is_email_verify= rst.getString("is_email_verify");
				if(is_email_verify.equals("T")){
					u.setEmailVerify(true);
				}else{
					u.setEmailVerify(false);
				}
			}
		}finally{
			DBConnection.close(prep, conn);
		}
		return u;
	}
	
	public User findById(int id) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		User u = null;
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FINDBYID);
			prep.setInt(1, id);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				u = new User();
				u.setId(rst.getInt("id"));
				u.setEmail(rst.getString("email"));
				u.setNickname(rst.getString("nickname"));
				u.setPassword(rst.getString("password"));
				u.setUserIntegral(rst.getInt("user_integral"));
				u.setEmailVerify(rst.getBoolean("is_email_verify"));
				u.setEmailVerifyCode(rst.getString("email_verify_code"));
				u.setLastLoginTime(rst.getLong("last_login_time"));
				u.setLastLoginIp(rst.getString("last_login_ip"));
				
				String is_email_verify = rst.getString("is_email_verify");
				if(is_email_verify.equals("T")){
					u.setEmailVerify(true);
				}else{
					u.setEmailVerify(false);
				}
			}
		}finally{
			DBConnection.close(prep, conn);
		}
		return u;
	}
	
	public void save(User user) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			prep.setString(1, user.getEmail());
			prep.setString(2, user.getNickname());
			prep.setString(3, user.getPassword());
			prep.setInt(4, user.getUserIntegral());
			if(user.isEmailVerify()){
				prep.setString(5, "T");
			}else{
				prep.setString(5, "F");
			}
			prep.setString(6, user.getEmailVerifyCode());
			prep.setLong(7, user.getLastLoginTime());
			prep.setString(8, user.getLastLoginIp());
			
			prep.executeUpdate();
			ResultSet rst = prep.getGeneratedKeys();
			rst.next();
			int id = rst.getInt(1);
			user.setId(id);
		}finally{
			DBConnection.close(prep, conn);
		}
	}
	
	public void update(User u) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		try{
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(UPDATE);
			prep.setString(1, u.getEmail());
			prep.setString(2, u.getNickname());
			prep.setString(3, u.getPassword());
			prep.setInt(4, u.getUserIntegral());
			if(u.isEmailVerify()){
				prep.setString(5, "T");
			}else{
				prep.setString(5, "F");
			}
			prep.setString(6, u.getEmailVerifyCode());
			prep.setLong(7, u.getLastLoginTime());
			prep.setString(8, u.getLastLoginIp());
			prep.setInt(9, u.getId());
			
			prep.executeUpdate();
		}finally{
			DBConnection.close(prep, conn);
		}
	}
}
