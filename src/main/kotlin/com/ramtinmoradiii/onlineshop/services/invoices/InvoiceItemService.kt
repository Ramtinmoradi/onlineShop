package com.ramtinmoradiii.onlineshop.services.invoices

import com.ramtinmoradiii.onlineshop.exceptions.ResourceNotFoundException
import com.ramtinmoradiii.onlineshop.models.invoices.InvoiceItem
import com.ramtinmoradiii.onlineshop.repositories.invoices.InvoiceItemRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class InvoiceItemService {

    @Autowired
    lateinit var repository: InvoiceItemRepository


    fun getById(id: Long): InvoiceItem? {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(ResponseMessage.NOT_FOUND) }
    }

    fun getAllByInvoiceId(page: Int, pageSize: Int, invoiceId: Long?): List<InvoiceItem> {
        return repository.findAllByInvoiceId(
            invoiceId,
            PageRequest.of(
                (page - 1).coerceAtLeast(0),
                pageSize,
                Sort.by(
                    Sort.Direction.ASC,
                    "id"
                )
            )
        )
    }
}