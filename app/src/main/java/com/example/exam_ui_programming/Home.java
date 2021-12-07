package com.example.exam_ui_programming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    private EditText travel1;
    private EditText travel2;
    private EditText travel3;
    private static final int OPTION_SEARCH = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getSupportActionBar().hide();
        //getSupportActionBar().setTitle("Home");

        //EDIT TEXT 1
        travel1 = (EditText) findViewById(R.id.travel_from);
        //EDIT TEXT 2
        travel2 = (EditText) findViewById(R.id.travel_to);
        // edit text 3
        travel3 = (EditText) findViewById(R.id.date_user);


        // Start button
        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(travel1.getText().toString().isEmpty()) {
                    travel1.setError("Choose an origin city. It can't be empty");
                } else if(travel2.getText().toString().isEmpty()) {
                    travel2.setError("Choose a destination. It can't be empty");
                } else if(travel3.getText().toString().isEmpty()) {
                    travel3.setError("Choose a date. It can't be empty");
                } else {
                    Bundle extra = new Bundle();
                    extra.putString("city1", travel1.getText().toString());
                    extra.putString("city2", travel2.getText().toString());
                    extra.putString("date", travel3.getText().toString());
                    Intent intent = new Intent (v.getContext(), Search_trips.class);
                    intent.putExtras(extra);
                    startActivityForResult(intent, OPTION_SEARCH);
                }

            }
        });

    }
}