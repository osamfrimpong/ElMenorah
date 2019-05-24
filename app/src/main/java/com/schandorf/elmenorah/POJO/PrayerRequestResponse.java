package com.schandorf.elmenorah.POJO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrayerRequestResponse{
  @SerializedName("response")
  @Expose
  private Boolean response;
  public void setResponse(Boolean response){
   this.response=response;
  }
  public Boolean getResponse(){
   return response;
  }
}