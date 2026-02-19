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
	
	// id를 조회해서 게시물 찾은 다음 수정
//	@GetMapping("/detail")
//	public String detail(@RequestParam(name="id") Long id, Model model) {
//		// 1. 로그인한 유저인지?? (이건 여기서 처리)
		// 2. writer <-> board 매치해서 게시글 조회 
		// ResBoardDTO response = boardService.getDetail(); // detail()에서 repo의 db와 접근해서 게시글 가져와야되지 않을까??
		// 3. return
//	}
	
	// 글쓰기 화면
	@GetMapping("/create/form")
	public String createForm() {
		return "board-write";
	}
	
	// 글쓰기 
	@PostMapping("/create") // 글쓰기dto 요청
	public String create(ReqBoardDTO request, HttpSession session) {
		// 세션이 있는 유저인지 확인
		ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
		
		// 세션이 없으면 로그인 화면으로
		if (loginUser == null) {
			return "redirect:/user/login/form";
		}
		
		// 확인 끝났으면 boardService의 write()실행
		boardService.write(request, loginUser.getId());
		
		return "redirect:/board/notice";
	}
	
	
	
	
	
	
}
