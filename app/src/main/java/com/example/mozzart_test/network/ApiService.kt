package com.example.mozzart_test.network

import com.example.mozzart_test.data.model.DrawData
import com.example.mozzart_test.data.model.ResultData
import com.example.mozzart_test.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {


    @GET(Constants.DRAWS_URL)
    fun getDraws(): Call<List<DrawData>>

    @GET(Constants.GAME_DETAILS_URL)
    fun getGameDetailsByDrawId(): Call<DrawData>

    @GET(Constants.RESULTS_URL)
    fun getResults(
        @Path("startDate") startDate: String,
        @Path("endDate") endDate: String,
    ): Call<ResultData>
}
