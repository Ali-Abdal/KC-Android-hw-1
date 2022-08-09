package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calc, erace;
    EditText n1, n2, n3, n4;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = findViewById(R.id.Bcalc);
        erace = findViewById(R.id.Berace);
        n1 = findViewById(R.id.Etxtq); //15%//
        n2 = findViewById(R.id.Etxth); //25%//
        n3 = findViewById(R.id.Etxtm); //30%//
        n4 = findViewById(R.id.Etxtf); //30%//
        total = findViewById(R.id.Txtresult);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(n1.getText().toString());
                int num2 = Integer.parseInt(n2.getText().toString());
                int num3 = Integer.parseInt(n3.getText().toString());
                int num4 = Integer.parseInt(n4.getText().toString());
                int result = (num1*15/100) + (num2*25/100) + (num3*30/100) + (num4*30/100);
                total.setText(String.valueOf(result));


            }

        });
        erace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total.setText("");
                n1.setText("");
                n2.setText("");
                n3.setText("");
                n4.setText("");

            }
        });
    }
}