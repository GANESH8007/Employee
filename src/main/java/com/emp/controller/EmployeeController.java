package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emp.entity.Employee;
import com.emp.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeService iEmployeeService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/{eId}")
	public Employee getEmployee(@PathVariable("eId") Long eId) {
		Employee employee=this.iEmployeeService.getEmployee(eId);
		
		//http://localhost:9090/record/emp/13111
		//List records=this.restTemplate.getForObject("http://localhost:9090/record/emp/" +eId, List.class);
		List records=this.restTemplate.getForObject("http:record-Microservice/record/emp/" +eId, List.class);
		employee.setRecords(records);
		return employee;
	}
	
}
