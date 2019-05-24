package com.schandorf.elmenorah;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SCHANDORF on 11-Feb-18.
 */

public class RetrofitService {

    private static final String BASE_URL = "http://elmenora.keyzmusicacademy.com/";
    private static final String LOCAL_IP = "http://169.254.246.204/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
