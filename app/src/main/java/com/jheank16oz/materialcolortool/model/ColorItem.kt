package com.jheank16oz.materialcolortool.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ColorItem{
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("primaryColor")
    @Expose
    var primaryColor: String? = null
    @SerializedName("primaryLightColor")
    @Expose
    var primaryLightColor: String? = null
    @SerializedName("primaryDarkColor")
    @Expose
    var primaryDarkColor: String? = null
    @SerializedName("primaryTextColor")
    @Expose
    var primaryTextColor: String? = null
}