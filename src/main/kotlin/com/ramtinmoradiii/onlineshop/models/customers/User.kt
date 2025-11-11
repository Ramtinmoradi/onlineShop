package com.ramtinmoradiii.onlineshop.models.customers

import com.ramtinmoradiii.onlineshop.models.invoices.Invoice
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var username: String? = null
    var password: String? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var invoices: List<Invoice>? = null
}