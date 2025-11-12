package com.ramtinmoradiii.onlineshop.controllers.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.InvoiceItem
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.invoices.InvoiceItemService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.INVOICE_ITEM)
class InvoiceItemController {

    @Autowired
    lateinit var service: InvoiceItemService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAllByInvoiceId(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "pageSize", defaultValue = "20") pageSize: Int,
        @RequestParam(value = "id") id: Long?,
    ): ServiceResponse<List<InvoiceItem>> {
        return ServiceResponse(
            true,
            ResponseMessage.OK,
            service.getAllByInvoiceId(page, pageSize, id)
        )
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getByInvoiceId(@PathVariable("id") id: Long): ServiceResponse<InvoiceItem?> {
        return ServiceResponse(true, ResponseMessage.OK, service.getById(id))
    }
}