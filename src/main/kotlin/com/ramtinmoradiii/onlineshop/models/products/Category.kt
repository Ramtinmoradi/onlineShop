package com.ramtinmoradiii.onlineshop.models.products

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String? = null,
    var image: String? = null,

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    var products: List<Product>? = null,
)