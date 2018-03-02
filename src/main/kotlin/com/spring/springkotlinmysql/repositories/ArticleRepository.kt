package com.spring.springkotlinmysql.repositories

import com.spring.springkotlinmysql.entities.Article
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface ArticleRepository: CrudRepository<Article, Long> {
    fun findByTitle(title: String): MutableList<Article>
}