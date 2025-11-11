package com.ramtinmoradiii.onlineshop.models.products

import jakarta.persistence.*

@Entity
class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null
    var value: String? = null

    @ManyToMany(mappedBy = "sizes")
    var products: List<Product>? = null
}