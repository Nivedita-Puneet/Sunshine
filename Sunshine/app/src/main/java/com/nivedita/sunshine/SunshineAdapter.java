package com.nivedita.sunshine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nivedita.sunshine.model.pojo.WeatherList;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter class to hold the list of weather list items.
 */

public class SunshineAdapter extends RecyclerView.Adapter<SunshineAdapter.WeatherReportAdapterViewHolder> {

    private List<String> mWeatherData;
    private Context context;
    private WeatherReportAdapterOnclickHandler weatherReportAdapterOnclickHandler;

    public SunshineAdapter(Context context,
                           WeatherReportAdapterOnclickHandler weatherReportAdapterOnclickHandler) {

        this.context = context;
        this.weatherReportAdapterOnclickHandler = weatherReportAdapterOnclickHandler;
        mWeatherData = new ArrayList<>();

    }

    public interface WeatherReportAdapterOnclickHandler {

        void clickListener(String weatherForToday);
    }

    public class WeatherReportAdapterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public final TextView mWeatherTextView;

        WeatherReportAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int adapterPosition = getAdapterPosition();
            SunshineAdapter.this.weatherReportAdapterOnclickHandler.
                    clickListener(mWeatherData.get(adapterPosition));
        }
    }

    @NonNull
    @Override
    public SunshineAdapter.WeatherReportAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int id = R.layout.sunshine_item;
        boolean shouldAttachToParentImmediately = false;

        View view = LayoutInflater.from(context).inflate(id, parent, shouldAttachToParentImmediately);
        return new WeatherReportAdapterViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull SunshineAdapter.WeatherReportAdapterViewHolder holder, int position) {

        holder.mWeatherTextView.setText(mWeatherData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null) {
            return 0;
        } else {

            return mWeatherData.size();
        }


    }

    public void setmWeatherData(List<String> mWeatherData) {

        this.mWeatherData = mWeatherData;
        notifyDataSetChanged();
    }

}
