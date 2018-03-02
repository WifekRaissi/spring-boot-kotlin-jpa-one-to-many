package com.spring.springkotlinmysql.controllers

import com.spring.springkotlinmysql.entities.Article
import com.spring.springkotlinmysql.entities.User

import com.spring.springkotlinmysql.services.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/article")
class ArticleController {

    @Autowired
    lateinit var articleService:ArticleService

    @GetMapping("/articles")
    fun getAllArticles() =
            articleService.getArticles()

    @GetMapping(value = "/{id}")
    fun getArticleById(@PathVariable("id") id: Long) = articleService.getArticleById(id)

    @GetMapping(value = "/articles/{title}")
    fun getArticleByTitle(@PathVariable("title") title: String) =
            articleService.getArticleByTitle(title)

    @PostMapping("/articles")
    fun createArticle(@Valid @RequestBody article: Article) {
       val user=User(3,"wifek")
        articleService.addArticle(article, user)
    }
    @DeleteMapping("/articles/{id}")
    fun deleteArticleById(@PathVariable id: Long) =
            articleService.deleteArticle(id)

    @DeleteMapping("/articles")
    fun deleteUsers() =
            articleService.deleteAllArticless()

    @PutMapping("/articles/{id}")
    fun updateArticle(@PathVariable ("id")id:Long, @RequestBody article: Article)=
            articleService.updateArticle(id,article)



}



