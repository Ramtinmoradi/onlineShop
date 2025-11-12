package com.ramtinmoradiii.onlineshop.services.customers

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.customers.Customer
import com.ramtinmoradiii.onlineshop.repositories.customers.CustomerRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    lateinit var repository: CustomerRepository

    fun insert(customer: Customer): Customer {
        customer.id = null
        return repository.save(customer)
    }

    fun update(customer: Customer): Customer? {
        val id = customer.id ?: return null

        if (!repository.existsById(id)) return null

        return repository.save(customer)
    }

    fun getById(id: Long): Customer? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }
}