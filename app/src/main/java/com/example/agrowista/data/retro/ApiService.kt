package com.example.agrowista.data.retro

import com.example.agrowista.data.response.AccountResponse
import com.example.agrowista.data.response.AuthResponse
import com.example.agrowista.data.response.HomeResponse
import com.example.agrowista.data.response.UlasanResponse
import com.example.agrowista.data.response.WisataResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirmPassword") confirmPassword: String,
        @Field("age") age: Int,
        @Field("gender") gender: String,
        @Field("occupation") occupation: String,
        @Field("origin") origin: String,
    ): AuthResponse

    @GET("users/home")
    suspend fun home(): HomeResponse

    @GET("users/profile/{id}")
    suspend fun profile(@Path("id") id: String): AccountResponse

    @GET("users/jenis-wisata")
    suspend fun jenisWisata(): WisataResponse

    @FormUrlEncoded
    @POST("kirim-ulasan")
    suspend fun sendReview(
        @Field("userId") userId: Int,
        @Field("jenis_wisata") jenis_wisata: Int,
        @Field("ulasan") ulasan: String
    ): UlasanResponse

    @FormUrlEncoded
    @POST("kirim-ulasan/guest")
    suspend fun sendReviewGuest(
        @Field("nama") nama: String?,
        @Field("umur") umur: Int,
        @Field("asal") asal: String,
        @Field("pekerjaan") pekerjaan: String,
        @Field("jenis_kelamin") jenis_kelamin: String,
        @Field("jenis_wisata") jenis_wisata: Int,
        @Field("ulasan") ulasan: String
    ): UlasanResponse

}