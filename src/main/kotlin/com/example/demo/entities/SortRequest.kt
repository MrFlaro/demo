package com.example.demo.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class SortRequest(
    
    var addedAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "request")
    var bubbles : MutableList<BubbleValue> 

) : EntityBase()