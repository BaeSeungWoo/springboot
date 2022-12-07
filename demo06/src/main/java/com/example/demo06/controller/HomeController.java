package com.example.demo06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;
import com.example.demo06.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/board/list";
	}
		
	@GetMapping("/register")
	public String register() {
		return "/user/join";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody User user) {
		// UserName이 있으면 fail 리턴
		if(userRepository.findByUsername(user.getUsername()) != null) {
			return "fail";
		} else {
			userService.save(user);
			return "success";
		}		
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody User user) {
		return "success";
	}

}
