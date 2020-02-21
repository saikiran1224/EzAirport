package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Book_Flight extends AppCompatActivity {

    LinearLayout show,book,make,yatra;
    TextView clickme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__flight);

         clickme = (TextView)findViewById(R.id.click);
         show=(LinearLayout)findViewById(R.id.showother);
         book=(LinearLayout)findViewById(R.id.book);
         make=(LinearLayout)findViewById(R.id.makemytrip);
         yatra=(LinearLayout)findViewById(R.id.yatra);

         show.setEnabled(false);
         show.setVisibility(View.INVISIBLE);

         if(getSupportActionBar()!= null) {
             getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         }

         findViewById(R.id.book).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Book_Flight.this,FlightBooking.class);
                 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 startActivity(intent);
             }
         });

         clickme.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 show.setVisibility(View.VISIBLE);
             }
         });

        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Book_Flight.this,MakemyTrip.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        yatra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Book_Flight.this,Yatra.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

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
