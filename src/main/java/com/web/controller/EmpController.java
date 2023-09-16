package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.PerEmp;
import com.web.model.Pro;
import com.web.repo.PerEmpRepo;
import com.web.repo.ProRepo;
import com.web.repo.Pythonrepo;
import com.web.repo.RegisterRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmpController {
	@Autowired
	private PerEmpRepo repo;

	@Autowired
	private Pythonrepo repop;

	@Autowired
	private ProRepo repo1;

	@Autowired
	private RegisterRepo repo5;

	@PostMapping(value = "/persave") // save personal details
	public String saveperemp(@RequestBody PerEmp emp, ModelMap model) {

		repo.save(emp);
		return "sucess";
	}

	@PostMapping("/prosave") // save professional details
	public String profesionalsave(@RequestBody Pro emp, Model model) {

		repo1.save(emp);

		return "personaldetails";

	}

}
