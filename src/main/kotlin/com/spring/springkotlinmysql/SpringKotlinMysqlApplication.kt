package com.spring.springkotlinmysql

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class SpringKotlinMysqlApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringKotlinMysqlApplication::class.java, *args)




    }


