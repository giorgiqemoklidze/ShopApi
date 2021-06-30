package com.example.shopapi.network

data class Resource<T>(val status :Status,val data: T? = null ,val message : String? = null , val loading : Boolean){

    enum class Status{
        Succsess,
        Error,
        Loading

    }

    companion object{

        fun<T> succsess(data : T): Resource<T>{
            return Resource(Status.Succsess,data,null,false)
        }

        fun<T> error(message: String? ): Resource<T>{
            return Resource(Status.Error,null,message,false)
        }

        fun<T> loading(loading: Boolean ): Resource<T>{
            return Resource(Status.Loading,null,null,loading)
        }

    }

}
