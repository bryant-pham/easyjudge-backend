package com.bpham.easyjudge.controller;

import com.bpham.easyjudge.domain.Admin;
import com.bpham.easyjudge.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @CrossOrigin
    @RequestMapping(value = "/api/admin", method = RequestMethod.POST)
    public Admin create(@RequestBody Admin admin) {
        return this.adminService.create(admin);
    }
}
