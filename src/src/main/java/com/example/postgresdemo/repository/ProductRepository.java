/**
 * 
 */
package com.example.postgresdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Product;

/**
 * @author Cybertech1
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long>{

}
