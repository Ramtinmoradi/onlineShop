package com.ramtinmoradiii.onlineshop.repositories.products

import com.ramtinmoradiii.onlineshop.models.products.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface ProductRepository : PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> {
    override fun findAll(): List<Product>
    fun findByTitle(title: String): Product?
    fun findAllByOrderByAddDateDesc(pageable: Pageable): List<Product>
    fun findTop10ByOrderByOrderCountDesc(): List<Product>
    fun findTop10ByOrderByVisitCountDesc(): List<Product>
}
