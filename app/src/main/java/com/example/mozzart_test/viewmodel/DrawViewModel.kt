package com.example.mozzart_test.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mozzart_test.data.model.DrawData
import com.example.mozzart_test.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrawViewModel : ViewModel() {
    private val _drawDataStateFlow = MutableStateFlow<List<DrawData>>(emptyList())
    val drawDataStateFlow: StateFlow<List<DrawData>> = _drawDataStateFlow


    fun fetchUpcomingDraws() {
        val service = ApiClient.apiService
        service.getDraws().enqueue(object : Callback<List<DrawData>> {
            override fun onResponse(call: Call<List<DrawData>>, response: Response<List<DrawData>>) {
                if (response.isSuccessful) {
                    response.body()?.let { draws ->
                        _drawDataStateFlow.value = draws
                        startTimer()
                    }
                } else {
                    _drawDataStateFlow.value = emptyList()
                }
            }


            //TODO HANDLING OF ERROR USE ERROR CLASS AND ERROR TYPE
            override fun onFailure(call: Call<List<DrawData>>, t: Throwable) {
                _drawDataStateFlow.value = emptyList()
            }
        })
    }

    fun startTimer() {

    }


}
