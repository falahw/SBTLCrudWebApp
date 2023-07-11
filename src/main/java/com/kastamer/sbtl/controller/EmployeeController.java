/*
 * Youtube Channel (Java Guides) - Spring Boot Thymeleaf CRUD Database Real-TIme Project
 * - 2. PART 2 (Implement List Employee Feature)
 * - 3. PART 3 (Implement Add Employee Feature)
 * - 4. PART 4 (Implement Update Employee Feature)
 * - 5. PART 5 (Implement Delete Employee Feature)
 * - 6. PART 6 (Implement Pagination Feature)
 * - 7. PART 7 (Implement Sorting Feature)
 * */
package com.kastamer.sbtl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kastamer.sbtl.model.Employee;
import com.kastamer.sbtl.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	//METHOD to DISPLAY LIST of EMPLOYEES
	@GetMapping("/")
	private String viewHomePage(Model model) {
		// TODO Auto-generated method stub
		/*
		model.addAttribute("daftarPekerja", empService.getAllEmployees());
		
		return "index";
		*/
		
		//6) PART 6 (Implement Pagination Feature)
//		return findPaginatedPage(1, model); //ALTER DEFAULT SHOW in index.html WITH THIS --> COMMENTED DUE to PRACTICE of 7)
		
		//7) PART 7 (Implement Sorting Feature)
		return findPaginatedPage(1, "firstName", "asc", model); //TWO MORE PARAMETERS are ADDED ('firstName' as DEFAULT SORTING FIELD & 'asc' as DEFAULT SORTING DIRECTION)
	}
	
	//3) PART 3 (Implement Add Employee Feature)
	@GetMapping("/showNewEmployeeForm")
	private String showNewEmployeeForm(Model model) {
		// TODO Auto-generated method stub
		Employee empl = new Employee(); //CREATE MODEL ATTRIBUTE to BIND FORM DATA
		model.addAttribute("karyawan", empl); //Thymeleaf TEMPLATE will ACCESS this EMPTY OBJECT Employee() to BIND with DATA FORM
		
		return "new-employee-form";
	}
	
	@PostMapping("/saveEmployee")
	private String saveEmployee(@ModelAttribute("karyawan") Employee empl) {
		// TODO Auto-generated method stub
		empService.saveEmployee(empl); //INSERT DATA which SENT from DATA FORM in 'new-employee-form.html' to DATABASE 
		
		return "redirect:/"; //REDIRECT to HOME-PAGE
	}
	
	//4) PART 4 (Implement Update Employee Feature)
	@GetMapping("/showUpdateForm/{id}")
	private String showUpdateForm(@PathVariable(value = "id") long idEmpl, Model model) {
		// TODO Auto-generated method stub
		Employee empl = empService.getEmployeeById(idEmpl); //GET EMPLOYEE from THE SERVICE and FILTERED by ID
		model.addAttribute("pekerja", empl); //SET EMPLOYEE AS a Model ATTRIBUTE to PRE-POPULATE the DATA FORM
		
		return "update-employee-form"; //Employee() OBJECT 'empl' will be POPULATED in THIS WEB-PAGE (Thymeleaf TEMPLATE)
	}
	
	//5) PART 5 (Implement Delete Employee Feature)
	//we USE '@GetMapping' INSTEAD of '@DeleteMapping' BECAUSE this is NOT REST-API
	@GetMapping("/deleteEmployee/{unique}")
	private String delEmployee(@PathVariable(value = "unique") long idEmpl) {
		// TODO Auto-generated method stub
		this.empService.deleteEmployeeById(idEmpl);
		
		return "redirect:/";
	}
	
	//6) PART 6 (Implement Pagination Feature)
	/* --> COMMENTED DUE to PRACTIVE of 7)
	@GetMapping("/page/{pageNo}") //'("/page/{pageNo}/{pageSize}")' --> VALUE of '{pageSize}' CAN be GOTTEN from UI IF we WANT var 'pageSize' (SIZE of PAGE) to be FLEXIBLE
	private String findPaginatedPage(@PathVariable(value = "pageNo") int pageNum, Model model) {
		// TODO Auto-generated method stub
		int pageSize = 5; //SIZE of MAXIMUM ROW that CAN be SHOWN in ONE PAGE (SHOULD be FLEXIBLE)
		
		Page<Employee> page = empService.findPaginated(pageNum, pageSize);
		List<Employee> empList = page.getContent(); //PUT DATA ROW into a 'page' as MANY as DEFINED BY 'pageSize' & ASSIGN it to 'empList'
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("daftarPekerja", empList);
		
		return "index";
	}
	*/
	//7) PART 7 (Implement Sorting Feature)
	//URL WANTED e.g: '/page/1?sortField=name&sortDir=asc'
	@GetMapping("/page/{pageNo}")
	private String findPaginatedPage(@PathVariable(value = "pageNo") int pageNum,
			@RequestParam("colToBeSorted") String sortField,
			@RequestParam("sortAscOrDesc") String sortDir,
			Model model) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		
		Page<Employee> page = empService.findPaginated(pageNum, pageSize, sortField, sortDir);
		List<Employee> empList = page.getContent();
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		//GIVE INFORMATION of SORTING TEMPLATE to Tyhmeleaf BY PASSING 3 'Attribute' to OBJECT 'model' SO they CAN be USED to SUPPORT SORTING IN Thymeleaf TEMPLATE 
		model.addAttribute("sortCol", sortField);
		model.addAttribute("sortDirection", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc"); //THIS is USED to TRIGGER SORTING when COLUMN is CLICKED
		
		model.addAttribute("daftarPekerja", empList);
		
		String checkVar = "variable";
		model.addAttribute("var", checkVar);
		
		return "index";
	}
	
}
