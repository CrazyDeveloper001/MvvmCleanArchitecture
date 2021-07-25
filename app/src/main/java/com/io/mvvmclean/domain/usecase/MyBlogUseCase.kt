package com.io.mvvmclean.domain.usecase

import com.io.mvvmclean.data.source.network.entities.MyBlogs
import com.io.mvvmclean.domain.repository.FirstRepository
import com.io.mvvmclean.state.ApiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MyBlogUseCase
@Inject constructor(val firstRepository: FirstRepository) {

    suspend fun getBlogDataFromUsecase() : Flow<ApiState<List<MyBlogs>>> {
        return firstRepository.getDataFromNetworkApi()
    }
}