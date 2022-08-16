package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import javax.security.auth.login.LoginException;

public class Mainpage extends AppCompatActivity {
    Button rock , paper , scissors , reset;
    TextView result,playername, playertxt, aitxt, noti;
    ImageView ai, player;
    int plyerscore = 0 , aiscore = 0;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        rock = findViewById(R.id.btnrock);
        paper = findViewById(R.id.btnpaper);
        scissors = findViewById(R.id.btnscissors);
        reset = findViewById(R.id.btnreset);
        result = findViewById(R.id.txtresult);
        ai = findViewById(R.id.imgAI);
        player = findViewById(R.id.imgplyer);
        playername = findViewById(R.id.txtplayername);
        playertxt = findViewById(R.id.txtplayerscore);
        aitxt = findViewById(R.id.txtaiscore);
        noti = findViewById(R.id.txtnoti);


        random = new Random();
        Bundle act1 = getIntent().getExtras();
        String name = act1.getString("name");
        playername.setText(name);

        playertxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(playertxt.getText().toString().equals("3")){
                    playertxt.setText("0");
                    aitxt.setText("0");
                    hamad();
                    plyerscore = 0;
                    player.setImageResource(R.drawable.screenshot_2022_08_16_135326);
                    ai.setImageResource(R.drawable.screenshot_2022_08_16_135326);
                    noti.setText("");
                    Toast.makeText(Mainpage.this, "You won", Toast.LENGTH_SHORT).show();
                }
            }
        });

        aitxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(aitxt.getText().toString().equals("3")){
                    playertxt.setText("0");
                    aitxt.setText("0");
                    plyerscore = 0;
                    aiscore= 0;
                    player.setImageResource(R.drawable.screenshot_2022_08_16_135326);
                    ai.setImageResource(R.drawable.screenshot_2022_08_16_135326);
                    noti.setText("");
                    Toast.makeText(Mainpage.this, "You lost", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        }

    public void Rock(View view) {
        int playerselction = 1;
        game(playerselction);

    }

    public void Paper(View view) {
        int playerselction = 2;
        game(playerselction);

    }
    public void Scissors(View view) {
        int playerselction = 3;
        game(playerselction);

    }

    public void erase(View view) {
        playertxt.setText("0");
        aitxt.setText("0");
        plyerscore = 0;
        aiscore= 0;
        player.setImageResource(R.drawable.screenshot_2022_08_16_135326);
        ai.setImageResource(R.drawable.screenshot_2022_08_16_135326);
        noti.setText("");
        setscore(plyerscore , aiscore);

    }

    private void game(int playerselction) {

        int low = 1;
        int high = 3;
        int aiselctoin = random.nextInt(high) + low;

        if (playerselction == aiselctoin) {
            //tie
            noti.setText("Seems like you can compete");

             }
        else if ((playerselction - aiselctoin) % 3 == 1) {
            //win
            plyerscore++;
            noti.setText("Uh, lucky !");
            }
        else if(playerselction == 1 && aiselctoin == 3){
            plyerscore++;
            noti.setText("Uh, lucky !");
        }

        else {
            //lose
            aiscore++;
            noti.setText("Boring, predictable");
        }
        switch (playerselction) {
            case 1:
                player.setImageResource(R.drawable.rock_left);
                break;
            case 2:
                player.setImageResource(R.drawable.paper_left);
                break;
            case 3:
                player.setImageResource(R.drawable.scissors_left);
                break;

        }
        switch (aiselctoin) {
            case 1:
                ai.setImageResource(R.drawable.rock_right);
                break;
            case 2:
                ai.setImageResource(R.drawable.paper_right);
                break;
            case 3:
                ai.setImageResource(R.drawable.scissors_right);
                break;

        }
        setscore(plyerscore, aiscore);
    }
    private void setscore(int plyerscore, int aiscore){
        playertxt.setText(String.valueOf(plyerscore));
        aitxt.setText(String.valueOf(aiscore));
        System.out.println(aiscore);
    }

    private  void hamad(){
        aiscore= 0;


    }

}