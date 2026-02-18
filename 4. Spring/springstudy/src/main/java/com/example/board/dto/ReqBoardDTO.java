package com.example.board.dto;

import com.example.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReqBoardDTO {
	private String category; 
	private String title;
	private String content;
	private String writer;
	
}
