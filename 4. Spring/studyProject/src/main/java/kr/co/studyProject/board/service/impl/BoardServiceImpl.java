package kr.co.studyProject.board.service.impl;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.co.studyProject.board.dto.ReqBoardDTO;
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
}
