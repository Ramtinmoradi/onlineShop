package com.ramtinmoradiii.onlineshop.models.invoices

import com.ramtinmoradiii.onlineshop.models.customers.User
import com.ramtinmoradiii.onlineshop.models.enums.InvoiceStatus
import jakarta.persistence.*

@Entity
class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var number: Int? = null

    @Enumerated(EnumType.STRING)
    var status: InvoiceStatus? = null
    var addDate: String? = null
    var paymentDate: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null

    @OneToMany(mappedBy = "invoice", cascade = [CascadeType.ALL])
    var items: List<InvoiceItem>? = null

    @OneToMany(mappedBy = "invoice", cascade = [CascadeType.ALL])
    var transactions: List<Transaction>? = null
}