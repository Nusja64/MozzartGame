package com.example.mozzart_test.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mozzart_test.data.model.Draw
import com.example.mozzart_test.data.model.DrawData
import com.example.mozzart_test.network.ApiClient
import com.example.mozzart_test.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask

class DrawViewModel : ViewModel() {
    private val _drawDataStateFlow = MutableStateFlow<List<DrawData>>(emptyList())
    val drawDataStateFlow: StateFlow<List<DrawData>> = _drawDataStateFlow


    fun fetchUpcomingDraws() {
        val service = ApiClient.apiService
        service.getDraws().enqueue(object : Callback<List<DrawData>> {
            override fun onResponse(
                call: Call<List<DrawData>>,
                response: Response<List<DrawData>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { draws ->
                        _drawDataStateFlow.value = draws
                      //  startTimer(draws)
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

    private suspend fun startTimer(items: List<DrawData>) {
        withContext(Dispatchers.IO) {
            val timer = Timer()
            timer.scheduleAtFixedRate(object : (TimerTask)() {
                override fun run() {
                    val currentTime = Calendar.getInstance().timeInMillis
                    items.map {


                    }
                }
            }, 0, Constants.PERIOD_TIME_IN_MILLIS) // Update every second
        }
    }

}
