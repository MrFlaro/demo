package com.example.demo.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.*
import com.example.demo.models.*
import com.example.demo.repositories.*
import com.example.demo.models.*

@Service
class BubbleService(
    private val bubble: BubbleOp,
    private val repository: BubbleRequestRepository
) {
    fun sortAndSubmit(data: SortRequestDTO) : SortRequestDTO {
        val initial = data.bubbles
        val sorted = bubble.sort(initial)
        val newEntity = SortRequestDTO(sorted).toEntity()
        repository.save(newEntity)

        return newEntity.toDTO()
    }

    fun findBubble(id: Long) : SortRequestDTO?{
        var dto : SortRequestDTO? = null
        repository.findById(id).ifPresent({value -> dto = value.toDTO()})
        return dto
    }

    fun countTotal() = repository.count()  
}