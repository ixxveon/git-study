package com.example.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.entity.Board;
import com.example.user.entity.User;


public interface BoardRepository extends JpaRepository<Board, Long>{
	Page<Board> findAll(Pageable pageable);
	
	Page<Board> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
	
	
}
