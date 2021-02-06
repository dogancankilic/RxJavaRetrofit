package com.dogancankilic.rxjavaretrofitplayground.Client;

import com.dogancankilic.rxjavaretrofitplayground.Model.Model;
import com.dogancankilic.rxjavaretrofitplayground.Service.NasaService;
import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NasaClient {

    public static final String BASE_URL = "https://api.nasa.gov/planetary/";

    private static NasaClient instance;
    private NasaService nasaService;

    private OkHttpClient provideOkHttpClient()
    {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient().newBuilder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000,TimeUnit.MILLISECONDS)
                .addInterceptor(logging)
                .build();
    }

    private NasaClient() {
        final Gson gson = new Gson();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(provideOkHttpClient())
                .build();

        nasaService =retrofit.create(NasaService.class);





    }

    public static NasaClient getInstance() {
        if (instance==null) {
            instance =new NasaClient();
        }
        return instance;
    }

    public Single<Model> getApod(@NonNull String apikey) {
        return nasaService.getApod(apikey);
    }
}
