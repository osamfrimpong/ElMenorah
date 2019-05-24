package com.schandorf.elmenorah.Fragments;

import com.schandorf.elmenorah.POJO.LiteraturePOJO;
import com.schandorf.elmenorah.POJO.PrayerRequestResponse;
import com.schandorf.elmenorah.POJO.VideosList;
import com.schandorf.elmenorah.RegistrationPOJO;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by SCHANDORF on 11-Feb-18.
 */

public interface RetrofitInterface {

@POST("registration.php")
    @FormUrlEncoded
    Call<RegistrationPOJO> getRegistrationResponse(@FieldMap HashMap<String,String> fields);

    @GET("getvideos.php")
    Call<List<VideosList>> getVideos();

    @GET("cms/api.php")
    Call<List<LiteraturePOJO>> getLiterature();

    @POST("requestprayer.php")
    @FormUrlEncoded
    Call<PrayerRequestResponse> getPrayerRequestResponse(@FieldMap HashMap<String,String> fields);

    @POST("app_register.php")
    @FormUrlEncoded
    Call<RegistrationPOJO> registerForApp(@FieldMap HashMap<String,String> register_details);
}
