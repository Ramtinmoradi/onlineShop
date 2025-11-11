package com.ramtinmoradiii.onlineshop.services.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.Invoice
import com.ramtinmoradiii.onlineshop.repositories.invoices.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class InvoiceService {

    @Autowired
    lateinit var repository: InvoiceRepository

    fun insert(invoice: Invoice): Invoice {
        invoice.id = null
        return repository.save(invoice)
    }

    fun update(invoice: Invoice): Invoice? {
        val id = invoice.id ?: return null

        if (!repository.existsById(id)) return null

        return repository.save(invoice)
    }

    fun getAll(page: Int = 1, pageSize: Int = 20): List<Invoice> {
        val pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"))
        return repository.findAll(pageRequest).toList()
    }

    fun getById(id: Long): Invoice? {
        return repository.findById(id).orElse(null)
    }

    fun getByUserId(userId: Long, page: Int = 1, pageSize: Int = 20): List<Invoice>? {
        val pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"))
        return repository.findByUserId(userId, pageRequest)?.toList()
    }
}