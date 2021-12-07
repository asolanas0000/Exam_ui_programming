package com.example.exam_ui_programming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Choose_seats extends AppCompatActivity {

    private static final int OPTION_PAY = 0;
    ImageButton seatA1, seatA2, seatA3, seatB1, seatB2, seatB3, seatC1, seatC2, seatC3;
    TextView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_seats);
        getSupportActionBar().hide();
        //getSupportActionBar().setTitle("Searching trips");

        Bundle extra = getIntent().getExtras();
        String time = extra.getString("time");
        String date = extra.getString("date");
        String duration = extra.getString("duration");
        String price = extra.getString("price");
        String from = extra.getString("from");
        String to = extra.getString("to");

        seatA1 = (ImageButton) findViewById(R.id.seatA1);
        seatA2 = (ImageButton) findViewById(R.id.seatA2);
        seatA3 = (ImageButton) findViewById(R.id.seatA3);
        seatB1 = (ImageButton) findViewById(R.id.seatB1);
        seatB2 = (ImageButton) findViewById(R.id.seatB2);
        seatB3 = (ImageButton) findViewById(R.id.seatB3);
        seatC1 = (ImageButton) findViewById(R.id.seatC1);
        seatC2 = (ImageButton) findViewById(R.id.seatC2);
        seatC3 = (ImageButton) findViewById(R.id.seatC3);
        selected = (TextView) findViewById(R.id.seat_selected);

        final String[] seat_selected = {""};


        seatA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatA1.setImageResource(R.mipmap.seat_taken);
                selected.setText("A1");
                seat_selected[0] = "A1";
            }
        });

        seatA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatA2.setImageResource(R.mipmap.seat_taken);
                selected.setText("A2");
                seat_selected[0] = "A2";
            }
        });

        seatA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatA3.setImageResource(R.mipmap.seat_taken);
                selected.setText("A3");
                seat_selected[0] = "A3";
            }
        });

        seatB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatB1.setImageResource(R.mipmap.seat_taken);
                selected.setText("B1");
                seat_selected[0] = "B1";
            }
        });

        seatB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatB2.setImageResource(R.mipmap.seat_taken);
                selected.setText("B2");
                seat_selected[0] = "B2";
            }
        });

        seatB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatB3.setImageResource(R.mipmap.seat_taken);
                selected.setText("B3");
                seat_selected[0] = "B3";
            }
        });

        seatC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatC1.setImageResource(R.mipmap.seat_taken);
                selected.setText("C1");
                seat_selected[0] = "C1";
            }
        });

        seatC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatC2.setImageResource(R.mipmap.seat_taken);
                selected.setText("C2");
                seat_selected[0] = "C2";
            }
        });

        seatC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanAll();
                seatC3.setImageResource(R.mipmap.seat_taken);
                selected.setText("C3");
                seat_selected[0] = "C3";
            }
        });

        // Pay button
        Button payButton = (Button) findViewById(R.id.pay_button);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected.getText().toString().isEmpty()) {
                    selected.setError("Choose a seat.");
                } else{
                    Bundle extra = new Bundle();
                    extra.putString("time", time);
                    extra.putString("date", date);
                    extra.putString("duration", duration);
                    extra.putString("from", from);
                    extra.putString("to", to);
                    extra.putString("price", price);
                    extra.putString("seat", seat_selected[0]);
                    Intent intent = new Intent (v.getContext(), Payment.class);
                    intent.putExtras(extra);
                    startActivityForResult(intent, OPTION_PAY);
                }

            }
        });
    }


    void cleanAll(){
        seatA1.setImageResource(R.mipmap.seat_free);
        seatA2.setImageResource(R.mipmap.seat_free);
        seatA3.setImageResource(R.mipmap.seat_free);
        seatB1.setImageResource(R.mipmap.seat_free);
        seatB2.setImageResource(R.mipmap.seat_free);
        seatB3.setImageResource(R.mipmap.seat_free);
        seatC1.setImageResource(R.mipmap.seat_free);
        seatC2.setImageResource(R.mipmap.seat_free);
        seatC3.setImageResource(R.mipmap.seat_free);
    }

}
