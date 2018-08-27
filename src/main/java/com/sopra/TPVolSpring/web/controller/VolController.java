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

import com.sopra.TPVolSpring.model.Vol;
import com.sopra.TPVolSpring.repositories.AeroportRepository;
import com.sopra.TPVolSpring.repositories.VolRepository;

@Controller
@RequestMapping("/vol")
public class VolController {

	@Autowired
	private VolRepository volRepository;
	
	@Autowired
	private AeroportRepository aeroportRepository;

	@RequestMapping(value = { "/" })
	public String list(Model model) {

		model.addAttribute("vols", volRepository.findAll());
		return "vol/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id, Model model) {

		volRepository.deleteById(id);
		return "redirect:/vol/";
	}

	@RequestMapping("/edit")
	public String update(@RequestParam(name = "id") Long id, Model model) {

		Optional<Vol> opt = volRepository.findById(id);

		if (opt.isPresent()) {

			return goEdit(opt.get(), model);

		} else {
			return goEdit(new Vol(), model);

		}

	}

	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("vol") Vol vol, BindingResult br, Model model) {

		if (vol.getDateArrivee().compareTo(vol.getDateDepart()) < 0) {
			return goEdit(vol, model);
			
		} else {
			if (br.hasErrors()) {

				return goEdit(vol, model);

			} else {

				volRepository.save(vol);
				return "redirect:/vol/";
			}
		}

	}

	@RequestMapping("/add")
	public String add(Model model) {

		return goEdit(new Vol(), model);

	}

	private String goEdit(Vol vol, Model model) {

		model.addAttribute("aeroports", aeroportRepository.findAll());
		model.addAttribute("vol", vol);
		return "vol/edit";
	}


	
	@RequestMapping("/detail")
    public String reservations(@RequestParam(name = "id") Long id, Model model) {
        Optional<Vol> opt= volRepository.findCustomByIdWithReservation(id);
        if (opt.isPresent()) {
            model.addAttribute("reservations", opt.get().getReservations());
            return "reservation/list";
        }
         return "redirect:/vol/";
    }
}
