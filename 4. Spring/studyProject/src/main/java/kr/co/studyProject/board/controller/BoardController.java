package kr.co.studyProject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.studyProject.board.dto.ReqBoardDTO;
import kr.co.studyProject.board.service.BoardService;
import kr.co.studyProject.user.dto.ResLoginDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("board/notice")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardSerivce;
	
	@GetMapping
	public String boardList() {
		return "board";
	}
	
	@GetMapping("/create/form")
	public String createForm() {
		return "board-write";
	}
	
	@PostMapping("/create")
	public String create(ReqBoardDTO request, HttpSession session) {
		ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
		
		if (loginUser == null) {
			return "redirect:/user/login/form";
		}
		
		boardSerivce.write(request, loginUser.getId());
		
		return "redirect:/board/notice";
	}
	
	
	
	
}
