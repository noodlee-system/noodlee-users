package com.noodleesystem.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super(MessageFormat.format("There is no user with id: {0}", id));
    }
}
