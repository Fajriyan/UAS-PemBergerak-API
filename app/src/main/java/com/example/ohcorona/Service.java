package com.example.ohcorona;

import com.example.ohcorona.Model.ModelDataIndo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("indonesia")
    Call<List<ModelDataIndo>> getData();

}
