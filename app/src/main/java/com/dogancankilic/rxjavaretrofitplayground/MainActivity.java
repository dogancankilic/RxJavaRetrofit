package com.dogancankilic.rxjavaretrofitplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dogancankilic.rxjavaretrofitplayground.Adapter.NasaAdapter;
import com.dogancankilic.rxjavaretrofitplayground.Client.NasaClient;
import com.dogancankilic.rxjavaretrofitplayground.Model.Model;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    NasaAdapter adapter ;
    RecyclerView rec_view;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter= new NasaAdapter(this);
        rec_view =  findViewById(R.id.rec_view);
        rec_view.setAdapter(adapter);
        rec_view.setLayoutManager(new LinearLayoutManager(this));
        
        setupApod();
    }

    private void setupApod() {
        Single<Model> apod = NasaClient.getInstance()
                .getApod(getResources().getString(R.string.api_key))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());



        apod.subscribe(new SingleObserver<Model>() {
            @Override
            public void onSubscribe( Disposable d) {


            }

            @Override
            public void onSuccess( Model model) {
                adapter.setAPod(model);


            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}