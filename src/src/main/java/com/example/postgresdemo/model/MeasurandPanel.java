/**
 * 
 */
package com.example.postgresdemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Cybertech1
 *
 */
@Entity
public class MeasurandPanel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer panelId;
	private String panelName;
	private String panelDescription;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="panelId")
	private List<Metric> metric=new ArrayList<>();
	/**
	 * @return the panelId
	 */
	public Integer getPanelId() {
		return panelId;
	}
	/**
	 * @param panelId the panelId to set
	 */
	public void setPanelId(Integer panelId) {
		this.panelId = panelId;
	}
	/**
	 * @return the panelName
	 */
	public String getPanelName() {
		return panelName;
	}
	/**
	 * @param panelName the panelName to set
	 */
	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}
	/**
	 * @return the panelDescription
	 */
	public String getPanelDescription() {
		return panelDescription;
	}
	/**
	 * @param panelDescription the panelDescription to set
	 */
	public void setPanelDescription(String panelDescription) {
		this.panelDescription = panelDescription;
	}
	/**
	 * @return the metric
	 */
	public List<Metric> getMetric() {
		return metric;
	}
	/**
	 * @param metric the metric to set
	 */
	public void setMetric(List<Metric> metric) {
		this.metric = metric;
	}
	
	

}
