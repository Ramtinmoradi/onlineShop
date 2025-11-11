package com.ramtinmoradiii.onlineshop.models.customers

import jakarta.persistence.*


@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var firstName: String? = null
    var lastName: String? = null
    var address: String? = null
    var email: String? = null
    var phoneNumber: String? = null
    var age: Int? = null
    var postalCode: String? = null

    @OneToOne(mappedBy = "customer")
    var user: User? = null
}
