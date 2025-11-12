package com.ramtinmoradiii.onlineshop.controllers.site

import com.ramtinmoradiii.onlineshop.models.site.Content
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.site.ContentService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.CONTENT)
class ContentController {

    @Autowired
    lateinit var service: ContentService

    @GetMapping(ApiRoutes.EMPTY)
    fun getAll(): ServiceResponse<List<Content>> {
        return ServiceResponse(true, ResponseMessage.OK, service.getAll())
    }

    @GetMapping(ApiRoutes.BY_TITLE)
    fun getByTitle(@PathVariable("title") title: String): ServiceResponse<List<Content>> {
        return ServiceResponse(true, ResponseMessage.OK, service.getByTitle(title))
    }

    @GetMapping(ApiRoutes.BY_ID)
    fun getById(@PathVariable("id") id: Long): ServiceResponse<Content?> {
        return ServiceResponse(true, ResponseMessage.OK, service.getById(id))
    }

    @GetMapping(ApiRoutes.COUNT)
    fun getCount(): ServiceResponse<Long> {
        return ServiceResponse(true, ResponseMessage.OK, service.getCount())
    }
}