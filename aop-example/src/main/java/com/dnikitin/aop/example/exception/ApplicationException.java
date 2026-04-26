package com.dnikitin.aop.example.exception;

import com.dnikitin.aop.example.annotation.Throw;

@Throw
public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }
}
