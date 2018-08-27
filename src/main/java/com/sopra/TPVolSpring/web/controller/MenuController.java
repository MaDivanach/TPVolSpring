package com.sopra.TPVolSpring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping(value = { "/" })
	public String home(Model model) {

		return "menu";

	}
	
//	@RequestMapping(value = { "/passager" })
//	public ModelAndView passager(Model model) {
//
//		return new ModelAndView("redirect:/passager");
//
//	}
	@RequestMapping("/passager")
    public String passager() {
        return "redirect:/passager/";
    }
	@RequestMapping("/vol")
	public String vol() {
		return "redirect:/vol/";
	}
	@RequestMapping("/reservation")
	public String reservation() {
		return "redirect:/reservation/";
	}
	@RequestMapping("/compagnieAerienne")
	public String compagnieAerienne() {
		return "redirect:/compagnieAerienne/";
	}
	@RequestMapping("/client")
	public String client() {
		return "redirect:/client/";
	}

}
