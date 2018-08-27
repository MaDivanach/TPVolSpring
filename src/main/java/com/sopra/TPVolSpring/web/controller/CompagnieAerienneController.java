package com.sopra.TPVolSpring.web.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sopra.TPVolSpring.model.CompagnieAerienne;
import com.sopra.TPVolSpring.repositories.CompagnieAerienneRepository;


@Controller
@RequestMapping("/compagnieAerienne")
public class CompagnieAerienneController {

	@Autowired
	private CompagnieAerienneRepository compagnieAerienneRepository;

	
	@RequestMapping(value = { "/" })
	public String list(Model model) {
		model.addAttribute("compagnieAerienne", compagnieAerienneRepository.findAll());
		return "compagnieAerienne/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id, Model model) {
		compagnieAerienneRepository.deleteById(id);
		return "redirect:/compagnieAerienne/";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam(name = "id") Long id, Model model) {
		Optional<CompagnieAerienne> opt = compagnieAerienneRepository.findById(id);
		if (opt.isPresent()) {
			return goEdit(opt.get(), model);
		} else {
			model.addAttribute("compagnieAerienne", new CompagnieAerienne());
		}
		return "redirect:/compagnieAerienne/";
	}

	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("compagnieAerienne") CompagnieAerienne compagnieAerienne, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(compagnieAerienne, model);
		} else {
			compagnieAerienneRepository.save(compagnieAerienne);
			return "redirect:/compagnieAerienne/";
		}
	}

	@RequestMapping("/add")
	public String add(Model model) {
		return goEdit(new CompagnieAerienne(), model);
	}

	public String goEdit(CompagnieAerienne compagnieAerienne, Model model) {
		model.addAttribute("compagnieAerienne", compagnieAerienne);
		return "compagnieAerienne/edit";
	}
}
