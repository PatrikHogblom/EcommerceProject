package com.ecommerceProject.ecom.controller;


import com.ecommerceProject.ecom.dto.ReqRes;
import com.ecommerceProject.ecom.entity.Users;
import com.ecommerceProject.ecom.services.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserManagementController {
    @Autowired
    private UsersManagementService usersManagementService;

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody ReqRes reg){
        if (usersManagementService.hasUserWithEmail(reg.getEmail())){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "User already exists");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(usersManagementService.register(reg), HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes req){
        return ResponseEntity.ok(usersManagementService.login(req));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes reg){
        return ResponseEntity.ok(usersManagementService.refreshToken(reg));
    }

    @GetMapping("/admin/get-all-users")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());
    }
    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<ReqRes> getUserById(@PathVariable Integer userId){
        return  ResponseEntity.ok(usersManagementService.getUsersById(userId));
    }

    @GetMapping("/adminuser/get-profile")
    public ResponseEntity<ReqRes> getProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        ReqRes response = usersManagementService.getMyInfo(email);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer userId, @RequestBody Users reqres){
        return  ResponseEntity.ok(usersManagementService.updateUser(userId, reqres));
    }

    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<ReqRes> deleteUser(@PathVariable Integer userId){
        return  ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }

}
