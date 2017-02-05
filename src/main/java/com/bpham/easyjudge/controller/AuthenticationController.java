package com.bpham.easyjudge.controller;

import com.bpham.easyjudge.domain.Admin;
import com.bpham.easyjudge.domain.User;
import com.bpham.easyjudge.domain.dto.AdminAuthRequest;
import com.bpham.easyjudge.domain.dto.UserAuthRequest;
import com.bpham.easyjudge.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public User login(@RequestBody UserAuthRequest authRequest) {
        return authService.loginUser(authRequest);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/login/admin", method = RequestMethod.POST)
    public Admin adminLogin(@RequestBody AdminAuthRequest authRequest) {
        return authService.loginAdmin(authRequest);
    }
}
