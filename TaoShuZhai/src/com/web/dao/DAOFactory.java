package com.web.dao;

import com.web.dao.imp.CategoryDAOImp;
import com.web.dao.imp.OrderDAOImp;
import com.web.dao.imp.ProductDAOImp;
import com.web.dao.imp.ReceiveAddressDAOImp;
import com.web.dao.imp.UserDAOImp;

public class DAOFactory {
	
	public static ProductDAO getProductDAO(){
		return new ProductDAOImp();
	}

	public static UserDAO getUserDAO(){
		return new UserDAOImp();
	}

	public static CategoryDAO getCategoryDAO() {
		return new CategoryDAOImp();
	}
	
	public static ReceiveAddressDAO getReceiveAddressDAO() {
		return new ReceiveAddressDAOImp();
	}
	
	public static OrderDAO getOrderDAO() {
		return new OrderDAOImp();
	}
}
