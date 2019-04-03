package com.spring.entity;

public class CustomerErrorResponse extends ErrorResponse {
    public CustomerErrorResponse(){
        super();
    }

    public CustomerErrorResponse(int status, String message, long timeStamp){
        super(status,message,timeStamp);
    }
}

