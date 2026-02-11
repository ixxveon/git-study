package kr.co.studyProject.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.studyProject.user.dto.ReqLoginDTO;
import kr.co.studyProject.user.dto.ReqSignupDTO;
import kr.co.studyProject.user.dto.ResLoginDTO;
import kr.co.studyProject.user.service.UserService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/signup/form")
	public String signupForm() {
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
		ResLoginDTO response = userService.login(request);
		
		if(response == null) {
			return "redirect:/user/signup/form";
		}
		
		session.setAttribute("LOGIN_USER", response);
		return "redirect:/";
		
		
	}
}
