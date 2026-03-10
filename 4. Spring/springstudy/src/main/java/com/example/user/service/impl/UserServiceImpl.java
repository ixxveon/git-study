package com.example.user.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.dto.ReqSignupDTO;
import com.example.user.dto.ReqUserDTO;
import com.example.user.dto.ResLoginDTO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void signup(ReqSignupDTO request) {
		
		// 1. 비밀번호 & 비밀번호 확인 검증
		if(request.getPassword() != null && !request.getPassword().equals(request.getPasswordCheck())) {
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
			
		// 2. 이메일 중복 체크
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
		}
			
		// 3. 닉네임 중복 체크
		// 2. 닉네임 중복 확인
		if (userRepository.existsByNickname(request.getNickname())) {
			throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
		}
		// 4. 비밀번호 암호화 (Spring Security의 BCrypt 사용)
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		
		// 5. Entity로 변경
		User user = User.builder()
				    .name(request.getName())
				    .email(request.getEmail())
				    .nickname(request.getNickname())
				    .password(encodedPassword)
				    .region("미설정")
				    .build();
		
		// 6. DB에 저장
		userRepository.save(user);
	}
	
	public ResLoginDTO login(ReqSignupDTO request) {
		// 1. 해당 이메일을 가진 유저가 있는지
		User user = userRepository.findByEmail(request.getEmail());
		
		// 3. 사용자가 입력한 비밀번호가 암호화된 비밀번호와 일치하는지 검증
		//	- 일치하면 응답 객체 반환
		//	- 일치하지 않으면 null 반환
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			return null;
		}
		
		ResLoginDTO response = ResLoginDTO.builder()
							   .
	}
}
