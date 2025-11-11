package com.ramtinmoradiii.onlineshop.repositories.site

import com.ramtinmoradiii.onlineshop.models.site.Content
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface ContentRepository : PagingAndSortingRepository<Content, Long>, CrudRepository<Content, Long> {
    override fun findAll(): List<Content>

    fun findByTitle(title: String): List<Content>
}