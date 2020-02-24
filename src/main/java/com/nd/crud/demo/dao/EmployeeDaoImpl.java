package com.nd.crud.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nd.crud.demo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	//inject the Entity Manager
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		this.entityManager=theEntityManager;
	}

	@Override
	
	public List<Employee> findAll() {
		//get the current hibernate session
		Session curentSession =entityManager.unwrap(Session.class);
		//crete the querty
		Query <Employee> theQuery=curentSession.createQuery("from Employee",Employee.class);
		//execute the query and get the reslt
		List<Employee> employees=theQuery.getResultList();
		// return the result
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		// get Employee        
		Employee employee=currentSession.get(Employee.class, theId);
		//return the employee
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		//get current hibernate session 
		Session currentSession=entityManager.unwrap(Session.class);
		//save the employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		//get current hibernate session 
		Session currentSession=entityManager.unwrap(Session.class);
		//create the query
		Query theQuery=currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		// execute the query
		theQuery.executeUpdate();
		
	}

}
