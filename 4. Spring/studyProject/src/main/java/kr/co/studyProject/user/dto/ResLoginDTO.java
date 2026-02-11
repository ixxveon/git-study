package kr.co.studyProject.user.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResLoginDTO {
	private Long id;
	private String userName;
	private String email;
	private String userNickname;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
