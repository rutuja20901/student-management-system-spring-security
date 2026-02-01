package com.usermanagement.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usermanagement.system.dto.LoginRequest;
import com.usermanagement.system.dto.RegisterRequest;
import com.usermanagement.system.model.Student;
import com.usermanagement.system.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}

	
	@PostMapping("/register")
	public String registerProcess(@ModelAttribute RegisterRequest request,RedirectAttributes redirectAttributes) {
		
		try {
			studentService.register(request);
			redirectAttributes.addFlashAttribute("Success","StudentSave Successfully!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("Error",e.getMessage());
		}
		return "redirect:/login";
	}
	
	@PostMapping("/login")
	public String loginProcess(@ModelAttribute LoginRequest request) {

		return "redirect:/students/dashboard";
	}
	
	
	
	
	
}
