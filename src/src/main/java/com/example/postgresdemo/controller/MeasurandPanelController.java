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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.MeasurandPanel;
import com.example.postgresdemo.model.ProjectManager;
import com.example.postgresdemo.service.MeasurandPanelService;

/**
 * @author Cybertech1
 *
 */
@RestController
@RequestMapping("/api")
public class MeasurandPanelController {
	
	@Autowired
	private MeasurandPanelService measurandPanelService;
	
	@PostMapping("/create/panel")
	public MeasurandPanel creatPanel(@RequestBody MeasurandPanel measurandPanel)
	{
		
		return measurandPanelService.savePanel(measurandPanel);
		
	}
	
	/**
	 * @param panelId
	 * @param measurandPanel
	 * @return
	 */
	//creating panel
	@PutMapping("/panel/update/{id}")
	public ResponseEntity<MeasurandPanel> updatePanel(final @PathVariable(value = "id") Integer panelId, final @Valid@RequestBody MeasurandPanel measurandPanel) {
		try {
			if (panelId != null) {
				return measurandPanelService.updatePanel(panelId, measurandPanel);
			}

		} catch (Exception exception) {
			// TODO: handle exception
			throw new ResourceNotFoundException("id not match");
		}
		return measurandPanelService.updatePanel(panelId, measurandPanel);

	}
	
	//creating new panel 
	
	@GetMapping("/panel/new/created/{id}")
	public MeasurandPanel getPutById(final @PathVariable(value = "id") Integer panelId) {
		try {
			if (panelId != null) {
				return measurandPanelService.fetchByPanelId(panelId);
			}
		} catch (Exception exception) {
			throw new ResourceNotFoundException("id not match");
		}
		return null;
	}
	

}
