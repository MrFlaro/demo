package com.example.demo.repositories

import org.springframework.data.repository.CrudRepository
import com.example.demo.entities.*

interface BubbleRequestRepository : CrudRepository<SortRequest, Long>