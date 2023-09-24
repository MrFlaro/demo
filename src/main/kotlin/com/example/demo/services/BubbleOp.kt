package com.example.demo.services

import org.springframework.stereotype.Service
import org.springframework.stereotype.Component
import com.example.demo.models.SortRequestDTO
import java.util.*
import kotlin.collections.*

@Component
class BubbleOp
{
    fun sort(unsorted :IntArray) : IntArray {
        var values = unsorted.clone()
        val n = values.size

         for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (values[j] > values[j + 1]) {
                    // Swap the elements
                    val temp = values[j]
                    values[j] = values[j + 1]
                    values[j + 1] = temp
                }
            }
         }

         return values
    }


    // This code is the same as previous func, 
    // with only one symbol being different.
    // While its a violation of DRY, trying to abstract this would only hurt.
    fun sortDesc(unsorted :IntArray) : IntArray {
        var values = unsorted.clone()
        val n = values.size

         for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (values[j] < values[j + 1]) {
                    // Swap the elements
                    val temp = values[j]
                    values[j] = values[j + 1]
                    values[j + 1] = temp
                }
            }
         }

         return values
    }


    // this is an option, but why?
    fun sortDescDumb(unsorted :IntArray) : IntArray {
        val sorted = sort(unsorted)
        sorted.reverse()
        return sorted
    }
}