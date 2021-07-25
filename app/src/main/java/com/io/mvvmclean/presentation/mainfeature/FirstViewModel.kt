package com.io.mvvmclean.presentation.mainfeature

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.mvvmclean.data.source.network.entities.MyBlogs
import com.io.mvvmclean.domain.usecase.MyBlogUseCase
import com.io.mvvmclean.state.ApiState
import com.io.mvvmclean.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FirstViewModel
    @Inject constructor(val myBlogUseCase : MyBlogUseCase): ViewModel() {
            var dataPublish : MutableLiveData<ApiState<List<MyBlogs>>> = MutableLiveData()

    fun getMyBlogsFromViewModel(mainState: MainState){
            when(mainState){
                is MainState.MyBlogState ->{
                    viewModelScope.launch {
                        myBlogUseCase.getBlogDataFromUsecase().onEach { apistateData ->

                            dataPublish.postValue(apistateData)
                        }.launchIn(viewModelScope)
                    }
                }

                is MainState.Empty->{

                }
            }

        }


    }