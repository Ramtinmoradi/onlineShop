package com.ramtinmoradiii.onlineshop.services.invoices

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.invoices.Transaction
import com.ramtinmoradiii.onlineshop.repositories.invoices.TransactionRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService {

    @Autowired
    lateinit var repository: TransactionRepository

    fun insert(transaction: Transaction): Transaction? {
        transaction.id = null
        return repository.save(transaction)
    }

    fun update(transaction: Transaction): Transaction? {
        val id = transaction.id ?: return null

        if (!repository.existsById(id)) return null

        return repository.save(transaction)
    }

    fun getById(id: Long): Transaction? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }
}