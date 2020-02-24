package com.nd.crud.demo.dao;

import java.util.List;

import com.nd.crud.demo.entity.Employee;

public interface EmployeeDao {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);

}
