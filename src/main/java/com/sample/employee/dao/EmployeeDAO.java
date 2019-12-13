package com.sample.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sample.employee.entity.Employee;

public interface EmployeeDAO extends CrudRepository<Employee,Long> {
		
	@Query("from Employee where name=?1")
	List<Employee> findByName(String name);
	
	@Query("from Employee where department =?1 or department =?2")
	List<Employee> findByDept(String dept1 , String dept2);
	
}
