package com.ecommerceProject.ecom.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public Object getPassword() {
        return password;
    }
}
