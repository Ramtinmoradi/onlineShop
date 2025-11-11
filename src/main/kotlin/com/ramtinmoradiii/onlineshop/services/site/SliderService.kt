package com.ramtinmoradiii.onlineshop.services.site

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.site.Slider
import com.ramtinmoradiii.onlineshop.repositories.site.SliderRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class SliderService {

    @Autowired
    lateinit var repository: SliderRepository

    fun getAll(): List<Slider> {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id")).toList()
    }

    fun getById(id: Long): Slider {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getCount(): Long {
        return repository.count()
    }
}