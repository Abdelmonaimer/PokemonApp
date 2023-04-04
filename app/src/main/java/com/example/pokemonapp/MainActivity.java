package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton bulbasaur;
    ImageButton charmander;
    ImageButton squirtle;
    ImageButton pikachu;
    private TextView chartext;
    private TextView bulbatext;
    private TextView squirtletext;
    private TextView pikachutext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulbasaur = findViewById(R.id.imageButton);
        charmander = findViewById(R.id.imageButton2);
        chartext = findViewById(R.id.textView3);
        bulbatext = findViewById(R.id.textView4);
        squirtle = findViewById(R.id.imageButton4);
        squirtletext = findViewById(R.id.squirtleTxt);
        pikachu = findViewById(R.id.imageButton9);
        pikachutext = findViewById(R.id.pikachuTxt);


        bulbasaur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Bulbaraus.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(bulbasaur,"bulbasaurImageTransition");
                pairs[1] = new Pair<View, String>(bulbatext,"bulbasaurTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

                startActivity(intent,options.toBundle());
            }
        });
        charmander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Charmander.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(charmander,"charmanderImageTransition");
                pairs[1] = new Pair<View, String>(chartext,"charmanderTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

                startActivity(intent, options.toBundle());
            }
        });
        squirtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivity2.class);



                //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);

                startActivity(intent);
            }
        });
        pikachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Pikachu.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(pikachu,"pikachuImageTransition");
                pairs[1] = new Pair<View, String>(pikachutext,"pikachuTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

                startActivity(intent, options.toBundle());
            }
        });
    }
}