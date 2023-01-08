package com.example.demo.serviceimpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepo;
import com.example.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepo addressRepo;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Address createAddress(Address address) {

		return addressRepo.save(address);
	}

	@Override
	public Address getAddressById(Integer Id) {
		Address address = addressRepo.findById(Id).get();
		if (address == null) {
			throw new NoSuchElementException("Invalid AddressId" + Id);
		}
		return address;
	}

}
