package com.wiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.wiki.model.Users;
import com.wiki.service.UsersService;

@Controller
public class Register{

	@Autowired
	UsersService usersService;
	
	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String displayRegisterPage(Model model, @ModelAttribute("user") Users user) {
		
		Users newUser = new Users();
		
		newUser.setUsername(user.getUsername());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    return "redirect:/getallposts";
		}
		
		return "registerPage";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String saveRegisterCredentials(Model model, @ModelAttribute("user") Users user) {
		
		usersService.save(user);
		
		return "redirect:/getallposts";
	}
}