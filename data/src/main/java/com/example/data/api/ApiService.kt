package com.example.data.api

import com.example.domain.models.Coach_Model
import com.example.domain.models.Consumer_Model
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("/check_coach")
    suspend fun check_coach(@Field("Login")Login:String,@Field("Password")Password:String  ): Response<ArrayList<Coach_Model>>

    @FormUrlEncoded
    @POST("/check_customers")
    suspend fun check_customers(@Field("Login")Login:String,@Field("Password")Password:String  ): Response<ArrayList<Consumer_Model>>


    @FormUrlEncoded
    @POST("/coach_by_login")
    fun Get_coach_info(@Field("Login")Login:String  ): Response<ArrayList<Coach_Model>>

    @FormUrlEncoded
    @POST("/add_coach")
    suspend fun incert_coach(
        @Field("Patronymic")Patronymic:String,
        @Field("Login")Login:String,
        @Field("Name")Name:String,
        @Field("Surname")Surname:String,
        @Field("Password")Password:String,
        @Field("About_myself")About_myself:String,
        @Field("Experience")Experience:Int,
        @Field("Accreditation_level")Accreditation_level:String) : String

    @FormUrlEncoded
    @POST("/add_customers")
    suspend fun incert_consumer(
        @Field("Login")Login:String,
        @Field("Name")Name:String,
        @Field("Surname")Surname:String,
        @Field("Password")Password:String,
        @Field("Age")Age:Int): String

    @GET("/coach")
    fun getData(): Response<ArrayList<Coach_Model>>

    @GET("/coach")
    suspend fun coach_coach_info(): Response<ArrayList<Coach_Model>>
    @GET("/customers")
    suspend fun Get_customers_info(): Response<ArrayList<Consumer_Model>>
}