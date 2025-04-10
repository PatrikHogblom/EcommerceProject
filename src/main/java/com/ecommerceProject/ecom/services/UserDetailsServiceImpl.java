package com.ecommerceProject.ecom.services;

import com.ecommerceProject.ecom.entity.Users;
import com.ecommerceProject.ecom.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return usersRepository.findByEmail(username).orElseThrow();
        Optional<Users> optionalUsers = usersRepository.findByEmail(username);
        if (optionalUsers.isEmpty()) throw new UsernameNotFoundException("Username not found", null);

        Users user = optionalUsers.get();

        return new org.springframework.security.core.userdetails.User(
                optionalUsers.get().getEmail(),
                optionalUsers.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );
                //new ArrayList<>()
    }
}
