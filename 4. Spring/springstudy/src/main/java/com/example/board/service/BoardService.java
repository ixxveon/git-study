package com.example.board.service;

import org.springframework.data.domain.Page;

import com.example.board.dto.ReqBoardDTO;
import com.example.board.entity.Board;

public interface BoardService {

	Page<Board> list(String keyword, int page, int size);
	
	void write(ReqBoardDTO request, Long writer);

	void increaseViewCount(Long id);

	Board getDetail(Long id);
}
