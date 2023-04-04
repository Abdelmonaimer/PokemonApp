package com.example.pokemonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.pokemonapp.databinding.ActivityPikachuBinding;
import com.example.pokemonapp.models.Pokemon;
import com.example.pokemonapp.models.PokemonRequest;
import com.example.pokemonapp.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "POKEDEX";
    private Retrofit retrofit;

    private ImageView imageView;

    private RecyclerView recyclerView;
    private  ListaPokemonAdapter listaPokemonAdapter;

    private int offset;

    private boolean toChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);
        listaPokemonAdapter = new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0){
                    int visibleItemcount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                    if(toChange){
                        if((visibleItemcount + pastVisibleItems) >= totalItemCount){
                            Log.i(TAG, "final.");

                            toChange = false;
                            offset += 20;
                            takeData(offset);
                        }
                    }
                }
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerClickListener(MainActivity2.this, recyclerView, new RecyclerClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity2.this, Pikachu.class);
                intent.putExtra("index", String.valueOf(position+1));

                imageView = findViewById(position+1);

                GradientDrawable drawable = (GradientDrawable) imageView.getBackground();

                intent.putExtra("color", String.valueOf(drawable.getColor().getDefaultColor()));
                Log.e(TAG," color1 : " +drawable.getColor().getDefaultColor());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();

        toChange = true;
        offset = 0;
        takeData(offset);
    }
    private void takeData(int offset){
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonRequest> pokemonRequestCall = service.obtenirPokemonListe(20, offset);

        pokemonRequestCall.enqueue(new Callback<PokemonRequest>() {
            @Override
            public void onResponse(Call<PokemonRequest> call, Response<PokemonRequest> response) {
                toChange = true;
                if (response.isSuccessful()){
                    PokemonRequest pokemonRequest = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonRequest.getResults();

                    listaPokemonAdapter.addPokemon(listaPokemon);

                } else{
                    Log.e(TAG, "onResponse: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRequest> call, Throwable t) {
                toChange = true;
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });

    }
}