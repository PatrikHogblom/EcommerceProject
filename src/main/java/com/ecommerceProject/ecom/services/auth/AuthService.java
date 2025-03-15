package com.ecommerceProject.ecom.services.auth;

import com.ecommerceProject.ecom.dto.SignupRequest;
import com.ecommerceProject.ecom.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
    boolean hasUserWithEmail(String email);
}
