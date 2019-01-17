package com.example.yusriyusron.volume.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yusriyusron.volume.R;
import com.example.yusriyusron.volume.intent.data.IntentDataActivity;
import com.example.yusriyusron.volume.intent.hasil.IntentHasilActivity;
import com.example.yusriyusron.volume.intent.object.IntentObjectActivity;
import com.example.yusriyusron.volume.intent.object.Person;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIntentData,btnIntentObject,btnIntentDial,btnIntentHasil;
    private TextView hasilActivity;
    public static int REQUEST_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnIntentData = findViewById(R.id.btn_intent_data);
        btnIntentData.setOnClickListener(this);

        btnIntentObject = findViewById(R.id.btn_intent_object);
        btnIntentObject.setOnClickListener(this);

        btnIntentDial = findViewById(R.id.btn_intent_dial);
        btnIntentDial.setOnClickListener(this);

        btnIntentHasil = findViewById(R.id.btn_intent_hasil);
        btnIntentHasil.setOnClickListener(this);

        hasilActivity = findViewById(R.id.hasil_activity);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_intent_data){
            Intent intent = new Intent(IntentActivity.this, IntentDataActivity.class);
            intent.putExtra(IntentDataActivity.EXTRA_NAME, "Yusri Yusron");
            intent.putExtra(IntentDataActivity.EXTRA_AGE, 19);
            startActivity(intent);
        }else if (view.getId() == R.id.btn_intent_object){
            Person person = new Person();
            person.setName("Yusri Yusron");
            person.setAge(19);
            person.setEmail("yusriyusron0530@gmail.com");
            person.setCity("Bandung, Indonesia");

            Intent intent = new Intent(IntentActivity.this, IntentObjectActivity.class);
            intent.putExtra(IntentObjectActivity.EXTRA_PERSON, person);
            startActivity(intent);
        }else if (view.getId() == R.id.btn_intent_dial){
            String phoneNumber = "081910144769";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
            startActivity(intent);
        }else if (view.getId() == R.id.btn_intent_hasil){
            Intent intent = new Intent(IntentActivity.this,IntentHasilActivity.class);
            startActivityForResult(intent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == IntentHasilActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(IntentHasilActivity.EXTRA_SELECTED_VALUE,0);
                hasilActivity.setText(String.format("Hasil : %s",selectedValue));
            }
        }
    }
}
