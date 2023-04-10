package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton squirtle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        squirtle = findViewById(R.id.imageButton4);



        squirtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivity2.class);



                //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);

                startActivity(intent);
            }
        });
        /*pikachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Pikachu.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(pikachu,"pikachuImageTransition");
                pairs[1] = new Pair<View, String>(pikachutext,"pikachuTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

                startActivity(intent, options.toBundle());
            }
        });*/
    }
}