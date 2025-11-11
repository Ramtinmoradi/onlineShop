package com.ramtinmoradiii.onlineshop.services.products

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.products.Size
import com.ramtinmoradiii.onlineshop.repositories.products.SizeRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SizeService {

    @Autowired
    lateinit var repository: SizeRepository

    fun getAll(): List<Size> {
        return repository.findAll()
    }

    fun getById(id: Long): Size? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getCount(): Long {
        return repository.count()
    }
}