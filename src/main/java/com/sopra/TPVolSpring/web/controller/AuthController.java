package com.sopra.TPVolSpring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

		@RequestMapping(value="/login")
		public String login(Model model) {
			return "login";
		}
	
}
	
