package com.ramtinmoradiii.onlineshop.repositories.site

import com.ramtinmoradiii.onlineshop.models.site.Blog
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface BlogRepository : PagingAndSortingRepository<Blog, Long>, CrudRepository<Blog, Long> {
    override fun findAll(): List<Blog>
    
    fun findByTitle(title: String): List<Blog>
}