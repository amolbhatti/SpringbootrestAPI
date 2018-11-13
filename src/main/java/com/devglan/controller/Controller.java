package com.devglan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.dao.Dao;
import com.devglan.model.Model;

@RestController
@RequestMapping("/company")
public class Controller {
	@Autowired
	Dao employeeDAO;
	
	/* to save an employee*/
	@PostMapping("/employees")
	public Model createEmployee(@Valid @RequestBody Model emp) {
		return employeeDAO.save(emp);
	}
	
	/*get all employees*/
	@GetMapping("/employees")
	public List<Model> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Model> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Model emp=(Model) employeeDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/employees/{id}")
	public ResponseEntity<Model> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Model empDetails){
		
		Model emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setFirstName(empDetails.getFirstName());
		emp.setLastName(empDetails.getLastName());
		emp.setEmail(empDetails.getEmail());
		emp.setPassword(empDetails.getPassword());
		
		Model updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Model> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Model emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
