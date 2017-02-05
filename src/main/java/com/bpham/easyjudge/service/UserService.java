package com.bpham.easyjudge.service;

import com.bpham.easyjudge.domain.User;
import com.bpham.easyjudge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User findBy(String username) {
        return userRepo.findByUsername(username);
    }

    public User create(String username) {
        return userRepo.save(new User(username));
    }
}
