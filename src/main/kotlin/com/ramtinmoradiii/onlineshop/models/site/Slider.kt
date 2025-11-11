package com.ramtinmoradiii.onlineshop.models.site

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Slider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var image: String? = null
    var title: String? = null
    var subTitle: String? = null
    var link: String? = null
}