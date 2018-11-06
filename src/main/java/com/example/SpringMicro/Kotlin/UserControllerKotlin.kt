package com.example.SpringMicro.Kotlin


import com.example.SpringMicro.UserDaoService
import com.example.SpringMicro.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
class UserControllerKotlin @Autowired
constructor(private val service: UserDaoService) {

    @GetMapping("/users")
    fun retrieveAllUsers(): List<User> {
        return service.findAll()
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Int?): User {
        return service.findOne(id!!) ?: throw UserNotFoundException("Cannot find user with id = $id")
    }

    @PostMapping("/users")
    fun addUser(@RequestBody user: User): ResponseEntity<Any> {
        val savedUser = service.save(user)

        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.id!!)
                .toUri()
        return ResponseEntity.created(location).build()
    }
}
