package com.ramtinmoradiii.onlineshop.viewmodels.customers

import com.ramtinmoradiii.onlineshop.models.customers.Customer
import com.ramtinmoradiii.onlineshop.models.customers.User

data class UserViewModel(
    var userId: Long,
    var customerId: Long,
    var username: String,
    var password: String,
    var repeatPassword: String,
    var firstName: String,
    var lastName: String,
    var address: String,
    var phoneNumber: String,
    var postalCode: String,
) {
    fun convertToUser(): User {
        return User(
            id = userId,
            username = username,
            password = password,
        )
    }

    fun convertCustomer(): Customer {
        return Customer(
            id = customerId,
            firstName = firstName,
            lastName = lastName,
            address = address,
            phoneNumber = phoneNumber,
            postalCode = postalCode,
        )
    }
}