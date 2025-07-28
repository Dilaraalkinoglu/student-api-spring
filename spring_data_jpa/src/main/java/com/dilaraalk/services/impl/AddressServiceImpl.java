package com.dilaraalk.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilaraalk.dto.DtoAddress;
import com.dilaraalk.dto.DtoCustomer;
import com.dilaraalk.entites.Address;
import com.dilaraalk.repository.AddressRepository;
import com.dilaraalk.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	
	@Override
	public DtoAddress findAddressById(Long id) {
	    DtoAddress dtoAddress = new DtoAddress();

	    Optional<Address> optional = addressRepository.findById(id);
	    if (optional.isEmpty()) {
	        return null;
	    }

	    Address address = optional.get();
//	    BeanUtils.copyProperties(address, dtoAddress); // burası sadece id ve description'ı kopyalar
	    dtoAddress.setId(address.getId());
	    dtoAddress.setDescription(address.getDescription());

	    // Customer'ı manuel ekle
	    DtoCustomer dtoCustomer = new DtoCustomer();
	    dtoCustomer.setId(address.getCustomer().getId());
	    dtoCustomer.setName(address.getCustomer().getName());

//	    dtoAddress.setCustomer(dtoCustomer);

	    return dtoAddress;
	}

	

}
