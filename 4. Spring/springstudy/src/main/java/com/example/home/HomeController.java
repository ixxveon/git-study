package com.example.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.dto.ResLoginDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(HttpSession session, Model model) {
		ResLoginDTO loginuser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
		model.addAttribute("LOGIN_USER", loginuser);
		return "home";
	}
}
