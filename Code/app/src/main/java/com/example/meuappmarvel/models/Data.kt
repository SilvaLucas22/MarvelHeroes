package com.example.meuappmarvel.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("offset")
    var offset: Int,

    @SerializedName("limit")
    var limit: Int,

    @SerializedName("total")
    var total: Int,

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var results: List<Hero>

){

    @JvmName("getTotal1")
    fun getTotal() = total

    @JvmName("getCount1")
    fun getCount() = count

    override fun toString(): String {
        return "Offset: $offset \n" +
                "Total: $total \n" +
                "Count: $count"

    }

}
