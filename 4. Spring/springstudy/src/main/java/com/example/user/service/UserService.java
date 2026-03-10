package com.example.user.service;

import com.example.user.dto.ReqSignupDTO;
import com.example.user.dto.ResLoginDTO;

public interface UserService {
	void signup(ReqSignupDTO request);
	void login(ResLoginDTO response);
}
