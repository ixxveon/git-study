package kr.co.serverLsee.controller;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
}
