package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

public class Best_Stores extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best__stores);

        scroll =(ScrollView) findViewById(R.id.storelayout);

        this.setTitle("Best Stores");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final Spinner source = findViewById(R.id.student);
        String[] sou = new String[]{"Choose Airport","Indira Gandhi International Airport","Chatrapathi Sivaji International Airport","Chennai International Airport"};
        ArrayAdapter<String> sectionadap = new ArrayAdapter<String>(Best_Stores.this,R.layout.spinner_item,sou);
        sectionadap.setDropDownViewResource(R.layout.spinner_item);
        source.setAdapter(sectionadap);


        source.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(source.getSelectedItem().toString().equals("Choose Airport")) {

               } else {
                   scroll.setVisibility(View.VISIBLE);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        findViewById(R.id.kfcac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Best_Stores.this,KFCActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.mcdonalds).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Best_Stores.this,MdDonalds.class);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
