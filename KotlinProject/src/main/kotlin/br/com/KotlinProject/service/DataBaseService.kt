package br.com.KotlinProject.service

import br.com.KotlinProject.Exception.DataBaseException
import br.com.KotlinProject.dto.Filter
import br.com.KotlinProject.model.Pessoa
import br.com.KotlinProject.repository.PessoaRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import java.util.*

@Service
class DataBaseService(private val pessoaRepository: PessoaRepository, private val mongoTemplate: MongoTemplate) {

    fun insert(pessoa: Pessoa) {
        try {
            pessoaRepository.save(pessoa)
        } catch (e: RuntimeException) {
            throw DataBaseException("Erro ao salvar Pessoa")
        }
    }

    fun buscar(): List<Pessoa> {
        var pessoas = pessoaRepository.findAll()
        return pessoas
    }

    fun buscarId(id: String): Pessoa? {
        val pessoa = pessoaRepository.findById(id)
        if (pessoa.isPresent){
            return pessoa.get()
        }
        return null
    }

    fun delete(id: String) {
        try {
            pessoaRepository.deleteById(id)
        } catch (e: RuntimeException) {
            throw DataBaseException("Erro ao deletar")
        }
    }

    fun update(id: String, pessoa: Pessoa) {
        try {
            var entity = pessoaRepository.findById(id)
            if (Objects.nonNull(entity)) {
                pessoa.id = entity.get().id
                pessoaRepository.save(pessoa)
            }
        } catch (e: RuntimeException) {
            throw DataBaseException("Erro ao fazer update com id: " + id)
        }
    }


    fun selectFilter(filter: Filter): List<Pessoa?>? {
        return try {
            val query = Query()
            setExemple(query, filter)
            mongoTemplate.find(query, Pessoa::class.java)
        } catch (e: RuntimeException) {
            throw DataBaseException("Erro ao filtrar componentes")
        }
    }

    private fun setExemple(query: Query, filter: Filter) {
        if (validElement(filter.nome)) {
            query.addCriteria(Criteria.where("nome").`is`(filter.nome))
        }
        if (validElement(filter.cidade)) {
            query.addCriteria(Criteria.where("cidade").`is`(filter.cidade))
        }
        if (validElement(filter.cpf)) {
            query.addCriteria(Criteria.where("cpf").`is`(filter.cpf))
        }
        if (validElement(filter.dataNasc)) {
            query.addCriteria(Criteria.where("dataNasc").`is`(filter.dataNasc))
        }
    }

    private fun validElement(element: String?): Boolean {
        return if (element == null || element.isBlank()) {
            java.lang.Boolean.FALSE
        } else {
            java.lang.Boolean.TRUE
        }
    }
}