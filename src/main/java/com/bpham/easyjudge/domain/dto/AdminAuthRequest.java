package com.bpham.easyjudge.domain.dto;

import lombok.Data;

@Data
public class AdminAuthRequest {
    private String username;
    private String password;
}
