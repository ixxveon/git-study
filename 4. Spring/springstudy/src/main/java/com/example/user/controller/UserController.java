package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.dto.ReqLoginDTO;
import com.example.user.dto.ReqSignupDTO;
import com.example.user.dto.ResLoginDTO;
import com.example.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	//정보 줘
	@GetMapping("/signup/form")
	public String signUpForm() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(ReqSignupDTO request) {
		userService.signup(request);
		return "redirect:/user/login/form";
	}
	
	@GetMapping("/login/form")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(ReqLoginDTO request, HttpSession session) {
		ResLoginDTO loginuser = userService.login(request);
		session.setAttribute("LOGIN_USER", loginuser);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
