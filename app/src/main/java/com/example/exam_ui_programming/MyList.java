package com.example.exam_ui_programming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

class MyListAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final String dates;
        private final String[] times;
        private final String[] durations;
        private final String[] prices;

        public MyListAdapter(Activity context, String dates,String[] times, String[] durations, String[] prices) {
            super(context, R.layout.list_rows, times);
            // TODO Auto-generated constructor stub

            this.context=context;
            this.dates=dates;
            this.times=times;
            this.durations=durations;
            this.prices=prices;

        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.list_rows, null,true);

            TextView dateText = (TextView) rowView.findViewById(R.id.date);
            TextView timeText = (TextView) rowView.findViewById(R.id.time);
            TextView durationText = (TextView) rowView.findViewById(R.id.duration);
            TextView priceText = (TextView) rowView.findViewById(R.id.price);

            dateText.setText(dates);
            timeText.setText(times[position]);
            durationText.setText(durations[position]);
            priceText.setText(prices[position]);

            return rowView;

        };
}

