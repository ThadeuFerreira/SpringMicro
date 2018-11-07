package com.example.SpringMicro.Kotlin


import com.example.SpringMicro.UserController
import com.example.SpringMicro.UserDaoService
import com.example.SpringMicro.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.mvc.ControllerLinkBuilder.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
open class UserControllerKotlin {
    @Autowired
    internal var service: UserDaoKotlinService? = null

    @GetMapping("/users-kotlin")
    fun retrieveAllUsers(): List<User> {
        return service!!.findAll()
    }

    @GetMapping("/users-kotlin/{id}")
    fun getUser(@PathVariable id: Int?): Resource<User> {
        val user = service!!.findOne(id!!) ?: throw UserNotFoundException("Cannot find user with id = $id")
        val resource = Resource(user)
        val linkTo = linkTo(
                methodOn<UserControllerKotlin>(this.javaClass).retrieveAllUsers())
        resource.add(linkTo.withRel("all-users"))

        return resource
    }

    @PostMapping("/users-kotlin")
    fun addUser(@RequestBody user: User): ResponseEntity<Any> {
        val savedUser = service!!.save(user)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.id!!)
                .toUri()
        return ResponseEntity.created(location).build()
    }
}