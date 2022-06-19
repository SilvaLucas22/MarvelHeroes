package com.example.meuappmarvel.models

import com.google.gson.annotations.SerializedName

data class RetornoAPI(

    @SerializedName("code")
    var code: Int,

    @SerializedName("status")
    var status: String,

    @SerializedName("copyright")
    var copyright: String,

    @SerializedName("attributeText")
    var attributeText: String,

    @SerializedName("attributionHTML")
    var attributionHTML: String,

    @SerializedName("etag")
    var etag: String,

    @SerializedName("data")
    var data: Data

)
