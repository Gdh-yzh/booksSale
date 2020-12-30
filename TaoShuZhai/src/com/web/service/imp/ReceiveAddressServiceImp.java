package com.web.service.imp;

import java.util.List;

import com.web.dao.DAOFactory;
import com.web.model.ReceiveAddress;
import com.web.service.ReceiveAddressService;

public class ReceiveAddressServiceImp implements ReceiveAddressService{

	@Override
	public ReceiveAddress findById(int id) throws Exception {
		return DAOFactory.getReceiveAddressDAO().findById(id);
	}

	@Override
	public void save(ReceiveAddress addr) throws Exception {
		 DAOFactory.getReceiveAddressDAO().save(addr);
	}

	@Override
	public List<ReceiveAddress> findByUserId(int userId) throws Exception {
		return DAOFactory.getReceiveAddressDAO().findByUserId(userId);
	}

	
}
