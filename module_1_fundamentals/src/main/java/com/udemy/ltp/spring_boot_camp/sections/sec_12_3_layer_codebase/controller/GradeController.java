// GradeController is in the presentation layer that manages views & models
package com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.controller;

import com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.model.Grade;
import com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class GradeController {
	GradeService gradeService = new GradeService();

	@GetMapping("/")
	public String getForm(
		Model model,
		@RequestParam(required = false) String id
	) {
		model.addAttribute("grade", gradeService.getGradeById(id));

		return "form1";
	}

	@GetMapping("/grades")
	public String getGrades(Model model) {
		model.addAttribute("grades", gradeService.getGrades());

		return "grades";
	}

	@PostMapping("/handle-submit")
	public String submitForm(@Valid Grade grade, BindingResult result) {
		System.out.println(
			"name: " + grade.getName() +
			" | subject: " + grade.getSubject() +
			" | result.hasErrors() -> " + result.hasErrors()
		);

		if(result.hasErrors()) {
			return "form1";
		}

		gradeService.submitGrade(grade);

		return "redirect:/grades";
	}
}
