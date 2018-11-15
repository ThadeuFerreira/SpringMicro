package com.example.SpringMicro.Kotlin

import com.example.SpringMicro.User.User
import com.example.SpringMicro.User.UserDaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.concurrent.atomic.AtomicLong



@RestController
class GreetingController{
    val counter = AtomicLong()
    var service = UserDaoService()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name : String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @PostMapping("/usersKotlin")
    fun addUser(@RequestBody user: User): ResponseEntity<Any> {
        val savedUser = service.save(user)

        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.id!!)
                .toUri()
        return ResponseEntity.created(location).build()
    }
}