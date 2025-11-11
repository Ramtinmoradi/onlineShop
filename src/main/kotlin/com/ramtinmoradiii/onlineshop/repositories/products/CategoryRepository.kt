package com.ramtinmoradiii.onlineshop.repositories.products

import com.ramtinmoradiii.onlineshop.models.products.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface CategoryRepository : PagingAndSortingRepository<Category, Long>,
    CrudRepository<Category, Long> {
    override fun findAll(): List<Category>
}