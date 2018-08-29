package com.example.iseungcheon.wanhea.DTO;

import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private String location;
    @SerializedName("tel")
    private int tel;
    @SerializedName("product")
    private String product;
    @SerializedName("materials")
    private String materials;
    @SerializedName("img_url")
    private String img_url;
    @SerializedName("id")
    private String id;

    public Store(String name, String location, int tel, String product, String materials, String img_url, String id) {
        this.name = name;
        this.location = location;
        this.tel = tel;
        this.product = product;
        this.materials = materials;
        this.img_url = img_url;
        this.id = id;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
