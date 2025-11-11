package com.ramtinmoradiii.onlineshop.services.products

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.products.Category
import com.ramtinmoradiii.onlineshop.repositories.products.CategoryRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService {

    @Autowired
    lateinit var repository: CategoryRepository

    fun getAll(): List<Category> {
        return repository.findAll()
    }

    fun getById(id: Long): Category? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getCount(): Long {
        return repository.count()
    }
}