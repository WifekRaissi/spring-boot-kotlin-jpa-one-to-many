package com.spring.springkotlinmysql.repositories

import com.spring.springkotlinmysql.entities.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun findByfirstname(firstame: String): MutableList<User>
}

