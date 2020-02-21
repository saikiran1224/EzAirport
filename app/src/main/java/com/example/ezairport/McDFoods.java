package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RatingBar;

public class McDFoods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc_dfoods);

        RatingBar ratingBar = (RatingBar)findViewById(R.id.rating);
        ratingBar.setRating(Float.parseFloat("3.8"));

        RatingBar ratingBa = (RatingBar)findViewById(R.id.rating1);
        ratingBa.setRating(Float.parseFloat("5.0"));

        RatingBar ratingB = (RatingBar)findViewById(R.id.rating2);
        ratingB.setRating(Float.parseFloat("4.5"));




        this.setTitle("McD Customer Reviews");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
