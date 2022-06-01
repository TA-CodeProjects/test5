package com.jb.test5.exceptions;

public class SchoolSystemException extends Exception{
    public SchoolSystemException(ErrorMessage errorMessage) {
        super(errorMessage.getMsg());
    }
}
