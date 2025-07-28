package com.dilaraalk.services;

import com.dilaraalk.dto.DtoCustomer;

public interface ICustomerService {

	public DtoCustomer findCustomerById(Long id);
	
}
