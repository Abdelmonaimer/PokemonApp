package com.example.pokemonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;

import com.example.pokemonapp.databinding.ActivityPikachuBinding;
import com.example.pokemonapp.databinding.ActivitySquirtleBinding;

public class Pikachu extends AppCompatActivity {
    ActivityPikachuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPikachuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startAnimationCounter_HP(0,50);
        startAnimationCounter_ATK(0,70);
        startAnimationCounter_DEF(0,40);
        startAnimationCounter_SPD(0,90);
        startAnimationCounter_EXP(0,45);

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