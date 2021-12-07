package com.example.exam_ui_programming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Search_trips extends AppCompatActivity {

    TextView from;
    TextView to;
    private static final int OPTION = 0;

    ListView list;

    String[] times ={
            "15:03 - 22:20","22:43 - 06:48",
            "07:43 - 14:55","12:00 - 18:54",
            "22:00 - 06:00",
    };

    String[] durations ={
            "7h 17min","8h 5min",
            "7h 12min","6h 54min",
            "8h",
    };

    String[] prices ={
            "NOK 988","NOK 988",
            "NOK 985","NOK 803",
            "NOK 410",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_trips);
        getSupportActionBar().hide();
        //getSupportActionBar().setTitle("Searching trips");

        Bundle extra = getIntent().getExtras();
        String city1 = extra.getString("city1");
        String city2 = extra.getString("city2");
        String dates = extra.getString("date");


        from = (TextView)findViewById(R.id.travel_from);
        to = (TextView)findViewById(R.id.travel_to);
        from.setText(city1);
        to.setText(city2);


        MyListAdapter adapter = new MyListAdapter(this, dates, times,durations, prices);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Bundle extra = new Bundle();
                extra.putString("from", city1);
                extra.putString("to", city2);
                extra.putString("time", times[position]);
                extra.putString("date", dates);
                extra.putString("duration", durations[position]);
                extra.putString("price", prices[position]);
                Intent intent = new Intent (view.getContext(), Choose_seats.class);
                intent.putExtras(extra);
                startActivityForResult(intent, OPTION);

            }
        });
    }

}
