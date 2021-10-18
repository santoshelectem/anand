/**
 * 
 */
package com.example.postgresdemo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.model.Products;
import com.example.postgresdemo.repository.ProuducsRepository;

/**
 * @author Cybertech1
 *
 */
@Service
public class ProductsService {
	
	@Autowired
	private ProuducsRepository prouducsRepository;

	public Products saveProduc(final @Valid Products products) {
		// TODO Auto-generated method stub
		return prouducsRepository.save(products);
	}

	public void deleteProduc(final Integer pId) {
		// TODO Auto-generated method stub
		prouducsRepository.deleteById(pId);
		
	}

}
