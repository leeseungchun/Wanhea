package com.example.iseungcheon.wanhea.base;

public class SyncCallback<T> {
    Boolean result;
    T data;

    public SyncCallback(Boolean result, T data) {
        this.result = result;
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


