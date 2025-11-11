package com.ramtinmoradiii.onlineshop.models.products

import jakarta.persistence.*

@Entity
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null

    @OneToMany(mappedBy = "category")
    var products: List<Product>? = null
}