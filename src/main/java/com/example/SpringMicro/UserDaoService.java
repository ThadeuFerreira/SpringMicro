package com.example.SpringMicro;

import com.example.SpringMicro.Kotlin.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Thadeu", new Date()));
        users.add(new User(3, "Carlos", new Date()));
        users.add(new User(4, "Matheus", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(users.size() +1);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user:users){
            if(id == user.getId())
                return user;
        }
        return null;
    }

}
