package com.ramtinmoradiii.onlineshop.services.invoices

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.invoices.Invoice
import com.ramtinmoradiii.onlineshop.repositories.invoices.InvoiceRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
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

    fun getById(id: Long): Invoice? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getAllByUserId(userId: Long?, page: Int, pageSize: Int): List<Invoice>? {
        return repository.findAllByUserId(
            userId,
            PageRequest.of(
                (page - 1).coerceAtLeast(0),
                pageSize,
                Sort.by(
                    Sort.Direction.ASC,
                    "id"
                )
            )
        )?.toList()
    }
}