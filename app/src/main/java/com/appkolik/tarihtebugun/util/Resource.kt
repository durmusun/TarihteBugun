package com.appkolik.tarihtebugun.util

sealed class Resource<T>(val data : T? = null, val message : String? = null){
    class Success<T>(data: T, message: String) : Resource<T>(data,message)
    class Error<T>(data: T? = null,message: String) : Resource<T>(data,message)
    class Loading<T>(data: T? = null,message: String) : Resource<T>(data,message)
}
