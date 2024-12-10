package site.rion.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import site.rion.Ecommerce.dto.SignupForm;
import site.rion.Ecommerce.service.AuthService;

@Controller
public class AuthController
{
	@Autowired
	AuthService authService;
	
	@GetMapping("/login")
	public String loginGet()
	{
		return "auth/login.html";
	}
	
	@GetMapping("/signup")
	public String signupGet(Model model)
	{
		model.addAttribute("form", new SignupForm());
		return "auth/signup.html";
	}
	
	@PostMapping("/signup")
	public String signupPost(@ModelAttribute SignupForm form)
	{
		Boolean success = authService.save(form);
		
		if ( success )
    	{
    		return "redirect:/login";
    	}
    	else
    	{
    		return "redirect:/signup";
    	}
	}
}