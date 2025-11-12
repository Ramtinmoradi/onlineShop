package com.ramtinmoradiii.onlineshop.models.invoices

import com.ramtinmoradiii.onlineshop.models.products.Product
import jakarta.persistence.*

@Entity
data class InvoiceItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product? = null,
    var quantity: Int? = null,
    var unitPrice: Double? = null,

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    var invoice: Invoice? = null,
)
