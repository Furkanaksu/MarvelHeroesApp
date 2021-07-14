package com.furkan.marvel.service

import com.furkan.marvel.utils.Constants.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

abstract class RetrofitInstance {
    companion object {

        val httpBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            //.addInterceptor(interceptor)  /// show all JSON in logCat
        var mClient = httpBuilder.build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create()) //json reesponse değil encrypted plain text geldiği için bunu ekledim
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(mClient)
            .build()

        fun Run() = retrofit.create(RetrofitApi::class.java)
    }
}