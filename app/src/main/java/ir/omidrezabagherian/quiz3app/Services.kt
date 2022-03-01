package ir.omidrezabagherian.testapplicationfive.Data

import android.graphics.Bitmap
import ir.omidrezabagherian.quiz3app.CreateUser
import ir.omidrezabagherian.quiz3app.ImageUpload
import ir.omidrezabagherian.quiz3app.ListUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Services {
    @POST("users")
    fun createUser(@Body body: CreateUser): Call<String>

    @POST("users/token/image")
    fun imageUrl(@Path("token") token:String, @Path("image") image: Bitmap): Call<ImageUpload>

    @GET("/users")
    fun loadUser():Call<List<ListUser>>


}