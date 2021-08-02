package com.prabhakar.dynamicfragments;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    @SerializedName("image")
    private String image;
    @SerializedName("title")
    private String title;
    @SerializedName("subTitle")
    private String subTitle;


    public String getImage() {
        return image;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }
}