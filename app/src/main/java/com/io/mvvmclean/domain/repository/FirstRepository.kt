package com.io.mvvmclean.domain.repository

import com.io.mvvmclean.data.source.network.entities.MyBlogs
import com.io.mvvmclean.state.ApiState
import kotlinx.coroutines.flow.Flow

interface FirstRepository {
   suspend fun getDataFromNetworkApi() : Flow<ApiState<List<MyBlogs>>>
}