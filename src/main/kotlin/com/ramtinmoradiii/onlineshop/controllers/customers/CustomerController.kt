package com.ramtinmoradiii.onlineshop.controllers.customers

import com.ramtinmoradiii.onlineshop.models.customers.Customer
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.customers.CustomerService
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
@RequestMapping(ApiRoutes.CUSTOMER)
class CustomerController {

    @Autowired
    lateinit var service: CustomerService

    @PostMapping(ApiRoutes.EMPTY)
    fun create(@RequestBody customer: Customer): ServiceResponse<Customer> {
        return ServiceResponse(true, ResponseMessage.OK, service.insert(customer))
    }

    @PutMapping(ApiRoutes.EMPTY)
    fun update(@RequestBody customer: Customer): ServiceResponse<Customer?> {
        return ServiceResponse(false, ResponseMessage.OK, service.update(customer))
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getById(@PathVariable id: Long): ServiceResponse<Customer?> {
        return ServiceResponse(false, ResponseMessage.OK, service.getById(id))
    }
}