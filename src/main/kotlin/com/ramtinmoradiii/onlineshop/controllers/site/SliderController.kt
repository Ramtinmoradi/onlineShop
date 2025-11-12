package com.ramtinmoradiii.onlineshop.controllers.site

import com.ramtinmoradiii.onlineshop.models.site.Slider
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.site.SliderService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.SLIDER)
class SliderController {

    @Autowired
    private lateinit var service: SliderService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAll(): ServiceResponse<List<Slider>> {
        return ServiceResponse(true, ResponseMessage.OK, service.getAll())
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getById(@PathVariable("id") id: Long): ServiceResponse<Slider?> {
        return ServiceResponse(true, ResponseMessage.OK, service.getById(id))
    }

    @GetMapping(ApiRoutes.COUNT)
    fun getCount(): ServiceResponse<Long?> {
        return ServiceResponse(true, ResponseMessage.OK, service.getCount())
    }
}