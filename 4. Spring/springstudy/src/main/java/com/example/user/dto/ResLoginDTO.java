package com.example.user.dto;

import java.time.LocalDateTime;

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
public class ResLoginDTO {
	private Long id;
	private String userName;
	private String nickname;
	private String email;
	private String phoneNumber;
	private LocalDateTime createdAt;
}
