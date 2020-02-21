package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class FlightBooking extends AppCompatActivity {

    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_booking);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final TextView textView = (TextView)findViewById(R.id.lastDate);
        time = (TextView) findViewById(R.id.timebook);
        calendar = Calendar.getInstance();

        final Spinner source = findViewById(R.id.source);
        String[] sou = new String[]{"Choose Source","Airport","NAD Junction","Gopalapatnam","Gajuwaka","Vizag Steel Plant","Duvvada","Anakapalli"};
        ArrayAdapter<String> sectionadap = new ArrayAdapter<String >(FlightBooking.this,R.layout.spinner_item,sou);
        sectionadap.setDropDownViewResource(R.layout.spinner_item);
        source.setAdapter(sectionadap);

        final Spinner destin = findViewById(R.id.destination);
        String[] des = new String[]{"Choose Destination","NAD Junction","Airport","Gopalapatnam","Gajuwaka","Vizag Steel Plant","Duvvada","Anakapalli"};
        ArrayAdapter<String> desadap = new ArrayAdapter<String>(FlightBooking.this,R.layout.spinner_item,des);
        desadap.setDropDownViewResource(R.layout.spinner_item);
        destin.setAdapter(desadap);

        final Spinner ecoclass = findViewById(R.id.typeofclass);
        String[] cla = new String[]{"Economy","Business","Premium Economy"};
        ArrayAdapter<String> clap = new ArrayAdapter<String>(FlightBooking.this,R.layout.spinner_item,cla);
        clap.setDropDownViewResource(R.layout.spinner_item);
        ecoclass.setAdapter(clap);


        final Spinner number = findViewById(R.id.noof);
        String[] num = new String[]{"1","2","3","4","5"};
        ArrayAdapter<String> numap = new ArrayAdapter<String>(FlightBooking.this,R.layout.spinner_item,num);
        numap.setDropDownViewResource(R.layout.spinner_item);
        number.setAdapter(numap);

        final ImageView imageViewuE=(ImageView)findViewById(R.id.imageViewup);

        imageViewuE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(FlightBooking.this, new DatePickerDialog.OnDateSetListener() {
                    //DatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textView.setText("" + (month + 1) + "/" + dayOfMonth + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
                //save.setEnabled(true);
            }
        });

        findViewById(R.id.clock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(FlightBooking.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightBooking.this,Dashboard.class);
                Toast.makeText(FlightBooking.this, "Flight Booked Successfully !", Toast.LENGTH_SHORT).show();
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
