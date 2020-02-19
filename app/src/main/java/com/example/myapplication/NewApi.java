package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//import org.json.JSONObject;


public class NewApi  {

    String status;

    List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public class Result{
        @SerializedName("title")
        String title;

        @SerializedName("abstract")
        String description;

        List<Multimedia> multimedia;

        public List<Multimedia> getMultimedia() {
            return multimedia;
        }


        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public class Multimedia {

            @SerializedName("url")
            String imageUrl;

            public String getImageUrlUrl() {
                return imageUrl;
            }
        }
    }


}

