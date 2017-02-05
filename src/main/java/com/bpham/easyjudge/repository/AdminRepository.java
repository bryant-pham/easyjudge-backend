package com.bpham.easyjudge.repository;

import com.bpham.easyjudge.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {
    Admin findByUsernameAndPassword(String username, String password);
}
