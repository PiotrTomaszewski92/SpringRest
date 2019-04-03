package com.spring.entity;

public class StudentErrorResponse extends ErrorResponse{

    public StudentErrorResponse(){
        super();
    }

    public StudentErrorResponse(int status, String message, long timeStamp){
        super(status,message,timeStamp);
    }
}

