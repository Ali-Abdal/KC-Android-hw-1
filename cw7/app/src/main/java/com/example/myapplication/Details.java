package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        Plants delverplant = (Plants) bundle.getSerializable("plant");

        TextView txtnme = findViewById(R.id.txtdetailname);
        TextView txtprce = findViewById(R.id.txtdetailprice);
        TextView txttyp = findViewById(R.id.txtdetailtype);
        TextView txtbio = findViewById(R.id.txtbio);

        ImageView imgplnt = findViewById(R.id.imgdetail);

        txtnme.setText(delverplant.getPlantName());
        txtprce.setText(String.valueOf(delverplant.getPlantPrice()));
        txttyp.setText(delverplant.getPlantName());
        txtbio.setText(delverplant.getPlantbio());
        imgplnt.setImageResource(delverplant.getPlantPhoto());




    }
}