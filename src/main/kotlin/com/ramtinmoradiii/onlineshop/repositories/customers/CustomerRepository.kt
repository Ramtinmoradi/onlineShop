package com.ramtinmoradiii.onlineshop.repositories.customers

import com.ramtinmoradiii.onlineshop.models.customers.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface CustomerRepository : PagingAndSortingRepository<Customer, Long>, CrudRepository<Customer, Long> {}