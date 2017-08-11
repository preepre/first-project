package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;


@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("say-something")
	public String makeAChoice(String speechChoice, String message, Model selectedAction) {
		//if speechChoice is yell
		if (speechChoice.equals("yell")) {
			//make message loud		
			Yeller wooGal = new Yeller(message);
			String loud = wooGal.yell();
			selectedAction.addAttribute("output", loud);
			
		} else { //otherwise
			//make message whisper
			Whisperer shGal = new Whisperer(message);
			String quiet = shGal.whisper();
			selectedAction.addAttribute("output", quiet); //output will be in a mustache
			
		}
		
		return "helloworld/mixed-messages";
	}
	
	@GetMapping("message") //URL to which the form submits
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		
		Yeller y1 = new Yeller(message);
		String r1 = y1.yell();
				
		//This is the path src/main/resources/templates/helloworld/message.html
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", r1);
		return mv;
	}
	
	@GetMapping("whisper")
	public ModelAndView whisperer(@RequestParam(required=false, defaultValue="«shhhhhh»") String message) {
		
		Whisperer w1 = new Whisperer(message);
		String s1 = w1.whisper();

		
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		mv.addObject("title", title);
		mv.addObject("message", s1);
		return mv;
	}
	 
	
}
