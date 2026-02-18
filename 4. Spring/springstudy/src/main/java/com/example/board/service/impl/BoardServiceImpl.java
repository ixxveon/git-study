package com.example.board.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.board.dto.ReqBoardDTO;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.service.BoardService;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	
	@Override
	public Page<Board> list(String keyword, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
		
		if (keyword == null || keyword.isBlank()) {
			return boardRepository.findAll(pageable);
		}
		
		// 검색어 있으면 제목에 keyword 포함된 게시글만 가져옴
		return boardRepository.findByTitleContainingIgnoreCase(keyword, pageable);

	}
	
	@Override
	public void write(ReqBoardDTO request, Long writerId) {
		// 1. 작성자 조회
		User writer = userRepository.findById(writerId).orElse(null);
				
		if (writer == null) {
			System.out.println("유효하지 않은 사용자입니다.");  
		}
		
		// 1. entity 변환
		Board board = Board.builder()
					  .boardType("STUDY")
					  .category(request.getCategory())
					  .title(request.getTitle())
					  .content(request.getContent())
					  .writer(writer)
					  .viewCount(0)
					  .build();
		
		// 2. 저장
		boardRepository.save(board);
	}
	
	// 게시물 상세보기 시, 조회수 증가
	@Override
	public void increaseViewCount(Long id) {
		Board board = boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. id=" + id));
		board.setViewCount(board.getViewCount() + 1); // 더티 체킹
	}
	
	// 조회
	@Override
	public Board getDetail(Long id) {
		return boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. id=" + id));
	}
}
