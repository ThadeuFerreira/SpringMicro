package com.example.SpringMicro;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String _message){
        message = _message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
