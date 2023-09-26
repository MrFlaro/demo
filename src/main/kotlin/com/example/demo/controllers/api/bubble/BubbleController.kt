package com.example.demo.controllers.api.bubble

import com.example.demo.models.*
import com.example.demo.services.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/bubbles")
class BubbleController(
        private val service: BubbleService,
) {

    @GetMapping() @ResponseBody fun getNumberOfRequests() = 
        service.countTotal()

    @GetMapping("{id}")
    @ResponseBody
    fun getFoam(@RequestParam id: Long) =
        // gotta remember to keep 80 column width for code
        service.findBubble(id)
        ?: throw ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "requested bubbles dont exist")

    @PostMapping()
    @ResponseBody
    fun postNumbers(@RequestBody request: SortRequestDTO) = 
        service.sortAndSubmit(request)
}
