package com.example.my_motivation.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface API  {
    @GET
    suspend fun getResponse():

}
const val BASE_URL = "https://public.syntax-institut.de/apps/batch4/Marcel/data.json"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
object MotivationApi {
    val retrofitService: API by lazy { retrofit.create(API::class.java) }
}
