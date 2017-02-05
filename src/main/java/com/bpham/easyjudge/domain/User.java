package com.bpham.easyjudge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String id;
    private String username;

    public User(String username) {
        this.username = username;
    }
}
