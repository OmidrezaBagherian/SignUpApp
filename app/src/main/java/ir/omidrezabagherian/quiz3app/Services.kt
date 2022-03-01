package ir.omidrezabagherian.testapplicationfive.Data

import ir.omidrezabagherian.quiz3app.CreateUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Services {
    @POST("users")
    fun createUser(@Body body: CreateUser): Call<String>

}