package com.ramtinmoradiii.onlineshop.controllers.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.Invoice
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.invoices.InvoiceService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.INVOICE)
class InvoiceController {

    @Autowired
    lateinit var service: InvoiceService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAllByUserId(
        @RequestParam(name = "page", defaultValue = "1") page: Int,
        @RequestParam(name = "pageSize", defaultValue = "20") pageSize: Int,
        @RequestParam(name = "id", required = false) userId: Long?,
    ): ServiceResponse<List<Invoice>> {
        return ServiceResponse(
            true,
            ResponseMessage.OK,
            service.getAllByUserId(userId, page, pageSize)
        )
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getById(@PathVariable("id") id: Long): ServiceResponse<Invoice?> {
        return ServiceResponse(true, ResponseMessage.OK, service.getById(id))
    }

    @PostMapping(ApiRoutes.EMPTY)
    fun addInvoice(@RequestBody invoice: Invoice): ServiceResponse<Invoice?> {
        return ServiceResponse(true, ResponseMessage.OK, service.insert(invoice))
    }

    @PutMapping(ApiRoutes.EMPTY)
    fun updateInvoice(@RequestBody invoice: Invoice): ServiceResponse<Invoice?> {
        return ServiceResponse(true, ResponseMessage.OK, service.update(invoice))
    }
}