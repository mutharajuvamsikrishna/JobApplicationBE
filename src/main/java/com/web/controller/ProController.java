package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.PerEmp;
import com.web.model.Pro;
import com.web.repo.PerEmpRepo;
import com.web.repo.ProRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProController {

	@Autowired
	private ProRepo proRepo;
	@Autowired
	private ProRepo repo1;
	@Autowired
	private PerEmpRepo repo;

	@GetMapping("/req")

	public List<Pro> getPros() {
		return repo1.findAll();
	}

	@GetMapping("/search")

	public List<Pro> searchPro(@RequestParam("query") String query, Model model) {
		List<Pro> users1 = proRepo.searchPro(query);
		model.addAttribute("users1", users1);
		return users1;
	}

	@DeleteMapping(value = "/delete") // edited /per455
	public String delete(@RequestParam Long regno) {
		repo1.deleteById(regno);

		return "Deleted Sucess Fully";
	}

	@DeleteMapping(value = "/deletepersonal") // edited /per455
	public String deletepersonal(@RequestParam Long regno) {

		repo.deleteById(regno);
		return "Deleted Sucess Fully";
	}

	@GetMapping("/personalviewall")

	public List<PerEmp> getPerEmps() {
		return repo.findAll();
	}
}
