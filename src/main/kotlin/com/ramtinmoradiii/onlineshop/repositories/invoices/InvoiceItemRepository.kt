package com.ramtinmoradiii.onlineshop.repositories.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.InvoiceItem
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface InvoiceItemRepository : PagingAndSortingRepository<InvoiceItem, Long>, CrudRepository<InvoiceItem, Long> {
    override fun findAll(): List<InvoiceItem>

    @Query("from InvoiceItem where invoice.id= :invoiceId")
    fun findByInvoiceId(invoiceId: Long): List<InvoiceItem>
}