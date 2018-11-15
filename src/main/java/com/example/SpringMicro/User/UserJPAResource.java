package com.example.SpringMicro.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Resource<User> retrieveUser(@PathVariable Integer id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            throw  new UserNotFoundException("id - " + id);

        Resource<User> resource = new Resource<>(user.get());
        return resource;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id){
            userRepository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
