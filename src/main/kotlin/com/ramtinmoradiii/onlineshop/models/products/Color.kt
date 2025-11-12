package com.ramtinmoradiii.onlineshop.models.products

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Color(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String? = null,
    var hexValue: String? = null,

    @ManyToMany(mappedBy = "colors")
    @JsonIgnore
    var products: List<Product>? = null,
)