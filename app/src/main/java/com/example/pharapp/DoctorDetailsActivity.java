package com.example.pharapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    //hardcoded database bs msh da ely hn3mlo
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Saeed Saleh", "Hospital Address : Cairo", "Exp : 5yrs", "Mobile : 01201199120" , "100EGP"},
                    {"Doctor Name : Moussa Moussa", "Hospital Address : Alex", "Exp : 15yrs", "Mobile : 01210336672" , "200EGP"},
                    {"Doctor Name : Mina Youssef", "Hospital Address : Sohag", "Exp : 8yrs", "Mobile : 01200110640" , "300EGP"},
                    {"Doctor Name : Merna Shady", "Hospital Address : Aswan", "Exp : 6yrs", "Mobile : 01273391245" , "400EGP"},
                    {"Doctor Name : Ali Waly", "Hospital Address : Menyt ElAmh", "Exp : 7yrs", "Mobile : 01099563229" , "500EGP"},
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Saleh Saeed", "Hospital Address : Cairo", "Exp : 5yrs", "Mobile : 01201199120" , "100EGP"},
                    {"Doctor Name : Mina Moussa", "Hospital Address : Alex", "Exp : 15yrs", "Mobile : 01210336672" , "200EGP"},
                    {"Doctor Name : Youssef Mina", "Hospital Address : Sohag", "Exp : 8yrs", "Mobile : 01200110640" , "300EGP"},
                    {"Doctor Name : Shady Salem", "Hospital Address : Aswan", "Exp : 6yrs", "Mobile : 01273391245" , "400EGP"},
                    {"Doctor Name : Waly Ali", "Hospital Address : Menyt ElAmh", "Exp : 7yrs", "Mobile : 01099563229" , "500EGP"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Nancy Saeed", "Hospital Address : Cairo", "Exp : 5yrs", "Mobile : 01201199120" , "100EGP"},
                    {"Doctor Name : Fahmy Moussa", "Hospital Address : Alex", "Exp : 15yrs", "Mobile : 01210336672" , "200EGP"},
                    {"Doctor Name : Kamel Mina", "Hospital Address : Sohag", "Exp : 8yrs", "Mobile : 01200110640" , "300EGP"},
                    {"Doctor Name : Merna Salem", "Hospital Address : Aswan", "Exp : 6yrs", "Mobile : 01273391245" , "400EGP"},
                    {"Doctor Name : Myriam Ali", "Hospital Address : Menyt ElAmh", "Exp : 7yrs", "Mobile : 01099563229" , "500EGP"},
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Salem Selim", "Hospital Address : Cairo", "Exp : 5yrs", "Mobile : 01201199120" , "100EGP"},
                    {"Doctor Name : Atef Gamil", "Hospital Address : Alex", "Exp : 15yrs", "Mobile : 01210336672" , "200EGP"},
                    {"Doctor Name : Samy Samir", "Hospital Address : Sohag", "Exp : 8yrs", "Mobile : 01200110640" , "300EGP"},
                    {"Doctor Name : Medhat Saleh", "Hospital Address : Aswan", "Exp : 6yrs", "Mobile : 01273391245" , "400EGP"},
                    {"Doctor Name : Ali Omar", "Hospital Address : Menyt ElAmh", "Exp : 7yrs", "Mobile : 01099563229" , "500EGP"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Suzy Selim", "Hospital Address : Cairo", "Exp : 5yrs", "Mobile : 01201199120" , "100EGP"},
                    {"Doctor Name : Jessy Gamil", "Hospital Address : Alex", "Exp : 15yrs", "Mobile : 01210336672" , "200EGP"},
                    {"Doctor Name : Shadwa Samir", "Hospital Address : Sohag", "Exp : 8yrs", "Mobile : 01200110640" , "300EGP"},
                    {"Doctor Name : Martha Saleh", "Hospital Address : Aswan", "Exp : 6yrs", "Mobile : 01273391245" , "400EGP"},
                    {"Doctor Name : Thuryya Omar", "Hospital Address : Menyt ElAmh", "Exp : 7yrs", "Mobile : 01099563229" , "500EGP"},
            };


    TextView tvDDTitle;
    Button btnBack;
    String [][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList arrList;
    SimpleAdapter simpleAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tvDDTitle = findViewById(R.id.textViewDDTitle);
        btnBack = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tvDDTitle.setText(title);

        if(title.compareTo("Family Physician") ==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietitian") ==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist") ==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon") ==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        arrList = new ArrayList();
        for(int i=0; i<doctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Consultant Fees: "+doctor_details[i][4]);
            arrList.add(item);
        }
        simpleAd = new SimpleAdapter(this,arrList, R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView listview = findViewById(R.id.listViewDD);
        listview.setAdapter(simpleAd);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);  //The experience is not required on the book appointment so we skip the second index item
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}