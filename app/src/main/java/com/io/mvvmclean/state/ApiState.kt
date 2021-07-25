package com.io.mvvmclean.state

sealed class ApiState<out T>{
    object onLoading : ApiState<Nothing>()
    class onSuccess<out S>(val isResult : S) : ApiState<S>()
    class onError<out E>(val isError : E ) : ApiState<E>()
}
