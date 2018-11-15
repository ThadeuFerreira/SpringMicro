package com.example.SpringMicro.Kotlin


import com.example.SpringMicro.User.User
import org.springframework.stereotype.Component

import java.util.ArrayList
import java.util.Date

@Component
class UserDaoKotlinService {
    private val users: MutableList<User>

    init {
        users = ArrayList()
        users.add(User(1, "Adam", Date()))
        users.add(User(2, "Thadeu", Date()))
        users.add(User(3, "Carlos", Date()))
        users.add(User(4, "Matheus", Date()))
    }

    fun findAll(): List<User> {
        return users
    }

    fun save(user: User): User {
        if (user.id == null) {
            user.id = users.size + 1
        }
        users.add(user)
        return user
    }

    fun findOne(id: Int): User? {
        for (user in users) {
            if (id == user.id)
                return user
        }
        return null
    }

}
