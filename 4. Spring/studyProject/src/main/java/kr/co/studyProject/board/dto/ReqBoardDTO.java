package kr.co.studyProject.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
// 카테고리, 제목, 내용, 파일 첨부 
public class ReqBoardDTO {
	private String category;
	private String title;
	private String content;
}
