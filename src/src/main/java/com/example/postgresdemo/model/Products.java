/**
 * 
 */
package com.example.postgresdemo.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Cybertech1
 *
 */
@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	private String name;
	@CreationTimestamp
	private LocalDateTime createDate;
	 
	@UpdateTimestamp
	private LocalDateTime updateDate;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH ,CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinTable(name = "product_resources", joinColumns = @JoinColumn(name = "product_FK", referencedColumnName = "pId"), inverseJoinColumns = @JoinColumn(name = "resource_FK", referencedColumnName = "rId"))
	private List<Resources> resources = new ArrayList<Resources>();
	/**
	 * @return the pId
	 */
	public Integer getpId() {
		return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(Integer pId) {
		this.pId = pId;
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
	 * @return the createDate
	 */
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the updateDate
	 */
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return the projects
	 */
	public List<Resources> getResources() {
		return resources;
	}
	/**
	 * @param projects the projects to set
	 */
	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}
	

}
