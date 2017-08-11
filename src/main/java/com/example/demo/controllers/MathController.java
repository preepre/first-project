package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.models.Adder;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping("/math")
public class MathController {


	@GetMapping("calculator")
	public String calculateMe(String mathChoice, @RequestParam(name = "left") int number1, @RequestParam(name = "right") double number2, Model selectedAction) {

		if (mathChoice.equals("add")) {
			Adder a = new Adder(number1, number2);
			double result = a.calculate();
			selectedAction.addAttribute("output", result);

		} else { // otherwise do all other math

		}

		return "math/calculate";
	}

	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,
			Model model) {

		Adder adder = new Adder(first, second);
		double result = adder.calculate();

		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}

	///
	//
	@GetMapping("adder") // URL to which the form submits
	public String index() {
		return "math/adder";
	}
	//

}
