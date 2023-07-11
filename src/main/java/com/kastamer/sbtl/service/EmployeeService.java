/*
 * Youtube Channel (Java Guides) - Spring Boot Thymeleaf CRUD Database Real-TIme Project
 * - 2. PART 2 (Implement List Employee Feature)
 * - 3. PART 3 (Implement Add Employee Feature)
 * - 4. PART 4 (Implement Update Employee Feature)
 * - 5. PART 5 (Implement Delete Employee Feature)
 * - 6. PART 6 (Implement Pagination Feature)
 * - 7. PART 7 (Implement Sorting Feature)
 * */
package com.kastamer.sbtl.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.kastamer.sbtl.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	//3) PART 3 (Implement Add Employee Feature)
	void saveEmployee(Employee employee);
	
	//4) PART 4 (Implement Update Employee Feature)
	Employee getEmployeeById(long id);
	
	//5) PART 5 (Implement Delete Employee Feature)
	void deleteEmployeeById(long id);
	
	//6) PART 6 (Implement Pagination Feature)
	//Page<Employee> findPaginated(int pageNo, int pageSize); --> COMMENTED DUE to PRACTICE of 7)

	//7) PART 7 (Implement Sorting Feature)
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortAscOrDesc);
}
