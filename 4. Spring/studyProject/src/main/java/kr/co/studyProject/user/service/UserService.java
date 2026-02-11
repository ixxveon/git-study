package kr.co.studyProject.user.service;

import kr.co.studyProject.user.dto.ReqLoginDTO;
import kr.co.studyProject.user.dto.ReqSignupDTO;
import kr.co.studyProject.user.dto.ResLoginDTO;

public interface UserService {

	void signup(ReqSignupDTO request);
	
	ResLoginDTO login(ReqLoginDTO request);
}
