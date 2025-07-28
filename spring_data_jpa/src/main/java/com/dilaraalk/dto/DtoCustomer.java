package com.dilaraalk.dto;




import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomer {
	
	private Long id;
	
	private String name;
	
	@JsonBackReference
	private DtoAddress address;




}
