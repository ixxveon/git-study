package kr.co.studyProject.board.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.co.studyProject.board.dto.ReqBoardDTO;
import kr.co.studyProject.board.dto.ResBoardDTO;
import kr.co.studyProject.board.entity.Board;
import kr.co.studyProject.board.repository.BoardRepository;
import kr.co.studyProject.board.service.BoardService;
import kr.co.studyProject.user.entity.User;
import kr.co.studyProject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	@Override
	@Transactional
	public void write(ReqBoardDTO request, Long writerId) {
		User writer = userRepository.findById(writerId).orElse(null);
		
	    if (writer == null) {
	    	System.out.println("로그인하세요.");
	    }

	    Board board = Board.builder()
	            .boardType("NOTICE")
	            .category(request.getCategory())
	            .title(request.getTitle())
	            .content(request.getContent())
	            .writer(writer)
	            .viewCount(0)
	            .build();

	    boardRepository.save(board);
	}
	
	@Override
	public Page<ResBoardDTO> getboardList(int page) {
		
		Pageable pageable = PageRequest.of(page, 8, Sort.by("id").descending());
		
		// 1. 공지사항 게시글 전체 조회
		Page<Board> boardList = boardRepository.findAllByOrderByIdDesc(pageable);
		
	    List<ResBoardDTO> list = new ArrayList<>();

		for(Board b : boardList) {
			ResBoardDTO response = ResBoardDTO.builder()
								   .id(b.getId())
								   .category(b.getCategory())
								   .title(b.getTitle())
								   .content(b.getContent())
								   .writerName(b.getWriter() != null ? b.getWriter().getUserName() : null)
								   .createdAt(b.getCreatedAt())
								   .viewCount(b.getViewCount())
								   .build();
		
		list.add(response);
						
		
		}
		
		
		
		return new PageImpl<>(list, pageable, boardList.getTotalElements());
	
	}
	
	//@Override
	//public ResBoardDTO getBoardDetail(Long id) {
		 
		// 1. 게시글 조회
		//Board board = boardRepository.getById(id).orElse(null);
		
		// 2. 조회수 증가
		//board.setViewCount(board.getViewCount() + 1);
		
		// 3. 응답 DTO 변환
		
	//}
}
