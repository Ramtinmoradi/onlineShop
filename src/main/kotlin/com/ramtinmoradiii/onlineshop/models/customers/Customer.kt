package com.ramtinmoradiii.onlineshop.models.customers

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*


@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var address: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var age: Int? = null,
    var postalCode: String? = null,

    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    var user: User? = null,
)
