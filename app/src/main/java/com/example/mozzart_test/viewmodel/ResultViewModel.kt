package com.example.mozzart_test.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mozzart_test.data.model.ResultData
import com.example.mozzart_test.network.ApiClient
import com.example.mozzart_test.utils.DateTimeFormatter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ResultViewModel : ViewModel() {
    private val dateTimeFormatter = DateTimeFormatter()
    private val _resultStateFlow =
        MutableStateFlow(ResultData())
    val resultStateFlow: StateFlow<ResultData> = _resultStateFlow

    fun loadResultData() {

        val service = ApiClient.apiService
        val startDateInMillis = dateTimeFormatter.getStartOfDayInMillis()
        val endDateInMillis = dateTimeFormatter.getStartOfDayInMillis()
        val startDate = dateTimeFormatter.getDate(startDateInMillis)
        val endDate = dateTimeFormatter.getDate(endDateInMillis)
        Timber.d("Start date : $startDate and end date : $endDate ")

        service.getResults(startDate, endDate).enqueue(object : Callback<ResultData> {
            override fun onResponse(
                call: Call<ResultData>,
                response: Response<ResultData>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { results ->
                        _resultStateFlow.value = results
                        Timber.d(" http Result observeViewModel $results")
                    }
                } else {
                    //TODO IMPLEMENT ERROR LOGIC
                    Timber.d(" http error Result observeViewModel")
                }
            }

            override fun onFailure(call: Call<ResultData>, t: Throwable) {
                Timber.e(" http error Result observeViewModel failure : ${t.message}")

            }
        })
    }

}
