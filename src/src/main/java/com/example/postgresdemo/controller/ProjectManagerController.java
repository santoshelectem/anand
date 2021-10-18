/**
 * 
 */
package com.example.postgresdemo.controller;

import java.util.List;

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
import com.example.postgresdemo.model.Developer;
import com.example.postgresdemo.model.Project;
import com.example.postgresdemo.model.ProjectManager;
import com.example.postgresdemo.model.Task;
import com.example.postgresdemo.service.ProjectManagerService;

/**
 * @author Cybertech1
 *
 */
@RestController
@RequestMapping("/rest/api")
public class ProjectManagerController {
	/**
	 * dependancy injection
	 */
	@Autowired
	private ProjectManagerService projectManagerService;

	/**
	 * @param projectManager
	 * @return
	 */
	@PostMapping("/projectManager")
	public ProjectManager createProduct(final @Valid @RequestBody ProjectManager projectManager) {
	    
		 final List<Project> projects = projectManager.getProjects();
		 String DeveleperName;
		 
		 for (final Project project : projects) {
			final List<Task> tasks = project.getTasks();
			for (final Task task : tasks) {
				 DeveleperName = task.getDeveloper().getName();
				//System.out.println(DeveleperName);
			}
		}

		
		return projectManagerService.saveUpdate(projectManager);
	}

	/**
	 * @param pid
	 * @return
	 */
	@GetMapping("/projectManager/{pid}")
	public ProjectManager getProductById(final @PathVariable(value = "pid") Integer pid) {
		try {
			if (pid != null) {
				return projectManagerService.fetchById(pid);
			}
		} catch (Exception exception) {
			throw new ResourceNotFoundException("id not match");
		}
		return null;
	}

	/**
	 * @param projectmanagerId
	 * @param projectmanagerDetails
	 * @return
	 */
	@PutMapping("/projectManagers/{pid}")
	public ResponseEntity<ProjectManager> updateProjectManager(final @PathVariable(value = "pid") Integer projectManagerId, final @Valid @RequestBody ProjectManager projectmanagerDetails) {
		try {
			if (projectManagerId != null) {
				return projectManagerService.updateManager(projectManagerId, projectmanagerDetails);
			}

		} catch (Exception exception) {
			// TODO: handle exception
			throw new ResourceNotFoundException("id not match");
		}
		return projectManagerService.updateManager(projectManagerId, projectmanagerDetails);

	}
	
	
	/**
	 * @param pid
	 * @return
	 */
	
	/**
	 * @return
	 */
	//project manager highest task completed
	@GetMapping("/projectManagerHihest")
	public ProjectManager getProjectManager() {
		ProjectManager findProjectmanager;
		try {
			findProjectmanager = projectManagerService.findProjectmanager();
		} catch (Exception exception) {
			throw new ResourceNotFoundException("id not match");
		}
		return findProjectmanager;
	}
	
	@GetMapping("/DeveleperLesTask")
	public Developer getlesNumbetask() {
		try {
			return projectManagerService.developerLesTask();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
}
