package com.schandorf.elmenorah.POJO;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;


public class VideosList extends RealmObject{

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("video_id")
	private String videoId;

	@SerializedName("category")
	private String videoCategory;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	public String getVideoId(){
		return videoId;
	}

	public String getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}

    @Override
    public String toString() {
        return "VideosList{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", videoId='" + videoId + '\'' +
                ", videoCategory='" + videoCategory + '\'' +
                '}';
    }
}