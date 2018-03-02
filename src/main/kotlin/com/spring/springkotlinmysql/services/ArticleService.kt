package com.spring.springkotlinmysql.services

import com.spring.springkotlinmysql.entities.Article
import com.spring.springkotlinmysql.entities.User


interface ArticleService{


    fun getArticles(): String
    fun getArticleByTitle(title: String): MutableList<Article>
    fun getArticleById(id: Long): Article?
   // fun addArticle(article: Article): Article
    fun deleteArticle(id: Long)
    fun deleteAllArticless()
    fun updateArticle(id: Long, article: Article): Article
    fun addArticle(article: Article, user: User): Article
}