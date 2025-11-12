package com.ramtinmoradiii.onlineshop.models.products

import jakarta.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String? = null,
    @Column(columnDefinition = "TEXT")
    var description: String? = null,
    var price: Int? = null,
    var quantity: Int? = null,
    var image: String? = null,
    var addDate: String? = null,
    var visitCount: Int? = 0,
    var orderCount: Int? = 0,

    @ManyToMany
    @JoinTable(
        name = "product_colors",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "color_id")]
    )
    var colors: List<Color>? = null,

    @ManyToMany
    @JoinTable(
        name = "product_sizes",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "size_id")]
    )
    var sizes: List<Size>? = null,

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category? = null,
)