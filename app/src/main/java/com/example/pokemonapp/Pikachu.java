package com.example.pokemonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.pokemonapp.databinding.ActivityPikachuBinding;
import com.example.pokemonapp.models.Pokemon;
import com.example.pokemonapp.pokeapi.PokeapiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pikachu extends AppCompatActivity {
    ActivityPikachuBinding binding;
    private Retrofit retrofit;
    private static final String TAG = "POKEDEX";
    private String index;
    private ImageView imageView;
    private TextView textView;
    private TextView textView6;
    private TextView textView8;
    private int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPikachuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        index = getIntent().getStringExtra("index");
        Log.e(TAG," hi : " );


        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        takeData();
        getDonnee();
        startAnimationCounter_HP(0,50);
        startAnimationCounter_ATK(0,70);
        startAnimationCounter_DEF(0,40);
        startAnimationCounter_SPD(0,90);
        startAnimationCounter_EXP(0,45);



    }
    private  void getDonnee(){
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<Pokemon> pokemonRequestCall = service.getPokemon(index);
        pokemonRequestCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                textView = findViewById(R.id.textView2);
                imageView = findViewById(R.id.imageView);
                textView6 = findViewById(R.id.textView6);
                textView8 = findViewById(R.id.textView8);
                Pokemon pokemonRequest = response.body();
                textView.setText(pokemonRequest.getName());

                Glide.with(Pikachu.this)
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+index+".png")
                        .into(imageView);
                textView6.setText(pokemonRequest.getWeight() + " KG");
                textView8.setText(pokemonRequest.getHeight() + " FT");
                Log.e(TAG," hello ? : " );

                GradientDrawable drawable = new GradientDrawable();
                color = Integer.parseInt(getIntent().getStringExtra("color"));
                Log.e(TAG," color : " +color);
                drawable.setColor(color);
                imageView.setBackground(drawable);
                textView.setTextColor(color);
                textView.setAllCaps(true);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
        Log.e(TAG," hello ? : " );
    }
    private void setCornerRadii(GradientDrawable drawable, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {
        float[] radii = {topRightRadius, topRightRadius, topLeftRadius, topLeftRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius};
        drawable.setCornerRadii(radii);
    }
    private void takeData(){
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<Pokemon> pokemonRequestCall = service.getPokemon(index);
        pokemonRequestCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {


                Pokemon pokemonRequest = response.body();





                LinearLayout typeLayout = findViewById(R.id.linearLayout);
                List<Type> types = pokemonRequest.getTypes();
                for (int i = 0; i < types.size(); i++) {
                    // Create a new TextView
                    TextView typeTextView = new TextView(Pikachu.this);
                    // Set its properties
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutParams.setMargins(200, 0, 0, 0); // Add 16dp margin to the right
                    typeTextView.setLayoutParams(layoutParams);
                    typeTextView.setWidth(250);
                    typeTextView.setHeight(100);
                    String typeName = types.get(i).getType().getName();
                    typeName = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
                    typeTextView.setText(typeName);
                    // Create a new GradientDrawable with the desired background color and corner radius
                    GradientDrawable bgDrawable = new GradientDrawable();

                    bgDrawable.setColor(TypesColors.getColorByType(typeName));
                    setCornerRadii(bgDrawable, 50, 50, 50, 50); // Set the corner radius to 16dp
                    typeTextView.setBackground(bgDrawable); // Set the background of the TextView
                    typeTextView.setPadding(60, 15, 0, 25);
                    typeTextView.setTextColor(getResources().getColor(R.color.white));
                    typeTextView.setTextSize(18);
                    // Get the type name and set it as the text of the TextView

                    // Add the TextView to the layout
                    typeLayout.addView(typeTextView);
                }





            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                //Log.e(TAG," not working: ");
            }
        });
    }
    public void startAnimationCounter_HP(int start_no,int end_no){
        ValueAnimator animator = ValueAnimator.ofInt(start_no,end_no);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                binding.textView9.setText(valueAnimator.getAnimatedValue().toString()+"");
                binding.progressbar.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
            }
        });
        animator.start();
    }
    public void startAnimationCounter_ATK(int start_no,int end_no){
        ValueAnimator animator = ValueAnimator.ofInt(start_no,end_no);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                binding.textView10.setText(valueAnimator.getAnimatedValue().toString()+"");
                binding.progressbar2.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
            }
        });
        animator.start();
    }
    public void startAnimationCounter_DEF(int start_no,int end_no){
        ValueAnimator animator = ValueAnimator.ofInt(start_no,end_no);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                binding.textView13.setText(valueAnimator.getAnimatedValue().toString()+"");
                binding.progressbar3.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
            }
        });
        animator.start();
    }
    public void startAnimationCounter_SPD(int start_no,int end_no){
        ValueAnimator animator = ValueAnimator.ofInt(start_no,end_no);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                binding.textView15.setText(valueAnimator.getAnimatedValue().toString()+"");
                binding.progressbar4.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
            }
        });
        animator.start();
    }
    public void startAnimationCounter_EXP(int start_no,int end_no){
        ValueAnimator animator = ValueAnimator.ofInt(start_no,end_no);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                binding.textView17.setText(valueAnimator.getAnimatedValue().toString()+"");
                binding.progressbar5.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
            }
        });
        animator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding= null;
    }
}