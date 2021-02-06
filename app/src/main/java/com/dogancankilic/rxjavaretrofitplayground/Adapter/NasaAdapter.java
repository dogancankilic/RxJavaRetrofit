package com.dogancankilic.rxjavaretrofitplayground.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dogancankilic.rxjavaretrofitplayground.Model.Model;
import com.dogancankilic.rxjavaretrofitplayground.R;

public class NasaAdapter extends RecyclerView.Adapter<NasaAdapter.JsonPlaceholderRepoViewHolder> {

    private Model apodModel=new Model();

    Context context;

    public NasaAdapter(Context context) {
        this.context = context;
    }

    public void setAPod(Model apodModel) {
        this.apodModel=apodModel;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public JsonPlaceholderRepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apod_row, parent,false);
        return new NasaAdapter.JsonPlaceholderRepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NasaAdapter.JsonPlaceholderRepoViewHolder holder, int position) {
        Model item = apodModel;

        holder.title.setText(item.getTitle());
        holder.explanation.setText(item.getExplanation());

        Glide.with(context)
                .load(item.getHdurl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.photo_view);


    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public static class JsonPlaceholderRepoViewHolder extends RecyclerView.ViewHolder {

        private TextView title,explanation;
        ImageView photo_view;
        public JsonPlaceholderRepoViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title_text);
            explanation = (TextView) view.findViewById(R.id.explanation_text);
            photo_view =(ImageView) view.findViewById(R.id.photo);

        }


    }
}