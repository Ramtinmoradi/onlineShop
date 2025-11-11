package com.ramtinmoradiii.onlineshop.repositories.customers

import com.ramtinmoradiii.onlineshop.models.customers.User
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepository : PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
    fun findByUsernameAndPassword(username: String, password: String): User?
}