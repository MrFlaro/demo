package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.example.demo.services.BubbleService
import com.example.demo.models.SortRequestDTO

@Configuration
public class MyConfiguration(val service: BubbleService) {

    @Bean
    fun setupData() {
        val data =  SortRequestDTO(intArrayOf(1, 5, 1, 4, 6, 10, 1543))
        service.sortAndSubmit(data)
    }
	
}