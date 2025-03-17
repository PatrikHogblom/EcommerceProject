package com.ecommerceProject.ecom.services;

import com.ecommerceProject.ecom.entity.User;
import com.ecommerceProject.ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
