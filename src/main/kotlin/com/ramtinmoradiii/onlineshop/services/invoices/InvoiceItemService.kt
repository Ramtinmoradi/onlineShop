package com.ramtinmoradiii.onlineshop.services.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.InvoiceItem
import com.ramtinmoradiii.onlineshop.repositories.invoices.InvoiceItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvoiceItemService {

    @Autowired
    lateinit var repository: InvoiceItemRepository

    fun getAll(): List<InvoiceItem> {
        return repository.findAll()
    }

    fun getById(id: Long): InvoiceItem? {
        return repository.findById(id).orElse(null)
    }

    fun getByInvoiceId(invoiceId: Long): List<InvoiceItem> {
        return repository.findByInvoiceId(invoiceId)
    }
}