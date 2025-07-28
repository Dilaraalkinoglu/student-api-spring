package com.dilaraalk.services;

import java.util.List;

import com.dilaraalk.dto.DtoEmployee;

public interface IEmployeeService {
	
	public List<DtoEmployee> findAllEmployees();

}
