package com.ramtinmoradiii.onlineshop.models.products

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null
    var value: String? = null

    @ManyToMany(mappedBy = "sizes")
    @JsonIgnore
    var products: List<Product>? = null
}