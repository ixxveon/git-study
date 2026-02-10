package kr.co.studyProject.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 이름 이메일 닉네임 비밀번호 비밀번호 확인 전화번호

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@ToString 
@Data
public class ReqSignupDTO {
	private String userName;
	private String email;
	private String userNickname;
	private String password;
	private String passwordCheck;
	private String phoneNumber;
}
