package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

public class ThreeDimensional extends AppCompatActivity {

    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_dimensional);

        scrollView = (ScrollView)findViewById(R.id.scrollayout);

        this.setTitle("3D Visualisation");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        final Spinner source = findViewById(R.id.student);
        String[] sou = new String[]{"Choose Airport","Indira Gandhi International Airport","Kempegowda International","Chatrapathi Sivaji International Airport","Chennai International Airport"};
        ArrayAdapter<String> sectionadap = new ArrayAdapter<String >(ThreeDimensional.this,R.layout.spinner_item,sou);
        sectionadap.setDropDownViewResource(R.layout.spinner_item);
        source.setAdapter(sectionadap);

        source.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(source.getSelectedItem().toString().equals("Choose Airport")) {}
                else {
                   scrollView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
