package com.dilaraalk.controller;

import com.dilaraalk.dto.DtoCustomer;

public interface ICustomerController {
	
	public DtoCustomer findCustomerById(Long id);

}
