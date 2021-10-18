/**
 * 
 */
package com.example.postgresdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Product;
import com.example.postgresdemo.repository.ProductRepository;
import com.example.postgresdemo.service.ProductService;

/**
 * @author Cybertech1
 *
 */
@RestController
public class ProductController {
	
	/**
	 * productService
	 */
	@Autowired
	private ProductService productService;
	
	/**
	 * productRepository
	 */
	@Autowired
	private ProductRepository productRepository;
	/**
	 * @param product
	 * @return
	 */
	@PostMapping("/product")
	public Product createProduct(final @Valid @RequestBody Product product) {
		return productService.saveUpdate(product);
	}
	
	/**
	 * @param productid
	 * @return
	 */
	@GetMapping("/product/{id}")
	public Product getProductById(final @PathVariable(value = "id") Long productid) {
		try {
			if(productid != null) {
				return productService.fetchById(productid);
			}
		} catch (Exception e) {
			
		}
		return null;	
	}

	/**
	 * @param productid
	 * @param productDetails
	 * @return
	 */
	@PutMapping("/product/{productid}")
	public ResponseEntity<Product> updateEmployee(final @PathVariable long productid, final @RequestBody Product productDetails) {
		final Product updateProduct = productRepository.findById(productid)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id: " + productid));

		updateProduct.setName(productDetails.getName());
		updateProduct.setType(productDetails.getType());

		productRepository.save(updateProduct);

		return ResponseEntity.ok(updateProduct);
	}
}
