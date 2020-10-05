package com.ruksana.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ruksana.app.model.Employee;

@Repository
public class EmpDAO {
	
	     @Autowired
	     private JdbcTemplate template;
	
	private static final String sql="select * from users";
	private static final String sql1="select * from employeeDdata where empID=?";
	
	public List<Employee> isData(){
		
		List<Employee> emp = new ArrayList<Employee>();
		List<Map<String, Object>>	rows=template.queryForList(sql);
		
		for(Map<String, Object> row :rows) {
			Employee employee= new Employee();
			
			employee.setEmpID((String)row.get("EmpID"));
			employee.setEmpName((String)row.get("EmpName"));
			employee.setGender((String)row.get("gender"));
			employee.setSalary((String)row.get("salary"));
			
			emp.add(employee);
		}
		
		
		 
		 return emp;
		
	}
	
public List<Employee> isDataByID(){
		
		List<Employee> emp = new ArrayList<Employee>();
		List<Map<String, Object>>	rows=template.queryForList(sql);
		
		for(Map<String, Object> row :rows) {
			Employee employee= new Employee();
			
			employee.setEmpID((String)row.get("EmpID"));
			employee.setEmpName((String)row.get("EmpName"));
			employee.setGender((String)row.get("gender"));
			employee.setSalary((String)row.get("salary"));
			
			emp.add(employee);
		}
		
		
		 
		 return emp;
		
	}
	


}
