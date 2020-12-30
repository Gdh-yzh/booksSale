package com.web.service;

import com.web.service.imp.CategoryServiceImp;
import com.web.service.imp.OrderServiceImp;
import com.web.service.imp.ProductServiceImp;
import com.web.service.imp.ReceiveAddressServiceImp;
import com.web.service.imp.UserServiceImp;

public class ServiceDAOFactory {

	public static UserService getUserDAO(){
		return new UserServiceImp();
	}

	public static CategoryService getCategoryService() {
		return new CategoryServiceImp();
	}

	public static ProductService getProductService() {
		return new ProductServiceImp();
	}

	public static ReceiveAddressService getReceiveAddressService() {
		return new ReceiveAddressServiceImp();
	}
	
	public static OrderService getOrderService() {
		return new OrderServiceImp();
	}
}
