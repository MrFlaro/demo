package com.example.demo.entities

import jakarta.persistence.*
import org.springframework.data.domain.Persistable

@MappedSuperclass
abstract class EntityBase : Persistable<Long> {

    @Id
    @GeneratedValue
    var id : Long = 0

    @Version
    private val version: Long? = null
    
    override fun getId() = id

    override fun isNew() = version == null
}