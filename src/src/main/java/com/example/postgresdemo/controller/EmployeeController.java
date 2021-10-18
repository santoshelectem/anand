/**
 * 
 */
package com.example.postgresdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.repository.EmployeeRepository;
import com.example.postgresdemo.service.EmployeService;

/**
 * @author Cybertech1
 *
 */
@RestController
public class EmployeeController {
	//private static final Logger LOG = Logger.
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * EmployeeController
	 */
	@Autowired
	private EmployeService employeService;
	

	/**
	 * @param employee
	 * @return
	 */
	@PostMapping("/employee")
	public Employee saveEmployee(final @Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	/**
	 * fetch recod based on metric name and panelId
	 */
	@GetMapping("/employee")
	public List<Employee> fetchEmployee() {
		// LOG.info("Start of EmployeeController : fetchEmployee : employeeId
		// :");
		List<Employee> employee = null;
		try {

			employee = employeService.fetchAllEmployees();

		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("searchMetric");
		}
		// LOG.info("End EmployeeController : fetchEmployee : employeeId :");
		return employee;
	}
	
	
	/**
	 * @param employeeRepository
	 * @param employeService
	 */
	public EmployeeController(final EmployeeRepository employeeRepository,final  EmployeService employeService) {
		super();
		this.employeeRepository = employeeRepository;
		this.employeService = employeService;
	}


	/**
	 * @param employeeId
	 * @return
	 */
	//fetch the data from database by employee Id
	@GetMapping("/employee/{employeeId}")
	public Employee fetchEmployeeId(final @PathVariable Long employeeId) {
		// LOG.info("Start of EmployeeController : fetchEmployee : employeeId
		// :");
		Employee employee = null;
		try {

			employee = employeService.fetchEmployeesById(employeeId);

		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("searchMetric");
		}
		// LOG.info("End EmployeeController : fetchEmployee : employeeId :");
		return employee;
	}
	
	
	 /**
	 * @param employeeId
	 * @return
	 */
	//delete data by id
	@DeleteMapping("/employee/{employeeId}")
	    public ResponseEntity<HttpStatus> deleteEmployee(final @PathVariable long employeeId){

	       final  Employee employee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + employeeId));

	        employeeRepository.delete(employee);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }
	 
	   // build update employee REST API
	    /**
	     * @param employeeId
	     * @param employeeDetails
	     * @return
	     */
	    @PutMapping("/employee/{employeeId}")
	    public ResponseEntity<Employee> updateEmployee(final @PathVariable long employeeId,
			final @RequestBody Employee employeeDetails) {
		final Employee updateEmployee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + employeeId));

		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setEmailId(employeeDetails.getEmailId());

		employeeRepository.save(updateEmployee);

		return ResponseEntity.ok(updateEmployee);
	}

}
