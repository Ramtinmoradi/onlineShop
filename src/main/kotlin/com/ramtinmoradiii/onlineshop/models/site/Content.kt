package com.ramtinmoradiii.onlineshop.models.site

import jakarta.persistence.*

@Entity
class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null

    @Column(columnDefinition = "TEXT")
    var description: String? = null
}
