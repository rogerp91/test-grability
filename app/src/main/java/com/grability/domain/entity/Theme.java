package com.grability.domain.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rogerp91 on 19/01/17.
 */

public class Theme {

    @SerializedName("kind")
    private String kind;

    @SerializedName("data")
    private Data data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}