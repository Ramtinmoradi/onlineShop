package com.ramtinmoradiii.onlineshop.models.site

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null
    var subTitle: String? = null
    var author: String? = null
    var image: String? = null
    @Column(columnDefinition = "TEXT")
    var description: String? = null
    var visitCount: Int? = 0
    var addDate: String? = null
}
