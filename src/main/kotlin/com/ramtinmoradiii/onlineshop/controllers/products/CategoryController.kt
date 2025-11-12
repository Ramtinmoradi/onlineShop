package com.ramtinmoradiii.onlineshop.controllers.products

import com.ramtinmoradiii.onlineshop.models.products.Category
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.products.CategoryService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.CATEGORY)
class CategoryController {

    @Autowired
    lateinit var service: CategoryService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAll() : ServiceResponse<List<Category>> {
        return ServiceResponse(true, ResponseMessage.OK,service.getAll())
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getById(@PathVariable("id") id : Long) : ServiceResponse<Category?> {
        return ServiceResponse(true, ResponseMessage.OK,service.getById(id))
    }

    @GetMapping(ApiRoutes.COUNT)
    fun getCount() : ServiceResponse<Long> {
        return ServiceResponse(true, ResponseMessage.OK,service.getCount())
    }
}