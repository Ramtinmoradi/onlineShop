package com.ramtinmoradiii.onlineshop.repositories.invoices

import com.ramtinmoradiii.onlineshop.models.invoices.Transaction
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface TransactionRepository : PagingAndSortingRepository<Transaction, Long>, CrudRepository<Transaction, Long> {}