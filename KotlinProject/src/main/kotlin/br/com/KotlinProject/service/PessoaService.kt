package br.com.KotlinProject.service

import br.com.KotlinProject.dto.Filter
import br.com.KotlinProject.dto.PessoaDto
import br.com.KotlinProject.mapper.PessoaDtoToPessoa
import br.com.KotlinProject.model.Pessoa
import org.springframework.stereotype.Service

@Service
class PessoaService(
    private val dataBaseService: DataBaseService,
    private val pessoaMapper: PessoaDtoToPessoa
) {

    fun insert(pessoaDto: PessoaDto) {
        val pessoa: Pessoa = pessoaMapper.map(pessoaDto)
        dataBaseService.insert(pessoa)
    }

    fun buscar(): List<Pessoa> {
        return dataBaseService.buscar()
    }

    fun buscarId(id: String): Pessoa? {
        return dataBaseService.buscarId(id)
    }

    fun filtro(filter: Filter): List<Pessoa?>? {
        return dataBaseService.selectFilter(filter)
    }

    fun update(id: String, pessoaDto: PessoaDto) {
        var pessoa = pessoaMapper.map(pessoaDto)
        dataBaseService.update(id, pessoa)
    }

    fun delete(id: String) {
        dataBaseService.delete(id)
    }

}