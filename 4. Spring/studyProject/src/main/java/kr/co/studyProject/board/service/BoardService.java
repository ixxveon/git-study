package kr.co.studyProject.board.service;

import org.springframework.data.domain.Page;

import kr.co.studyProject.board.dto.ReqBoardDTO;
import kr.co.studyProject.board.dto.ResBoardDTO;

public interface BoardService {
	
	void write(ReqBoardDTO request, Long writerId);
	
	Page<ResBoardDTO> getboardList(int page);
	
	//ResBoardDTO getBoardDetail(Long id);
	
}
