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
    const val INVOICE_ITEM = "$INVOICE/item"

    //USER
    const val USER = "$VERSIONONE/user"
    const val LOGIN = "/login"
    const val SIGNUP = "/signup"

    //CUSTOMER
    const val CUSTOMER = "$VERSIONONE/customer"

    //TRANSACTION
    const val TRANSACTION = "$VERSIONONE/transaction"

    //CONSTANTS
    const val EMPTY = ""
    const val BY_ID = "/{id}"
    const val SEARCH = "/search"
    const val COUNT = "/count"
    const val BY_TITLE = "/title/{title}"
    const val NEW = "/new"
    const val TOP_ORDER = "/topOrder"
    const val TOP_VIEW = "/topView"
    const val UPDATE = "/update"
}