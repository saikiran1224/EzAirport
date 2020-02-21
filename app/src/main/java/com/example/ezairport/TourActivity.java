package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class TourActivity extends AppCompatActivity {

    ImageView sad,sleep,happy,angry,right,wrong,right1,wrong1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        this.setTitle("Quick Tour");

        sad=(ImageView)findViewById(R.id.sad);
        sleep=(ImageView)findViewById(R.id.sleep);
        happy=(ImageView)findViewById(R.id.happy);
        angry=(ImageView)findViewById(R.id.angry);
        right=(ImageView)findViewById(R.id.right);
        wrong=(ImageView)findViewById(R.id.wrong);

        right1=(ImageView)findViewById(R.id.right1);
        wrong1=(ImageView)findViewById(R.id.wrong1);

        sad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sleep.setVisibility(View.INVISIBLE);
                happy.setVisibility(View.INVISIBLE);
                angry.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        sleep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sad.setVisibility(View.INVISIBLE);
                happy.setVisibility(View.INVISIBLE);
                angry.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        happy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sleep.setVisibility(View.INVISIBLE);
                sad.setVisibility(View.INVISIBLE);
                angry.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        angry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sleep.setVisibility(View.INVISIBLE);
                happy.setVisibility(View.INVISIBLE);
                sad.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                wrong.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        wrong.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                right.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        right1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                wrong1.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        wrong1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                right1.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AfterTour.class));
            }
        });
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
