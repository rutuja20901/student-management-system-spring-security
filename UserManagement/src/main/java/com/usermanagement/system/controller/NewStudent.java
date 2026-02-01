package com.usermanagement.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usermanagement.system.model.StudentForm;
import com.usermanagement.system.repository.NewStudentRepository;
import com.usermanagement.system.service.NewStudentService;
import com.usermanagement.system.service.StudentService;

@Controller
@RequestMapping("/students")
public class NewStudent {
	
	@Autowired
	private NewStudentService newStudentService;
	
	@Autowired
	private NewStudentRepository newStudentRepo;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
	    model.addAttribute("students", newStudentService.findAll());
	    return "dashboard";
	}

	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute StudentForm student ,RedirectAttributes redirectAttributes ) {
		
		try {
			newStudentService.save(student);
			redirectAttributes.addFlashAttribute("Success","StudentSave Successfully!");
			
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("error",e.getMessage());
		}
	
	    return "redirect:/students/dashboard";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletStudent(@PathVariable Long id) {
		newStudentService.delete(id);
		return "redirect:/students/dashboard";
	}


}
