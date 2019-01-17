package com.example.yusriyusron.volume.intent.object;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.yusriyusron.volume.R;

public class IntentObjectActivity extends AppCompatActivity{
    public static final String EXTRA_PERSON = "extra_person";
    private TextView objectReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_object);

        objectReceived = findViewById(R.id.object_received);
        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + person.getName() + "\n" +
                "Age : " + person.getAge() + "\n" +
                "Email : " + person.getEmail() + "\n" +
                "City : " + person.getCity();
        objectReceived.setText(text);
    }
}
