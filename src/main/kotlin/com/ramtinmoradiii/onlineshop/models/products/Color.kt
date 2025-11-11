package com.ramtinmoradiii.onlineshop.models.products

import jakarta.persistence.*

@Entity
class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null
    var hexValue: String? = null

    @ManyToMany(mappedBy = "colors")
    var products: List<Product>? = null
}