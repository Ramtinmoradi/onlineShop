package com.ramtinmoradiii.onlineshop.controllers.customers

import com.ramtinmoradiii.onlineshop.models.customers.User
import com.ramtinmoradiii.onlineshop.responses.ServiceResponse
import com.ramtinmoradiii.onlineshop.services.customers.UserService
import com.ramtinmoradiii.onlineshop.utils.ApiRoutes
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import com.ramtinmoradiii.onlineshop.viewmodels.customers.UserViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRoutes.USER)
class UserController {

    @Autowired
    lateinit var service: UserService

    @PostMapping(ApiRoutes.SIGNUP)
    fun signup(@RequestBody user: UserViewModel): ServiceResponse<User> {
        return ServiceResponse(
            true,
            ResponseMessage.OK,
            service.insert(user.convertToUser())
        )
    }

    @PostMapping(ApiRoutes.LOGIN)
    fun login(@RequestBody username: String, @RequestBody password: String): ServiceResponse<User> {
        return ServiceResponse(
            true,
            ResponseMessage.OK,
            service.login(username, password)
        )
    }

    @PutMapping(ApiRoutes.UPDATE)
    fun update(@RequestBody user: UserViewModel): ServiceResponse<User> {
        return ServiceResponse(
            true,
            ResponseMessage.OK,
            service.update(
                user.convertToUser(),
                user.repeatPassword
            )
        )
    }
}