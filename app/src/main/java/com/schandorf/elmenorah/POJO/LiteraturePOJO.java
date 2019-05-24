package com.schandorf.elmenorah.POJO;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;


public class LiteraturePOJO extends RealmObject{

	@SerializedName("image")
	private String image;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("category")
	private String category;

	@SerializedName("content")
	private String content;

	@SerializedName("date_added")
    private String dateAdded;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
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

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "LiteraturePOJO{" +
                "image='" + image + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                '}';
    }
}