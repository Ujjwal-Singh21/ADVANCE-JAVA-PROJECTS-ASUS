package com.springsecurity.signupdao;

import com.springsecurity.dto.SignupDTO;

public interface ISignUpDAO {
	public abstract void saveUser(SignupDTO signupDTO);
}
