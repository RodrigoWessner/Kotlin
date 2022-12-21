package br.com.KotlinProject.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("Pessoa")
data class Pessoa(
    @JsonIgnore
    @MongoId
    var id: ObjectId = ObjectId.get(),
    var nome: String,
    var cpf: String,
    var cidade: String,
    var dataNasc: String
)
