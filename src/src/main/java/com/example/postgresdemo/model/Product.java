/**
 * 
 */
package com.example.postgresdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cybertech1
 *
 */
@Entity
@Table(name = "product")
public class Product {
/**
 * product Id 
 */
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long productId;
/**
 * product Name
 */
private String name;
/**
 * product type
 */
private String type;
/**
 * @param productId
 * @param name
 * @param type
 */
public Product(Long productId, String name, String type) {
	super();
	this.productId = productId;
	this.name = name;
	this.type = type;
}
/**
 * @return the productId
 */
public Long getProductId() {
	return productId;
}
/**
 * @param productId the productId to set
 */
public void setProductId(Long productId) {
	this.productId = productId;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the type
 */
public String getType() {
	return type;
}
/**
 * @param type the type to set
 */
public void setType(String type) {
	this.type = type;
}
/**
 * 
 */
public Product() {
	super();
}

}
