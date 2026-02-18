package kr.co.studyProject.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kr.co.studyProject.board.dto.ReqBoardDTO;
import kr.co.studyProject.board.dto.ResBoardDTO;
import kr.co.studyProject.board.service.BoardService;
import kr.co.studyProject.user.dto.ResLoginDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("board/notice")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	
	@GetMapping
	public String boardList(@RequestParam(name="page", defaultValue = "1") int page, Model model) {
		Page<ResBoardDTO> list = boardService.getboardList(page - 1);
		int currentPage = list.getNumber() + 1; // 현재 페이지 (JPA는 0부터 시작하므로 +1)
		int totalPages = list.getTotalPages(); // 전체 페이지
		
		int blockSize = 5; // 5개의 버튼씩 보이게
		
		int startPage = ((currentPage-1) / blockSize) * blockSize + 1;
		
		int endPage = startPage + blockSize - 1;
		
		if(endPage > totalPages) {
			endPage = totalPages; 
		}
		
		// 2. 모델에 담아 타임리프에 전달
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board";
	}
//	@GetMapping("/detail")
//	public String detatil(@RequestParam(name="id") Long id, Model model) {
//		ResBoardDTO response = boardService.getBoardDetail(id);
//		model.addAttribute("board", response);
//		return "board-view";
//	}
	
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
		
		boardService.write(request, loginUser.getId());
		
		return "redirect:/board/notice";
	}
	
	
	
	
	
	
}
