package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.dto.ReqSignupDTO;
import com.example.user.dto.ResLoginDTO;
import com.example.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	// 회원가입 화면 보여줘야지
	@GetMapping("/signup/form")
	public String signupForm() {
		return "pages/signup";
	}
	
	// 회원가입 해야지 (요청 dto 필요하겠지?)
	@PostMapping("/signup")
	public String signup(ReqSignupDTO request) {
		userService.signup(request);
		return "redirect:/user/login/form";
	}
	
	// 로그인 화면 보여주자
	@GetMapping("/login/form")
	public String loginForm() {
		return "pages/login";
	}
	
	// 로그인 해야지
	@PostMapping("/login")
	public String login(ResLoginDTO response) {
		userService.login(response);
		return "redirect:/";
	}
}
