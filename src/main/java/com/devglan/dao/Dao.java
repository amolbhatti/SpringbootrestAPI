package com.devglan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.model.Model;
import com.devglan.repositary.Repositary;

@Service
public class Dao {
	
	@Autowired
   Repositary employeeRepository;
/*to save an employee*/
	
	public Model save(Model emp) {
		return employeeRepository.save(emp);
	}
	

	/* search all employees*/
	
	public List<Model> findAll(){
		return employeeRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Model findOne(Long empid) {
		return employeeRepository.findById(empid).orElse(null);
	}
	
	
	
	/*delete an employee*/
	
	public void delete(Model emp) {
		employeeRepository.delete(emp);
	}
}
