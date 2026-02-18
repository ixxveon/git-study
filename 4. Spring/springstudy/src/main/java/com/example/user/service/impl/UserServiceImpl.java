package com.example.user.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.dto.ReqLoginDTO;
import com.example.user.dto.ReqSignupDTO;
import com.example.user.dto.ResLoginDTO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public void signup(ReqSignupDTO request) {
		// 1. 이메일 중복 확인
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
		}
		
		// 2. 닉네임 중복 확인
		if (userRepository.existsByNickname(request.getNickname())) {
			throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
		}
		
		// 3. 비밀번호 체크 
		if (request.getPassword() != null &&
			!request.getPassword().equals(request.getPasswordCheck())) {
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
		
		// 4. 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		
		// 5. DTO -> Entity 변환
		User user = User.builder()
					.userName(request.getUserName())
				    .email(request.getEmail())
				    .nickname(request.getNickname())
				    .password(encodedPassword)
				    .phoneNumber(request.getPhoneNumber())
				    .build();
		// 6. 저장
		userRepository.save(user);
	}
	
	@Override
	public ResLoginDTO login(ReqLoginDTO request) {
		// 1. 존재하는 이메일인지 없으면 로그인 실패
		User user = userRepository.findByEmail(request.getEmail()) 
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));
		
		
		// 2. 존재하는 비번인지(암호화됨)
		if(!passwordEncoder.matches(request.getPassword(),user.getPassword())) {
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
		
		// 3. 성공시 dto
		ResLoginDTO response = ResLoginDTO.builder()
							   .id(user.getId())
							   .userName(user.getUserName())
							   .email(user.getEmail())
							   .nickname(user.getNickname())
							   .phoneNumber(user.getPhoneNumber())
							   .createdAt(user.getCreatedAt())
							   .build();
		
		return response;
				
	}
}
