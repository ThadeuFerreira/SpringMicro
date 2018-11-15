package com.example.SpringMicro.Kotlin

import com.example.SpringMicro.HelloWorldBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldKotlinController {

    @GetMapping(path = ["/hello-world-kotlin"])
    fun helloWorld(): String {
        return "Hello World"
    }

    @GetMapping(path = ["/hello-world-kotlin-bean"])
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("Hello World")
    }

}
