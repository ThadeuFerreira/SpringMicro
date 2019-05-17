package com.example.SpringMicro.User;


public class Greeting2 {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Greeting2(String message) {
        this.message = message;
    }

    public Greeting2(){}
    private String message;
}