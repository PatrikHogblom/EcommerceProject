package com.ecommerceProject.ecom.dto;

import com.ecommerceProject.ecom.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long Id;
    private String email;
    private String name;
    private UserRole role;

    public void setId(Long id) {
        this.Id = id;
    }
}
