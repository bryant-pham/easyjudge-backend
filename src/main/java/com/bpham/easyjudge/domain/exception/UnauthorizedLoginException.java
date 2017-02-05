package com.bpham.easyjudge.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Failed to login with given username and password")
public class UnauthorizedLoginException extends RuntimeException {
    public UnauthorizedLoginException() {
        super("Failed to login with given username and password");
    }
}
