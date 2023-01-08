package com.example.demo.service;

import com.example.demo.model.Address;

public interface AddressService {

	
	//post
	Address createAddress(Address address);
	
	//getById
	Address getAddressById(Integer Id);
}
