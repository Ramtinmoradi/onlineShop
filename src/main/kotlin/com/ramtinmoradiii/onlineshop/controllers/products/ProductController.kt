package com.ramtinmoradiii.onlineshop.controllers.products

import com.ramtinmoradiii.onlineshop.models.products.Product
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.products.ProductService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.PRODUCT)
class ProductController {

    @Autowired
    lateinit var service: ProductService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAll(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "20") pageSize: Int,
    ) : ServiceResponse<List<Product>> {
        return ServiceResponse(true, ResponseMessage.OK,service.getAll(page,pageSize))
    }

    @GetMapping(ApiRoutes.BYTITLE)
    fun getByTitle(@PathVariable("title") title: String) : ServiceResponse<List<Product>> {
        return  ServiceResponse(true, ResponseMessage.OK,service.getByTitle(title))
    }

    @GetMapping(ApiRoutes.BYID)
    fun getById(@PathVariable("id") id: Long) : ServiceResponse<Product> {
        return ServiceResponse(true, ResponseMessage.OK,service.getById(id))
    }

    @GetMapping(ApiRoutes.NEW)
    fun getNew(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "20") pageSize: Int,
    ) : ServiceResponse<List<Product>> {
        return ServiceResponse(true, ResponseMessage.OK,service.getNew(page,pageSize))
    }

    @GetMapping(ApiRoutes.TOPORDER)
    fun getTop(): ServiceResponse<List<Product>> {
        return ServiceResponse(true, ResponseMessage.OK,service.getTopOrder())
    }

    @GetMapping(ApiRoutes.TOPVIEW)
    fun getView(): ServiceResponse<List<Product>> {
        return ServiceResponse(true, ResponseMessage.OK,service.getTopView())
    }
}