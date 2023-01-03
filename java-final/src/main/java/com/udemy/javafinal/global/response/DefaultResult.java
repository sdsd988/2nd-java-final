package com.udemy.javafinal.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DefaultResult<T> {
    private int code;
    private String message;
    private T data;

    public DefaultResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
