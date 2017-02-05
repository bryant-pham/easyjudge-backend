package com.bpham.easyjudge.service;

import com.bpham.easyjudge.domain.Admin;
import com.bpham.easyjudge.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private AdminRepository adminRepo;

    @Autowired
    public AdminService(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin findBy(String username, String password) {
        return adminRepo.findByUsernameAndPassword(username, password);
    }

    public Admin create(Admin admin) {
        return adminRepo.save(admin);
    }
}
