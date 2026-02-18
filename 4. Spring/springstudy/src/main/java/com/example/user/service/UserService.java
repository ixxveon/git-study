package com.example.user.service;

import com.example.user.dto.ReqLoginDTO;
import com.example.user.dto.ReqSignupDTO;
import com.example.user.dto.ResLoginDTO;

public interface UserService {
	
	void signup(ReqSignupDTO request);
	
	ResLoginDTO login(ReqLoginDTO request);
}
