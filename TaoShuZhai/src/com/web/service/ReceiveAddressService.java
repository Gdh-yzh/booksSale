package com.web.service;

import java.util.List;

import com.web.model.ReceiveAddress;

public interface ReceiveAddressService {

	public ReceiveAddress findById(int id) throws Exception;

	public void save(ReceiveAddress addr) throws Exception;

	public List<ReceiveAddress> findByUserId(int userId) throws Exception;
	
}
