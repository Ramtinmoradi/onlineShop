package com.ramtinmoradiii.onlineshop.services.customers

import com.ramtinmoradiii.onlineshop.models.customers.User
import com.ramtinmoradiii.onlineshop.repositories.customers.UserRepository
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

    fun update(user: User): User? {
        val userId = user.id ?: return null

        if (!repository.existsById(userId)) return null

        return repository.save(user)
    }

    fun login(username: String, password: String): User? {
        return repository.findByUsernameAndPassword(username, password)
    }
}