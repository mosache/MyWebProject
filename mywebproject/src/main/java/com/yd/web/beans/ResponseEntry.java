package com.yd.web.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseEntry<T>{

    private int State = 2;

    private String Msg = "";

    private T data;

    @JsonProperty("State")
    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    @JsonProperty("Msg")
    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseEntry() {
        super();
    }

    public ResponseEntry(int state, String msg, T data) {
        State = state;
        Msg = msg;
        this.data = data;
    }
}
