package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model){
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required = false, defaultValue = "0") Integer a,
			@RequestParam(value = "b", required = false, defaultValue = "0") Integer b, Model model) {
		
		String output = "";
		String hasil = "h";
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		if (a==0){
			a = 1;
		}
		for(int i=0; i<a; i++) {
			hasil += "m";
		}
		
		if (b==0) {
			b = 1;
		}
		for(int j=0; j<b; j++) {	
			output += hasil + " ";
		}
		model.addAttribute("output", output);
		return "viralgenerator";
		
	}

	
}
