package kr.co.studyProject.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// id, 이름, 이메일, 닉네임, 비밀번호, 전화번호, 수정일, 가입일
@Entity 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User { 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 증가 (=auto_increment)
	private Long id; 
	private String userName;
	private String email;
	private String userNinkname;
	private String password;
	private String phoneNumber;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// INSERT 되기 직전에 자동 실행되는 어노테이션
	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}
}