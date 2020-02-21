package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {

    LinearLayout baggage,beststore,flightbook,transbook,timepredict,visualisation,hotels,tour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        baggage = (LinearLayout)findViewById(R.id.baggagetracker);
        beststore=(LinearLayout)findViewById(R.id.stores);
        flightbook=(LinearLayout)findViewById(R.id.flights);
        transbook=(LinearLayout)findViewById(R.id.transport);
        timepredict=(LinearLayout)findViewById(R.id.timeprediction);
        visualisation=(LinearLayout)findViewById(R.id.visualisation);
        hotels=(LinearLayout)findViewById(R.id.hotels);
        tour=(LinearLayout)findViewById(R.id.quicktour);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        baggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,Baggage_Tracker.class);
                startActivity(i);
            }
        });
        beststore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,Best_Stores.class);
                startActivity(i);
            }
        });
        flightbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,Book_Flight.class);
                startActivity(i);
            }
        });
        transbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,Book_Transport.class);
                startActivity(i);
            }
        });
        timepredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,Google_Maps.class);
                startActivity(i);
            }
        });
        visualisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,ThreeDimensional.class);
                startActivity(i);
            }
        });

        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,Book_Hotel.class);
                startActivity(i);
            }
        });
        tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this,TourActivity.class);
                startActivity(i);
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
