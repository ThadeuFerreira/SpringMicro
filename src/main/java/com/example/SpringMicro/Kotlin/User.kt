package com.example.SpringMicro.Kotlin

import java.util.Date

class User {
    var id: Int? = null
    var name: String? = null
    var birthDay: Date? = null

    constructor() {

    }

    constructor(id: Int, name: String, birthday: Date) {
        this.id = id
        this.birthDay = birthday
        this.name = name
    }
}
