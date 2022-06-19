package com.example.meuappmarvel.models

import android.provider.CalendarContract.Events
import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("description")
    var description: String

    /*@SerializedName("modified")
    var modified: String,

    @SerializedName("thumbnail")
    var thumbnail: Thumbnail,

    @SerializedName("resourceURI")
    var resourceURI: String,

    @SerializedName("comics")
    var comics: Comics,

    @SerializedName("series")
    var series: Series,

    @SerializedName("stories")
    var stories: Stories,

    @SerializedName("events")
    var events: Events,

    @SerializedName("urls")
    var urls: List<Url>*/

){

    @JvmName("getName1")
    fun getName() = name

    fun getDescricao() = description

    override fun toString(): String {
        return "ID: $id \n" +
                "Nome: $name \n" +
                "Descrição: $description \n"

    }

}