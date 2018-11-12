package com.example.SpringMicro.Kotlin

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@ApiModel(description="All detaisl about the user.")
@Entity
open class User {
    @Id
    @GeneratedValue
    var id: Int? = null
    @Size(min=2, message="Name should have at least 2 cahracters")
    var name: String? = null
    @Past
    @ApiModelProperty(notes="Birht date should be in the past")
    var birthDay: Date? = null

    constructor() {

    }

    constructor(id: Int, name: String, birthday: Date) {
        this.id = id
        this.birthDay = birthday
        this.name = name
    }
}
