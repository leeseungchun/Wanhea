package com.example.iseungcheon.wanhea.DTO;

import java.util.List;

public class BaseRequest<T> {
    List<T> Mdata;

    public List<T> getMdata() {
        return Mdata;
    }

    public void setMdata(List<T> mdata) {
        Mdata = mdata;
    }

    public BaseRequest() {

    }

    public BaseRequest(List<T> mdata) {
        Mdata = mdata;
    }
}
