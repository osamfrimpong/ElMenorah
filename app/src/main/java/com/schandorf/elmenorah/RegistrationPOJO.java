package com.schandorf.elmenorah;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SCHANDORF on 11-Feb-18.
 */

public class RegistrationPOJO {

    @SerializedName("response")
    private String successResponse;

    public String getSuccessResponse() {
        return successResponse;
    }

    public void setSuccessResponse(String success) {
        this.successResponse = success;
    }

    @Override
    public String toString() {
        return "RegistrationPOJO{" +
                "success=" + successResponse +
                '}';
    }
}
