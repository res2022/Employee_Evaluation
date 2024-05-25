package com.example.tts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tts.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	

	
	public List<Employee> findByEmpDesignation(String desgn);
		

	@Query(value="select * from employee where desgn !='ProjectManager'",
			nativeQuery=true)
	public List<Employee> findByEmpDesgnNotPM();
	
	@Query(value="select * from employee where desgn ='ProjectManager'",
			nativeQuery=true)
public List<Employee> findByPMdessgn();
	
	
	@Query(value="select max(id)  from employee",
			nativeQuery=true)
public Employee findByMaxEmpId();
	
	
}

