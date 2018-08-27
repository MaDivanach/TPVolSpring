package com.sopra.TPVolSpring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping(value = { "/" })
	public String home(Model model) {

		return "menu";

	}

}
