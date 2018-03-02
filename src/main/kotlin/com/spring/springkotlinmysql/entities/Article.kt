package com.spring.springkotlinmysql.entities

import javax.persistence.*

@Entity
@Table
data class Article(
        @Id @GeneratedValue
        val id:Long=-1,
        val title: String="",
        val content: String="",
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        val user: User? = null

){
    override fun toString(): String{
        return "{title: ${title},content: ${content}, user: ${user?.firstname} ${user?.lastname}}"
    }
}