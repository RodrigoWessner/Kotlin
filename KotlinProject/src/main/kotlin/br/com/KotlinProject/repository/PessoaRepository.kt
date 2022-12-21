package br.com.KotlinProject.repository

import br.com.KotlinProject.model.Pessoa
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : MongoRepository<Pessoa, String>{

}