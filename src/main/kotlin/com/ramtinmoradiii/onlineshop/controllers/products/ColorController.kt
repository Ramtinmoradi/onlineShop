package com.ramtinmoradiii.onlineshop.controllers.products

import com.ramtinmoradiii.onlineshop.models.products.Color
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.products.ColorService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.COLOR)
class ColorController {

    @Autowired
    lateinit var service: ColorService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAll(): ServiceResponse<List<Color>> {
        return ServiceResponse(true, ResponseMessage.OK,service.getAll())
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getById(@PathVariable id: Long): ServiceResponse<Color> {
        return ServiceResponse(true, ResponseMessage.OK,service.getById(id))
    }

    @GetMapping(ApiRoutes.COUNT)
    fun getCount(): ServiceResponse<Long> {
        return ServiceResponse(true, ResponseMessage.OK,service.getCount())
    }
}