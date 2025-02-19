package com.android1.petrol_pump

data class Mydata(
    val limit: Int,
    val products: List<JsonData>,
    val skip: Int,
    val total: Int
)
