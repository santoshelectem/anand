/**
 * 
 */
package com.example.postgresdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Cybertech1
 *
 */
@Entity
public class Metric {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer metricId;
	private String metricName;
	private boolean active;
	private String formula;
	/**
	 * @return the metricId
	 */
	public Integer getMetricId() {
		return metricId;
	}
	/**
	 * @param metricId the metricId to set
	 */
	public void setMetricId(Integer metricId) {
		this.metricId = metricId;
	}
	/**
	 * @return the metricName
	 */
	public String getMetricName() {
		return metricName;
	}
	/**
	 * @param metricName the metricName to set
	 */
	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}
	/**
	 * @param formula the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}
	

}
