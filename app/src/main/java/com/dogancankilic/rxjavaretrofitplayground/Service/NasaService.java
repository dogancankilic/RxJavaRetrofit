package com.dogancankilic.rxjavaretrofitplayground.Service;

import com.dogancankilic.rxjavaretrofitplayground.Model.Model;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaService {

    @GET("apod")
    Single<Model> getApod(@Query("api_key") String api_key);
}
