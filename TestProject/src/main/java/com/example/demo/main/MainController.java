package com.example.demo.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String main(Model model) {
		model.addAttribute("main","is good");
		return "main";
	}
	
}
