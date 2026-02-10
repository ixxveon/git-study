package kr.co.studyProject.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("singup")
	public String signupForm() {
		return "home";
	}
}
