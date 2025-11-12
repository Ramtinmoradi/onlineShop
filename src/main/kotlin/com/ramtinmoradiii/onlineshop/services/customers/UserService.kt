package com.ramtinmoradiii.onlineshop.services.customers

import com.ramtinmoradiii.onlineshop.models.customers.User
import com.ramtinmoradiii.onlineshop.repositories.customers.UserRepository
import com.ramtinmoradiii.onlineshop.utils.ResponseMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var repository: UserRepository

    fun insert(user: User): User? {
        user.id = null
        return repository.save(user)
    }

    fun update(user: User, repeatPassword: String): User? {
        val userId = user.id ?: return null

        if (!repository.existsById(userId)) return null

        if (user.password != repeatPassword) throw Exception(ResponseMessage.NOT_MATCH_PASSWORD)

        return repository.save(user)
    }

    fun login(username: String, password: String): User? {
        if (username.isEmpty() || password.isEmpty())
            throw Exception(ResponseMessage.ENTER_USERNAME_AND_PASSWORD)
        return repository.findByUsernameAndPassword(username, password)
    }
}