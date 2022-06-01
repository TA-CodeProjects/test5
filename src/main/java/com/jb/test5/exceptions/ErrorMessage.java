package com.jb.test5.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    ID_NOT_FOUND("Id not found");

    private String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }
}
