package com.ramtinmoradiii.onlineshop.repositories.site

import com.ramtinmoradiii.onlineshop.models.site.Slider
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface SliderRepository : PagingAndSortingRepository<Slider, Long>, CrudRepository<Slider, Long> {
    override fun findAll(): List<Slider>
}