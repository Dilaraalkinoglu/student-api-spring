package com.dilaraalk.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddress {
	
	private Long id;
	
	private String description;
	
	@JsonManagedReference
	private DtoCustomer customer;

}
