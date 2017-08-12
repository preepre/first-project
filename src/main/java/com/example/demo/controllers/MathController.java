package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.models.Adder;
import com.example.demo.models.Divider;
import com.example.demo.models.Exponent;
import com.example.demo.models.ModuloDivider;
import com.example.demo.models.Multiplier;
import com.example.demo.models.Subtracter;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping("/math")
public class MathController {


	@GetMapping("calculate")
	public String calculateMe(String mathChoice, @RequestParam(name = "left") int number1, @RequestParam(name = "right") double number2, Model selectedAction) {
		double result = 0.0;

		if (mathChoice.equals("add")) {
			Adder a = new Adder(number1, number2);
			result = a.calculate();
			selectedAction.addAttribute("output", result);

		} else if (mathChoice.equals("subtract")) { // otherwise do all other math
			Subtracter s = new Subtracter(number1, number2);
			result = s.calculate();
			selectedAction.addAttribute("output", result);	
			
		} else if (mathChoice.equals("multiply")) {
			Multiplier m = new Multiplier(number1, number2);
			result = m.calculate();
			selectedAction.addAttribute("output", result);
						
		} else if (mathChoice.equals("divide")) {
			Divider d = new Divider(number1, number2);
			result = d.calculate();
			selectedAction.addAttribute("output", result);
			
		} else if(mathChoice.equals("percent")) {
			ModuloDivider mD = new ModuloDivider(number1, number2);
			result = mD.calculate();
			selectedAction.addAttribute("output", result);
			
		} else if(mathChoice.equals("exponent")) {
			Exponent e = new Exponent(number1, number2);
			result = e.calculate();
			selectedAction.addAttribute("output", result);
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
