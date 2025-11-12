package com.ramtinmoradiii.onlineshop.models.invoices

import jakarta.persistence.*

@Entity
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var authority: String? = null,
    var status: Int? = null,
    var refId: String? = null,

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    var invoice: Invoice? = null,
)
