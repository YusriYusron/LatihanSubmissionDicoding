package com.example.yusriyusron.volume.intent.hasil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.yusriyusron.volume.R;

public class IntentHasilActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPilih;
    private RadioGroup radioGroup;

    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_hasil);

        btnPilih = findViewById(R.id.pilih);
        btnPilih.setOnClickListener(this);

        radioGroup = findViewById(R.id.radio_group);
    }

    @Override
    public void onClick(View view) {
        if (radioGroup.getCheckedRadioButtonId() != 0){
            int value = 0;
            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.radio1:
                    value = 50;
                    break;
                case R.id.radio2:
                    value = 100;
                    break;
                case R.id.radio3:
                    value = 150;
                    break;
                case R.id.radio4:
                    value = 200;
                    break;
            }
            Intent intent = new Intent();
            intent.putExtra(EXTRA_SELECTED_VALUE,value);
            setResult(RESULT_CODE,intent);
            finish();
        }
    }
}
