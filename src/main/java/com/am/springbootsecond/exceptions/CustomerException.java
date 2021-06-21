package com.am.springbootsecond.exceptions;

public class CustomerException extends Exception{
    public CustomerException(Throwable cause) {
        super(cause);
        cause.printStackTrace();
    }
}
