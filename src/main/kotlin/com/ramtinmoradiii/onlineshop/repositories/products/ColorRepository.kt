package com.ramtinmoradiii.onlineshop.repositories.products

import com.ramtinmoradiii.onlineshop.models.products.Color
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface ColorRepository : PagingAndSortingRepository<Color, Long>, CrudRepository<Color, Long> {
    override fun findAll(): List<Color>
}