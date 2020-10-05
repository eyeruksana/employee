package com.ruksana.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruksana.app.model.Employee;
import com.ruksana.app.repository.EmpDAO;

@CrossOrigin(origins = "http://localhost:4200" ,maxAge = 3600)
@RestController
public class EmpController {
	
	@Autowired
	EmpDAO empdao;
	
	@RequestMapping("/empdata")
	public List<Employee> getEmpData() {
		
		List<Employee> emp=empdao.isData();
		return emp;
			}
	
	
	@RequestMapping("/login")
    public String userValidation() {
        return "User: Successfully logged in!";
    }
	
	
	
	
	

}
