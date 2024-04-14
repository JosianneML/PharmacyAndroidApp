package com.example.pharapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Date;
import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnBookApp, btnBACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        //mapping
        tv = findViewById(R.id.textViewTitleBookAppPage);
        ed1 = findViewById(R.id.editTextAppointmentFullName);
        ed2 = findViewById(R.id.editTextAppointmentAddress);
        ed3 = findViewById(R.id.editTextAppointmentContactNum);
        ed4 = findViewById(R.id.editTextAppointmentConsFees);

        dateButton = findViewById(R.id.buttonBookAppDate);
        timeButton = findViewById(R.id.buttonBookAppTime);

        btnBookApp = findViewById(R.id.buttonBookAppNow);
        btnBACK = findViewById(R.id.buttonBookAppBACK);


        //removing the clicks that means that all the edit texts are not editable
        //they just display all the details from the previous activity to the next activity
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);


        //fetch the data
        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contactnum = it.getStringExtra("text4");
        String consfees = it.getStringExtra("text5");

        //then display all these variable data to the edit text
        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contactnum);
        ed4.setText("Consultant Fees: "+consfees);

        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        //timepicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        btnBACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
            }
        });

        btnBookApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the data into the database

            }
        });
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                dateButton.setText(dayOfMonth+ "/"+ month+ "/"+ year);
            }
        };
        Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, yy, mm, dd);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeButton.setText(hourOfDay+ ":"+ minute);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(this, timeSetListener, hrs, mins, true);
    }
}