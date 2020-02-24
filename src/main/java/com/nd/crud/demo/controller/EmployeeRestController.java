package com.nd.crud.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nd.crud.demo.entity.Employee;
import com.nd.crud.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	//inject the dao
	@Autowired
	private EmployeeService employeeService;
	
	//mapping to get all Employee ---/employees
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
	List<Employee> employees=	employeeService.findAll();
	return  employees;
	}
	
	//mapping to get employeeById ---/employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
	Employee employee=employeeService.findById(employeeId);
	if(employee==null) {
		throw new RuntimeException("No Employe Found for Given Id:- " +employeeId);
	}
	return employee;
	}
	
	//POST mapping to add employee ---/employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//PUT mapping to Update employee ---/employee/{employeeId}
	
	@PutMapping("/employees")
	public Employee updateEnployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	//DELETE mapping to delete Employee ByID ---/employees/{employeeId}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee=employeeService.findById(employeeId);
		if(employee==null) {
			throw new RuntimeException("This Employee is Not Exis" +employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Employee Deleted Sucessfully -" +employeeId;
	}
}
