package com.example.iseungcheon.wanhea.DTO;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private String id;
    @SerializedName("pw")
    private String pw;
    @SerializedName("book_mark")
    private String book_mark;
    @SerializedName("address")
    private String address;
    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private int age;

    public User(String id, String pw, String book_mark, String address, String name, int age) {
        this.id = id;
        this.pw = pw;
        this.book_mark = book_mark;
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getBook_mark() {
        return book_mark;
    }

    public void setBook_mark(String book_mark) {
        this.book_mark = book_mark;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
