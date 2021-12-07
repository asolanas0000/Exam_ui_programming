package com.example.exam_ui_programming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    private static final int OPTION_PAY = 0;
    TextView price_xml;
    EditText card_number, card_date, card_cvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        getSupportActionBar().hide();
        //getSupportActionBar().setTitle("Searching trips");

        card_cvc = (EditText) findViewById(R.id.card_cvc);
        card_date = (EditText)findViewById(R.id.card_date);
        card_number = (EditText)findViewById(R.id.card_number);

        Bundle extra = getIntent().getExtras();
        String time = extra.getString("time");
        String date = extra.getString("date");
        String duration = extra.getString("duration");
        String price = extra.getString("price");
        String from = extra.getString("from");
        String to = extra.getString("to");
        String seat = extra.getString("seat");

        price_xml = (TextView)findViewById(R.id.price);
        price_xml.setText(price);

        // Pay button
        Button payButton = (Button) findViewById(R.id.pay_button);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(card_cvc.getText().toString().isEmpty()) {
                    card_cvc.setError("Insert card CVC. It can't be empty");
                } else if(card_date.getText().toString().isEmpty()) {
                    card_date.setError("Insert card expiry date. It can't be empty");
                } else if(card_number.getText().toString().isEmpty()) {
                    card_number.setError("Insert card number. It can't be empty");
                } else {
                    Bundle extra = new Bundle();
                    extra.putString("time", time);
                    extra.putString("date", date);
                    extra.putString("duration", duration);
                    extra.putString("from", from);
                    extra.putString("to", to);
                    extra.putString("seat", seat);
                    Intent intent = new Intent (v.getContext(), Ticket_Bought.class);
                    intent.putExtras(extra);
                    startActivityForResult(intent, OPTION_PAY);
                }
            }
        });


    }

}
