package com.farm.mbaabu.grocery;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_interface

{
    @GET("register.php")
    Call<User>perform_registration(@Query("name") String name, @Query("user_name") String user_name, @Query("contact") String contact, @Query("email") String email,@Query("password") String password);

   @GET("login.php")

    Call<User>perform_login(@Query("user_name") String user_name, @Query("password") String password);

}
