package com.io.mvvmclean.presentation.mainfeature

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.io.mvvmclean.R
import com.io.mvvmclean.data.source.network.entities.MyBlogs
import com.io.mvvmclean.state.ApiState
import com.io.mvvmclean.state.MainState
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.http.HTTP
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    val vm: FirstViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeDataObservers()

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            vm.getMyBlogsFromViewModel(MainState.MyBlogState)

        }
    }

    private fun subscribeDataObservers() {
        vm.dataPublish.observe(requireActivity(), Observer {
            dataState->
            when(dataState){
                is ApiState.onLoading ->{
                    Toast.makeText(requireContext(),"Is Loading",Toast.LENGTH_SHORT).show()
                }
                is ApiState.onError ->{
                    Toast.makeText(requireContext(),"Failed To Load Data",Toast.LENGTH_SHORT).show()
                }
                is ApiState.onSuccess<List<MyBlogs>>->{
                    if(dataState.isResult != null){
                        Toast.makeText(requireContext(),"Retrieve data successfully = ${dataState.isResult.size}",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(requireContext(),"No data available ",Toast.LENGTH_SHORT).show()

                    }
                }
            }
        })
    }
}