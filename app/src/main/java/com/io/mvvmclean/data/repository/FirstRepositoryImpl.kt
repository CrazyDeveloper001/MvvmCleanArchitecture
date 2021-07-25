package com.io.mvvmclean.data.repository

import android.util.Log
import com.io.mvvmclean.data.source.network.NetworkApi
import com.io.mvvmclean.data.source.network.entities.MyBlogs
import com.io.mvvmclean.domain.repository.FirstRepository
import com.io.mvvmclean.state.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FirstRepositoryImpl
@Inject constructor(private val networkApi: NetworkApi) : FirstRepository {
    override suspend fun getDataFromNetworkApi(): Flow<ApiState<List<MyBlogs>>> {

        return flow {
            emit(ApiState.onLoading)
            val myBlogs =  networkApi.getBlogsFromNetwork()
            emit(
                ApiState.onSuccess(myBlogs)
            )
        }.flowOn(Dispatchers.IO)
    }
}