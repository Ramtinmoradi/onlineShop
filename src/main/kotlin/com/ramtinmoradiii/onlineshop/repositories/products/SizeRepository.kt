package com.ramtinmoradiii.onlineshop.repositories.products

import com.ramtinmoradiii.onlineshop.models.products.Size
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface SizeRepository : PagingAndSortingRepository<Size, Long>, CrudRepository<Size, Long> {
    override fun findAll(): List<Size>
}