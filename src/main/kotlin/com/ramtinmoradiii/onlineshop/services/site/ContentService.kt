package com.ramtinmoradiii.onlineshop.services.site

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.site.Content
import com.ramtinmoradiii.onlineshop.repositories.site.ContentRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContentService {

    @Autowired
    lateinit var repository: ContentRepository

    fun getAll(): List<Content> {
        return repository.findAll()
    }

    fun getById(id: Long): Content? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getByTitle(title: String): List<Content> {
        return repository.findByTitle(title)
    }

    fun getCount(): Long {
        return repository.count()
    }
}