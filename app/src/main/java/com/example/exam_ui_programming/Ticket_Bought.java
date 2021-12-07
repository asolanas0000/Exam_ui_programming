package com.example.exam_ui_programming;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class Ticket_Bought extends AppCompatActivity {

    private static final int OPTION_HOME = 0;
    TextView from;
    TextView to;
    TextView times;
    TextView date_xml;
    TextView seat_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_bought);
        getSupportActionBar().hide();
        //getSupportActionBar().setTitle("Home");

        Bundle extra = getIntent().getExtras();
        String time = extra.getString("time");
        String date = extra.getString("date");
        String duration = extra.getString("duration");
        String city1 = extra.getString("from");
        String city2 = extra.getString("to");
        String seat = extra.getString("seat");


        from = (TextView)findViewById(R.id.travel_from);
        to = (TextView)findViewById(R.id.travel_to);
        times = (TextView)findViewById(R.id.times);
        date_xml = (TextView)findViewById(R.id.dates);
        seat_xml = (TextView)findViewById(R.id.seat);

        from.setText(city1);
        to.setText(city2);
        times.setText(time);
        date_xml.setText(date);
        seat_xml.setText(seat);

        // Download button
        Button downloadButton = (Button) findViewById(R.id.download_button);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new SweetAlertDialog(Ticket_Bought.this,SweetAlertDialog.SUCCESS_TYPE).setTitleText("¡Download complete!")
                                .setConfirmText("OK")
                                .setConfirmClickListener(null)
                                .show();
                    }
                },500);
            }
        });


        // Start button
        Button homeButton = (Button) findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Home.class);
                startActivityForResult(intent, OPTION_HOME);
            }
        });

    }
}