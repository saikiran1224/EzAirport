package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Prediction_Time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction__time);


        this.setTitle("Prediction Time");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final Spinner source = findViewById(R.id.source);
        String[] sou = new String[]{"Choose Source","Airport","NAD Junction","Gopalapatnam","Gajuwaka","Vizag Steel Plant","Duvvada","Anakapalli"};
        ArrayAdapter<String> sectionadap = new ArrayAdapter<String >(Prediction_Time.this,R.layout.spinner_item,sou);
        sectionadap.setDropDownViewResource(R.layout.spinner_item);
        source.setAdapter(sectionadap);

        final Spinner destin = findViewById(R.id.destination);
        String[] des = new String[]{"Choose Destination","NAD Junction","Airport","Gopalapatnam","Gajuwaka","Vizag Steel Plant","Duvvada","Anakapalli"};
        ArrayAdapter<String> desadap = new ArrayAdapter<String>(Prediction_Time.this,R.layout.spinner_item,des);
        desadap.setDropDownViewResource(R.layout.spinner_item);
        destin.setAdapter(desadap);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Prediction_Time.this,Google_Maps.class);
                startActivity(intent);
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
