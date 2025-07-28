package com.dilaraalk.controller;

import java.util.List;

import com.dilaraalk.dto.DtoEmployee;

public interface IEmployeeController {
	
	public List<DtoEmployee> findAllEmployees();

}
