package com.ramtinmoradiii.onlineshop.responses

import java.io.Serializable

data class ServiceResponse<T>(var success: Boolean, var message: String, var data: T?) : Serializable