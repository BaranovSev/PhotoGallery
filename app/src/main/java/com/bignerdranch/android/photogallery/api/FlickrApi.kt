package com.bignerdranch.android.photogallery.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList"+
    "&api_key=33c28f30f4ad401685f973d3ca4865de"+
            "&format=json"+
            "&nojsoncallback=1"+
            "&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponse>

    @GET
    fun fetchUrlBytes(@Url url:String): Call<ResponseBody>
}