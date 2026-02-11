package kr.co.studyProject.user.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.studyProject.user.dto.ReqLoginDTO;
import kr.co.studyProject.user.dto.ReqSignupDTO;
import kr.co.studyProject.user.dto.ResLoginDTO;
import kr.co.studyProject.user.entity.User;
import kr.co.studyProject.user.repository.UserRepository;
import kr.co.studyProject.user.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void signup(ReqSignupDTO request) {
		
		// 1. 비밀번호 검증
		if(!request.getPassword().equals(request.getPasswordCheck())) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		// 2. 닉네임 중복 체크
		if(userRepository.existsByUserNickname(request.getUserNickname())) {
			System.out.println("이미 사용중인 닉네임입니다.");
		}
			
		// 3. 이메일 중복 체크
		if(userRepository.existsByEmail(request.getEmail())) {
			System.out.println("이미 사용중인 이메일 입니다.");
		}
		
		// 4. 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		
		// 5. 엔티티로 변환
		User user = new User();
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setUserNickname(request.getUserNickname());
		user.setPassword(encodedPassword);
		
		userRepository.save(user);
	}
	
	@Override
	public ResLoginDTO login(ReqLoginDTO request) {
		// 1. 해당 이메일을 가진 유저가 있는지 조회
		User user = userRepository.findByEmail(request.getEmail());
		
		if(user == null) {
			System.out.println("aaa");
			return null;
		}
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			return null;
		}
		
//		ResLoginDTO response = new ResLoginDTO();
//		response.setId(user.getId());
//		response.setUserName(user.getUserName());
//		response.setEmail(user.getEmail());
//		response.setUserNickname(user.getUserNickname());
//		response.setCreatedAt(user.getCreatedAt());
//		response.setUpdatedAt(user.getUpdatedAt());
//		return response;
		
		return ResLoginDTO.builder()
				.id(user.getId())
				.userName(user.getUserName())
				.email(user.getEmail())
				.userNickname(user.getUserNickname())
				.createdAt(user.getCreatedAt())
				.updatedAt(user.getUpdatedAt())
				.build();
	}
}
