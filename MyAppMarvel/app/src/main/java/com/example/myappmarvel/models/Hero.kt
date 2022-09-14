package com.example.myappmarvel.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Hero(
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int = -1,

    @Expose
    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String? = null,

    @Expose
    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null,

    @ColumnInfo(name = "isFavorite")
    @SerializedName("isFavorite")
    var isFavorite: Boolean = false,

    @Expose
    @ColumnInfo(name = "modified")
    @SerializedName("modified")
    var modified: String,

    @Expose
    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail,

    /*
    @Expose
    @ColumnInfo(name = "resourceURI")
    @SerializedName("resourceURI")
    var resourceURI: String,*/

    /*
    @Expose
    @ColumnInfo(name = "comics")
    @SerializedName("comics")
    var comics: Comics,*/

    /*
    @Expose
    @ColumnInfo(name = "series")
    @SerializedName("series")
    var series: Series,*/

    /*
    @Expose
    @ColumnInfo(name = "stories")
    @SerializedName("stories")
    var stories: Stories,*/

    /*
    @Expose
    @ColumnInfo(name = "events")
    @SerializedName("events")
    var events: Events,*/

    /*
    @Expose
    @ColumnInfo(name = "urls")
    @SerializedName("urls")
    var urls: List<Url>*/

){

    override fun toString(): String {
        return "ID: $id " +
                "Nome: $name " +
                "Descrição: $description "

    }

}