package com.example.iseungcheon.wanhea.DTO;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("store_id")
    private int store_id;
    @SerializedName("content")
    private String content;
    @SerializedName("usr_id")
    private String usr_id;
    @SerializedName("score")
    private int score;
    @SerializedName("img_url")
    private String img_url;

    public Review(int store_id, String content, String usr_id, int score, String img_url) {
        this.store_id = store_id;
        this.content = content;
        this.usr_id = usr_id;
        this.score = score;
        this.img_url = img_url;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
