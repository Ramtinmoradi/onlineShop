package com.ramtinmoradiii.onlineshop.controllers.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.Transaction
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.invoices.TransactionService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.TRANSACTION)
class TransactionController {

    @Autowired
    lateinit var service: TransactionService

    @PostMapping(ApiRoutes.EMPTY)
    fun addTransaction(@RequestBody transaction: Transaction): ServiceResponse<Transaction> {
        return ServiceResponse(true, ResponseMessage.OK, service.insert(transaction))
    }

    @PutMapping(ApiRoutes.EMPTY)
    fun updateTransaction(@RequestBody transaction: Transaction): ServiceResponse<Transaction> {
        return ServiceResponse(true, ResponseMessage.OK, service.update(transaction))
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getById(@PathVariable("id") id: Long): ServiceResponse<Transaction?> {
        return ServiceResponse(true, ResponseMessage.OK, service.getById(id))
    }
}