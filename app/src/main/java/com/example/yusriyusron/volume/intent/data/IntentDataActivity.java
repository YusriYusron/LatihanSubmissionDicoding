package com.example.yusriyusron.volume.intent.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.yusriyusron.volume.R;

public class IntentDataActivity extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    private TextView dataReceived;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_intent_data);

         dataReceived = findViewById(R.id.data_received);

         String name = getIntent().getStringExtra(EXTRA_NAME);
         int age = getIntent().getIntExtra(EXTRA_AGE,0);

         String text = "Nama : " + name + "\nYour Age : " + age;
         dataReceived.setText(text);
     }
}
