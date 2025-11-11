package com.ramtinmoradiii.onlineshop.services.products

import com.ramtinmoradiii.onlineshop.models.products.Product
import com.ramtinmoradiii.onlineshop.repositories.products.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService {

    @Autowired
    lateinit var repository: ProductRepository

    fun getAll(page: Int = 1, pageSize: Int = 20): List<Product> {
        val pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"))
        return repository.findAll(pageRequest).toList()
    }

    fun getByTitle(title: String): Product? {
        return repository.findByTitle(title)
    }

    @Transactional
    fun getById(id: Long): Product? {
        return repository.findById(id).map { product ->
            product.visitCount = (product.visitCount ?: 0) + 1
            product
        }.orElse(null)
    }

    fun getNew(page: Int = 1, pageSize: Int = 20): List<Product> {
        val pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "id"))
        return repository.findAllByOrderByAddDateDesc(pageRequest).toList()
    }

    fun getTopOrder(): List<Product> {
        return repository.findTop10ByOrderByOrderCountDesc()
    }

    fun getTopVisited(): List<Product> {
        return repository.findTop10ByOrderByVisitCountDesc()
    }

    fun getCount(): Long {
        return repository.count()
    }
}