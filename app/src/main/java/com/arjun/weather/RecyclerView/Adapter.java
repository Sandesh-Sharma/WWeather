package com.arjun.weather.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arjun.weather.Model.FiveDaysWeather;
import com.arjun.weather.Model.ItemHourly;
import com.arjun.weather.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    FiveDaysWeather fiveDaysWeather;
    Context context;

    public Adapter(FiveDaysWeather itemHourlyList,Context context){
        this.fiveDaysWeather = itemHourlyList;
        this.context = context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather,
                parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: "+fiveDaysWeather.getList().size());
        Glide.with(context)
                .load("https://openweathermap.org/img/wn/10d@2x.png")
                .into(holder.icon1);
        holder.tempmin.setText(String.valueOf(fiveDaysWeather.getList().get(position).getMain().getTempMin()));
        holder.tempmax.setText(String.valueOf(fiveDaysWeather.getList().get(position).getMain().getTempMax()));
    }

    @Override
    public int getItemCount() {
        return fiveDaysWeather.getList().size();
    }

     static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView icon1;
            TextView tempmax,tempmin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon1 = itemView.findViewById(R.id.weather_image_view);
            tempmax = itemView.findViewById(R.id.max_temp_text_view);
            tempmin = itemView.findViewById(R.id.min_temp_text_view);
        }
    }
}
