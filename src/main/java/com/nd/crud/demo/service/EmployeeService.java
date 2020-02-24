package com.nd.crud.demo.service;

import java.util.List;

import com.nd.crud.demo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmloyee);
	public void deleteById(int theId);

}
