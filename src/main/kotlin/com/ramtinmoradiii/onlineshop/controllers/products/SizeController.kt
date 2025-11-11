package com.ramtinmoradiii.onlineshop.controllers.products

import com.ramtinmoradiii.onlineshop.models.products.Size
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.products.SizeService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.SIZE)
class SizeController {

    @Autowired
    lateinit var service: SizeService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAll() : ServiceResponse<List<Size>> {
        return ServiceResponse(true, ResponseMessage.OK,service.getAll())
    }

    @GetMapping(ApiRoutes.BYID)
    fun getByID(@PathVariable id : Long) : ServiceResponse<Size> {
        return ServiceResponse(true, ResponseMessage.OK,service.getById(id))
    }

    @GetMapping(ApiRoutes.COUNT)
    fun getCount() : ServiceResponse<Long> {
        return ServiceResponse(true, ResponseMessage.OK,service.getCount())
    }
}