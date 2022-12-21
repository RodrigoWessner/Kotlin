package br.com.KotlinProject.controller

import br.com.KotlinProject.dto.Filter
import br.com.KotlinProject.dto.PessoaDto
import br.com.KotlinProject.model.Pessoa
import br.com.KotlinProject.service.PessoaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoas")
class PessoaController(private val pessoaService: PessoaService) {

    @GetMapping("/")
    fun buscar(): ResponseEntity<List<Pessoa>> {
        return ResponseEntity(pessoaService.buscar(), HttpStatus.ACCEPTED)
    }

    @GetMapping("/{id}")
    fun buscarId(@PathVariable id: String): ResponseEntity<Pessoa> {
        return ResponseEntity(pessoaService.buscarId(id), HttpStatus.ACCEPTED)
    }

    @GetMapping("/filtro/")
    fun filtro(@RequestParam filter: Filter): ResponseEntity<List<Pessoa?>> {
        return ResponseEntity(pessoaService.filtro(filter), HttpStatus.ACCEPTED)
    }

    @PostMapping
    fun inserir(@RequestBody pessoaDto: PessoaDto): ResponseEntity<HttpStatus> {
        pessoaService.insert(pessoaDto)
        return ResponseEntity.ok().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody pessoaDto: PessoaDto): ResponseEntity<HttpStatus> {
        pessoaService.update(id, pessoaDto)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
       pessoaService.delete(id)
    }
}