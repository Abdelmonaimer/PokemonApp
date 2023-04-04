package com.example.pokemonapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokemonapp.models.Pokemon;

import java.util.ArrayList;
import java.util.Random;

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> {

    private SharedPreferences prefs;
    private ArrayList<Pokemon> dataset;
    private Context context;
    public ListaPokemonAdapter(Context context){
        this.context= context;
        dataset = new ArrayList<>();
        prefs = context.getSharedPreferences("pokemon_prefs", Context.MODE_PRIVATE);
    }
    private void setCornerRadii(GradientDrawable drawable, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {
        float[] radii = {topRightRadius, topRightRadius, topLeftRadius, topLeftRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius};
        drawable.setCornerRadii(radii);
    }
    private int getRandomColor(int position) {
        int color = prefs.getInt("color_" + position, Color.WHITE);
            Random rnd = new Random();
                int col1 = rnd.nextInt(256);
                int col2 = rnd.nextInt(256);
                int col3 = rnd.nextInt(256);
                color = Color.rgb(col1, col2, col3);

            prefs.edit().putInt("color_" + position, color).apply();

        return color;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.numbrTextView.setText(p.getName());
        GradientDrawable drawable = new GradientDrawable();
        int randomColor = getRandomColor(position);
       drawable.setShape(GradientDrawable.RECTANGLE);
       setCornerRadii(drawable, 120f, 120f, 120f, 120f);

        drawable.setColor(randomColor);
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+p.getNumber()+".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageViewPic);
        holder.imageViewPic.setId(position+1);
        holder.imageViewPic.setBackgroundDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewPic;
        private TextView numbrTextView;
        public ViewHolder(View itemView) {
            super(itemView);

            imageViewPic = itemView.findViewById(R.id.fotoImageView);
            numbrTextView= itemView.findViewById(R.id.nombreTextView);
        }
    }
}
