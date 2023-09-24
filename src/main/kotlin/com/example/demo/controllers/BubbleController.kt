package com.example.demo.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import com.example.demo.services.*
import com.example.demo.models.*

@RestController
@RequestMapping("/api/bubble")
class BubbleController(
    private val service: BubbleService,
) {
    
    @GetMapping("/")
    @ResponseBody
    fun getFoam(@RequestParam id : Long) =
        //gotta remember to keep 80 column width for code
        service.findBubble(id)?: 
        throw ResponseStatusException(HttpStatus.NOT_FOUND, 
        "requested bubbles dont exist")
        


    @PostMapping("/")
    @ResponseBody
    fun postNumbers(@RequestBody request: SortRequestDTO) =
        service.sortAndSubmit(request)
    
}


