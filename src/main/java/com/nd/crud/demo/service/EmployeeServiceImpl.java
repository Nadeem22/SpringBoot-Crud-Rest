package com.nd.crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nd.crud.demo.dao.EmployeeDao;
import com.nd.crud.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	// inject dao
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {

		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);

	}

}
