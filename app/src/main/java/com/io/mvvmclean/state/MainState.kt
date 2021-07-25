package com.io.mvvmclean.state

sealed class MainState {
    object  MyBlogState : MainState()
    object  Empty : MainState()
}