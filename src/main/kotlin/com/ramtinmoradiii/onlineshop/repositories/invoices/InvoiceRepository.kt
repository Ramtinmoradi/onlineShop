package com.ramtinmoradiii.onlineshop.repositories.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.Invoice
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface InvoiceRepository : PagingAndSortingRepository<Invoice, Long>, CrudRepository<Invoice, Long> {
    @Query("from Invoice where user.id = :userId")
    fun findAllByUserId(userId: Long?, pageable: Pageable): List<Invoice>?
}