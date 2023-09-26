package com.example.demo.models

import com.example.demo.entities.*


fun SortRequestDTO.toEntity() = SortRequest(    
    bubbles = MutableList(bubbles.size, { i -> BubbleValue(bubbles[i])})
)

fun SortRequest.toDTO() = SortRequestDTO(
    requestID = id,
    bubbles = IntArray(bubbles.size, {i -> bubbles[i].weight})
)