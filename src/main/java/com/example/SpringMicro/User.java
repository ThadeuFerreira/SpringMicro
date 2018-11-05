package com.example.SpringMicro;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Date birthDay;

    public User(){

    }

    public User(int id, String name, Date birthday) {
        this.id = id;
        this.birthDay = birthday;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
