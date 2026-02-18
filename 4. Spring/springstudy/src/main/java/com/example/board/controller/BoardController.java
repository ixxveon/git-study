package com.example.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.dto.ReqBoardDTO;
import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import com.example.user.dto.ResLoginDTO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	// 목록, 검색, 페이징
	@GetMapping
	public String boardList(@RequestParam(name = "page", defaultValue = "0") int page,
	        @RequestParam(name = "size", defaultValue = "5") int size,
	        @RequestParam(name = "keyword", required = false) String keyword,
	        Model model) {
		
		// 게시글 목록 DB에서 가져오기
		Page<Board> boardlist = boardService.list(keyword, page, size);
		
		// 화면에 보여줄 현재 페이지 번호
		int current = boardlist.getNumber() + 1;
		
		// 전체 페이지 수
		int totalPages = boardlist.getTotalPages();
		
		// 페이지 버튼을 묶어서 보여주기 위해 계산
		int blockSize = 3;
		int startPage = ((current - 1) / blockSize) * blockSize + 1;
		int endPage = Math.min(startPage + blockSize - 1, totalPages);
		
		// board.html이 쓸 수 있게 model에 담아서 보내기
		model.addAttribute("page" , boardlist);
		model.addAttribute("currentPage" , current);
		model.addAttribute("startPage" , startPage);
		model.addAttribute("endPage" , endPage);
		model.addAttribute("keyword" , keyword);
		
		
		
		
		return "board";
	}
	
	// board-write ===============================================
	// 글쓰기 화면
	@GetMapping("/write/form")
	public String writeForm() {
		return "board-write";
	}
	
	// 글쓰기
	@PostMapping("/write")
	public String write(ReqBoardDTO request, HttpSession session) {
		ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
		
		if (loginUser == null) {
			return "redirect:/user/login/form";
		}
		
		boardService.write(request, loginUser.getId());
		
		return "redirect:/board";
	}
	
	// board-view =================================================
	// 게시판 상세보기
	@GetMapping("/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		
		// 조회수 증가
		boardService.increaseViewCount(id);
		
		// 글 1개 조회
		Board board = boardService.getDetail(id);
		
		model.addAttribute("b", board);
		
		return "board-view";
	}
	
	// board-edit =================================================
	// 게시글 수정 화면
	@GetMapping("/edit/form")
	public String editForm() {
		return "board-edit";
	}
	
	@PostMapping("/edit")
	public String edit() {
		return "redirect:/board";
	}
	
	
}
