package com.bpham.easyjudge.service;

import com.bpham.easyjudge.domain.Admin;
import com.bpham.easyjudge.domain.User;
import com.bpham.easyjudge.domain.dto.AdminAuthRequest;
import com.bpham.easyjudge.domain.dto.UserAuthRequest;
import com.bpham.easyjudge.domain.exception.UnauthorizedLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private UserService userService;
    private AdminService adminService;

    @Autowired
    public AuthenticationService(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    public User loginUser(UserAuthRequest authRequest) {
        User user = userService.findBy(authRequest.getUsername());
        if (user == null) {
            return userService.create(authRequest.getUsername());
        }
        return user;
    }

    public Admin loginAdmin(AdminAuthRequest authRequest) {
        Admin admin = adminService.findBy(authRequest.getUsername(), authRequest.getPassword());
        if (admin == null) {
            throw new UnauthorizedLoginException();
        }
        return admin;
    }
}
