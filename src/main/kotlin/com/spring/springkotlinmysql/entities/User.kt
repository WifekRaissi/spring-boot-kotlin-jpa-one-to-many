package com.spring.springkotlinmysql.entities

import javax.persistence.*

@Entity
@Table
data class User(
    @Id @GeneratedValue
    val id:Long=-1,
    val firstname: String="",
    val lastname:String="",
    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    val articles: List<Article> = emptyList()
    ){
    override fun toString(): String{
        return "{firstname: ${this.firstname},lastname: ${this.lastname}," +
                " Articles: ${articles.map { it->it.title }}}";
    }
}