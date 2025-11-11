package com.ramtinmoradiii.onlineshop.services.products

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.products.Color
import com.ramtinmoradiii.onlineshop.repositories.products.ColorRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ColorService {

    @Autowired
    lateinit var repository: ColorRepository

    fun getAll(): List<Color> {
        return repository.findAll()
    }

    fun getById(id: Long): Color? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getCount(): Long {
        return repository.count()
    }
}