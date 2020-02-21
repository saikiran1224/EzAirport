package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PlaceOrder extends AppCompatActivity {

    Button send,payment;
    TextView avgtime,pickuptime,cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        this.setTitle("Place Order");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        payment = (Button)findViewById(R.id.button);
        send=(Button)findViewById(R.id.send);

        avgtime = (TextView)findViewById(R.id.avgpreptime);
        pickuptime=(TextView)findViewById(R.id.pickuptime);
        cost=(TextView)findViewById(R.id.amount);






        final Spinner source = findViewById(R.id.source);
        String[] sou = new String[]{"Select Item","Mingles Bucket","Special Bucket","Chicken Wings Bucket","Chicken Starters","Chicken Boneless Strips","Chicken Joints (8 Pieces)","Chicken Joints (15 Pieces)"};
        ArrayAdapter<String> sectionadap = new ArrayAdapter<String>(PlaceOrder.this,R.layout.spinner_item,sou);
        sectionadap.setDropDownViewResource(R.layout.spinner_item);
        source.setAdapter(sectionadap);

        source.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(source.getSelectedItem().toString().equals("Select Item"))
                {
                    Toast.makeText(PlaceOrder.this, "Please select an Item", Toast.LENGTH_SHORT).show();
                }
                else {
                    avgtime.setText("45 min.");
                    pickuptime.setText("< 1 hr.");
                    cost.setText("Rs. 539/-");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(PlaceOrder.this, "Please choose one Item", Toast.LENGTH_SHORT).show();
            }
        });



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(PlaceOrder.this, "Successfully sent Details to Restaurant !", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(PlaceOrder.this,KFCActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
