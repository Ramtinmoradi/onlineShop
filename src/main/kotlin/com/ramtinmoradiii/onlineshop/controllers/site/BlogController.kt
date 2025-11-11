package com.ramtinmoradiii.onlineshop.controllers.site

import com.ramtinmoradiii.onlineshop.models.site.Blog
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.site.BlogService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.BLOG)
class BlogController {

    @Autowired
    lateinit var service: BlogService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAll(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "20") pageSize: Int
    ): ServiceResponse<List<Blog>> {
        return ServiceResponse(true, ResponseMessage.OK, service.getAll(page, pageSize))
    }

    @GetMapping(ApiRoutes.BYID)
    fun getById(@PathVariable("id") id: Long): ServiceResponse<Blog> {
        return ServiceResponse(true, ResponseMessage.OK, service.getById(id))
    }

    @GetMapping(ApiRoutes.BYTITLE)
    fun getByTitle(@PathVariable("title") title: String): ServiceResponse<List<Blog>> {
        return  ServiceResponse(true, ResponseMessage.OK, service.getByTitle(title))
    }

    @GetMapping(ApiRoutes.COUNT)
    fun getCount(): ServiceResponse<Long> {
        return ServiceResponse(true, ResponseMessage.OK, service.getCount())
    }
}