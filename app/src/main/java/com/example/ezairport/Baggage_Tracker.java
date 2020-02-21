package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.nio.file.attribute.BasicFileAttributeView;

public class Baggage_Tracker extends AppCompatActivity {

    EditText source,destination,count;
    String sour,desi,cou,ph,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baggage__tracker);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        count=(EditText)findViewById(R.id.count);

        ph="9505072323";

        final Spinner source = findViewById(R.id.source);
        String[] sou = new String[]{"Choose Source","Airport","NAD Junction","Gopalapatnam","Gajuwaka","Vizag Steel Plant","Duvvada","Anakapalli"};
        ArrayAdapter<String> sectionadap = new ArrayAdapter<String >(Baggage_Tracker.this,R.layout.spinner_item,sou);
        sectionadap.setDropDownViewResource(R.layout.spinner_item);
        source.setAdapter(sectionadap);

        final Spinner destin = findViewById(R.id.destination);
        String[] des = new String[]{"Choose Destination","NAD Junction","Airport","Gopalapatnam","Gajuwaka","Vizag Steel Plant","Duvvada","Anakapalli"};
        ArrayAdapter<String> desadap = new ArrayAdapter<String>(Baggage_Tracker.this,R.layout.spinner_item,des);
        desadap.setDropDownViewResource(R.layout.spinner_item);
        destin.setAdapter(desadap);

        msg="Your Destination "+desi+" has been reached.Please check your "+cou+" count of Bags.";

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sour=source.getSelectedItem().toString();
                desi=destin.getSelectedItem().toString();
                cou=count.getText().toString().trim();
                msg="Your Destination "+desi+" has been reached.Please check your "+cou+" count of Bags.";

                Thread background = new Thread() {
                    public void run() {
                        try {
                            sleep(300 * 1000);
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(ph, null, msg, null, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                background.start();
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
