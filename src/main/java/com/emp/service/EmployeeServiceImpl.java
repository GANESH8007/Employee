package com.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	//Dummy Employee List
	
	List<Employee> list=List.of(
			new Employee(1311L,"Peter Parker","11111111"),
			new Employee(1312L,"Ganesh Wahadne","222222"),
			new Employee(1313L,"Gauri Wahadne","3333333"),
			new Employee(1314L,"Pravin Wahadne","4444444"),
			new Employee(1315L,"Priya Wahadne","55555555"),
			new Employee(1316L,"Alex","6666666"),
			new Employee(1317L,"Andrew","777777")
			);
	
	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(employee -> employee.geteId().equals(id)).findAny().orElse(null);
	}

}
