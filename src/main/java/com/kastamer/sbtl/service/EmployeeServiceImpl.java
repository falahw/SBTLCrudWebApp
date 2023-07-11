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
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kastamer.sbtl.model.Employee;
import com.kastamer.sbtl.repository.EmployeeRepository;

@Service
//@Transactional --> we CAN USE THIS but THIS is ALREADY HANDLED INTERNALLY by JPA HIBERNATE ('JpaRepository' will internally PROVIDE TRANSACTIONAL MANAGEMENT for ALL CRUD database OPERATIONS BELOW)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();  //return null;
	}

	//3) PART 3 (Implement Add Employee Feature)
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.empRepo.save(employee);
	}

	//4) PART 4 (Implement Update Employee Feature)
	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optEmpl = empRepo.findById(id);
		Employee empl = null;
		
		if (optEmpl.isPresent()) {
			empl = optEmpl.get();
		} else {
			throw new RuntimeException("Employee not found for id :: " + id);
		}
		
		return empl; //return null;
	}

	//5) PART 5 (Implement Delete Employee Feature)
	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.empRepo.deleteById(id);
	}

	//6) PART 6 (Implement Pagination Feature)
	/* --> COMMENTED DUE to PRACTICE of 7)
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		//'PageRequest' is a CLASS that IMPLEMENT an INTERFACE 'Pageable' which is PROVIDED by SPRING DATA JPA 
		//CREATE OBJECT 'pageable' of 'Pageable' and ASSIGN VALUE to it WITH 'PageRequest' (REQUESTED PAGE) in SPECIFIED POSITION of 'pageNo - 1' AMONG the 'pageSize' (SIZE of PAGE) 
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return this.empRepo.findAll(pageable); //return null;
	}
	*/
	
	//7) PART 7 (Implement Sorting Feature)
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortAscOrDesc) {
		// TODO Auto-generated method stub
		//INITIALIZE 'sort' AS an OBJECT of CLASS 'Sort' which VALUE is 'sortAscOrDesc. ...'
		//'Sort.Direction.ASC.name()' MEANS this is USING enum 'Direction' WHICH is DECLARED in CLASS 'Sort' so NO NEED to HARD CODE the ASCENDING VALUE
		Sort sort = sortAscOrDesc.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort); //ADDING PARAMETER 'sort' MAKES OBJECT 'pageable' ABLE to do BOTH PAGINATION & SORTING
		
		return this.empRepo.findAll(pageable); //return null; --> IF 'pageable' is REPLACED with 'sort' THEN .findAll([param]) will ONLY ABLE to DO SORTING
	}
}
