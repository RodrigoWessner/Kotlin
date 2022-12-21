package br.com.KotlinProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories
@SpringBootApplication
class KotlinProjectApplication

fun main(args: Array<String>) {
	runApplication<KotlinProjectApplication>(*args)
}
