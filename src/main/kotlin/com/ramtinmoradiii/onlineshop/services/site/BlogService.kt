package com.ramtinmoradiii.onlineshop.services.site

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.site.Blog
import com.ramtinmoradiii.onlineshop.repositories.site.BlogRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BlogService {

    @Autowired
    lateinit var repository: BlogRepository

    fun getAll(page: Int, pageSize: Int): List<Blog> {
        val pageRequest = PageRequest.of(
            (page - 1).coerceAtLeast(0),
            pageSize,
            Sort.by(Sort.Direction.ASC, "id")
        )
        return repository.findAll(pageRequest).toList()
    }

    @Transactional
    fun getById(id: Long): Blog? {
        return repository.findById(id).map { blog ->
            blog.visitCount = (blog.visitCount ?: 0) + 1
            blog
        }.orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getByTitle(title: String): List<Blog> {
        return repository.findByTitle(title)
    }

    fun getCount(): Long {
        return repository.count()
    }
}