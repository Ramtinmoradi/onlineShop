package com.ramtinmoradiii.onlineshop.utils

object ApiRoutes {
    //API VERSION
    const val VERSIONONE = "/api/v1"

    //SLIDER
    const val SLIDER = "$VERSIONONE/slider"

    //CONTENT
    const val CONTENT = "$VERSIONONE/content"

    //BLOG
    const val BLOG = "$VERSIONONE/blog"

    //PRODUCT
    const val CATEGORY = "$VERSIONONE/product/category"
    const val PRODUCT = "$VERSIONONE/product"
    const val COLOR = "$VERSIONONE/product/color"
    const val SIZE = "$VERSIONONE/product/size"

    //INVOICE
    const val INVOICE = "$VERSIONONE/invoice"

    //CONSTANTS
    const val EMPTY = ""
    const val BYID = "/{id}"
    const val COUNT = "/count"
    const val BYTITLE = "/title/{title}"
    const val NEW = "/new"
    const val TOPORDER = "/topOrder"
    const val TOPVIEW = "/topView"
}