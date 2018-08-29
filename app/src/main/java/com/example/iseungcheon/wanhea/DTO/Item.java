package com.example.iseungcheon.wanhea.DTO;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {

    @SerializedName("img_url")
    private String img_url;
    @SerializedName("item_name")
    private String name;
    @SerializedName("item_uid")
    private int item_uid;
    @SerializedName("material")
    private String material;
    @SerializedName("size")
    private String size;
    @SerializedName("patternurl")
    private String patternurl;
    @SerializedName("material_uid")
    private String material_uid;
    @SerializedName("sub_item")
    private String sub_item;
    @SerializedName("sub_num")
    private String sub_num;
    @SerializedName("price")
    private int price;
    @SerializedName("category")
    private String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getItem_uid() {
        return item_uid;
    }

    public void setItem_uid(int item_uid) {
        this.item_uid = item_uid;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPatternurl() {
        return patternurl;
    }

    public void setPatternurl(String patternurl) {
        this.patternurl = patternurl;
    }

    public String getMaterial_uid() {
        return material_uid;
    }

    public void setMaterial_uid(String material_uid) {
        this.material_uid = material_uid;
    }

    public String getSub_item() {
        return sub_item;
    }

    public void setSub_item(String sub_item) {
        this.sub_item = sub_item;
    }

    public String getSub_num() {
        return sub_num;
    }

    public void setSub_num(String sub_num) {
        this.sub_num = sub_num;
    }
}
