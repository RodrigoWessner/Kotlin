package br.com.KotlinProject.mapper

import br.com.KotlinProject.dto.PessoaDto
import br.com.KotlinProject.model.Pessoa
import org.springframework.stereotype.Component

@Component
class PessoaDtoToPessoa : Mapper<PessoaDto, Pessoa> {
    override fun map(dto: PessoaDto): Pessoa {
        return Pessoa(
            nome = dto.nome,
            cidade = dto.cidade,
            cpf = dto.cpf,
            dataNasc = dto.dataNasc
        )
    }

}