package com.springjdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springjdbc.api.Student;
import com.springjdbc.api.StudentDTO;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	private IStudentService service;
	
	@GetMapping("/show-Students")
	public String showStudentList(Model model) {
		List<Student> studentsList = service.loadStudents();
		model.addAttribute("students", studentsList);
		return "student-list";
	}

	@GetMapping("/add-Student")
	public String addStudent(Model model) {
		StudentDTO studentDTO = new StudentDTO();
		model.addAttribute("studentDTO", studentDTO);
		return "add-student";
	}

	@PostMapping("/handle-AddStudent")
	public String handleAddStudent(StudentDTO studentDTO) {
		// logic for either add or update needs to be done
		if(studentDTO.getId() == 0) 
		   service.addStudent(studentDTO);
		else 
			service.updateStudent(studentDTO);
		
		return "redirect:/show-Students";
	}
	
	@GetMapping("/update-Student")
	public String updateStudent(@RequestParam int userId, Model model) {
		Student studentFromDb = service.getById(userId);
		model.addAttribute("studentDTO", studentFromDb);
		return "add-student";
	}
	
	@GetMapping("/delete-Student")
	public String deleteStudent(@RequestParam int userId) {
		service.deleteById(userId);
		return "redirect:/show-Students";
	}

	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/thank-you") public String thankYou() { return
	 * "Thank you..!! Student data has been saved to the Database"; }
	 */

}
