package com.flight.flight_reservation_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.flight_reservation_app.entity.User;
import com.flight.flight_reservation_app.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showReg")
	public String showReq() {
		return "login/showReg";
	}
	@RequestMapping("/showLogin")
	public String showLogin(@ModelAttribute("user") User user,ModelMap modelMap) {
		try {
		String email = user.getEmail();
		User userE = userRepo.findByEmail(email);
		String userEmail = userE.getEmail();
		if(userEmail.equals(email)) {
			modelMap.addAttribute("msg","email already exist");
			return "login/showReg";
		}else{
			userRepo.save(user);
			return "login/login";
		}}catch(Exception e){
			return "login/login";
		}
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		try {
			User user = userRepo.findByEmail(email);
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "login/findFlights";
			} else {
				modelMap.addAttribute("error", "Invalid username/password");
				return "login/login";
			}
		} catch (Exception e) {
			modelMap.addAttribute("error", "Please enter username/password");
			return "login/login";
		}
	}
}
