package com.android1.petrol_pump.ApiInterfaceModel

import com.android1.petrol_pump.Mydata
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getJsonData():Call<Mydata>

}