/*
 * Youtube Channel (Java Guides) - Spring Boot Thymeleaf CRUD Database Real-TIme Project
 * - 2. PART 2 (Implement List Employee Feature)
 * - 3. PART 3 (Implement Add Employee Feature)
 * - 4. PART 4 (Implement Update Employee Feature)
 * - 5. PART 5 (Implement Delete Employee Feature)
 * - 6. PART 6 (Implement Pagination Feature)
 * - 7. PART 7 (Implement Sorting Feature)
 * */
package com.kastamer.sbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastamer.sbtl.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//6) PART 6 (Implement Pagination Feature)
	//7) PART 7 (Implement Sorting Feature)
	//JpaRepository<T, I> is ALREADY EXTENDS ('extends') PagingAndSortingRepository<T, ID> SO there is NO NEED to WRITE any METHOD to IMPLEMENT SFEATURE of ORTING & PAGINATION  
}
