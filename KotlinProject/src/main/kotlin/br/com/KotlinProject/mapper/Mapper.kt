package br.com.KotlinProject.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
