package com.spring.springkotlinmysql.services
import com.spring.springkotlinmysql.entities.Article
import com.spring.springkotlinmysql.entities.User
import com.spring.springkotlinmysql.repositories.ArticleRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleServiceImpl:ArticleService{



    private val log = KotlinLogging.logger {}
    @Autowired
    lateinit var repository: ArticleRepository

    override fun getArticles():String {
        val articles = repository.findAll()

        var info : String = ""

        articles.forEach{
            info += it.toString()
        }

        return info
    }

    override fun getArticleById(id: Long) =
            repository.findOne(id)


    override fun getArticleByTitle(title: String) =
            repository.findByTitle(title)


    override fun addArticle(article: Article,user:User): Article {

        repository.save(Article(article.id,article.title,article.content,user))
        log.info("${article.title},added!!!")
        return article


    }

    override fun deleteArticle(id: Long) {
        repository.delete(id)
        log.info("article deleted!!")
    }

    override fun deleteAllArticless() {
        repository.deleteAll()
        log.info("All articles deleted!!")
    }



    override fun updateArticle(id: Long, article: Article):Article {
        val currentArticle = repository.findOne(id)
        if (currentArticle  != null) repository.save(currentArticle .copy(id,article.title,article.content,currentArticle.user))
        log.info("${article.title},updated!!!")
        return currentArticle

    }



}


