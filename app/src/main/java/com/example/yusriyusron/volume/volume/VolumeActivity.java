package com.example.yusriyusron.volume.volume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yusriyusron.volume.MainActivity;
import com.example.yusriyusron.volume.R;
import com.example.yusriyusron.volume.intent.IntentActivity;

public class VolumeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputPanjang,inputLebar,inputTinggi;
    private Button btnHitung, latihanIntent;
    private TextView hasil;
    private static final String STATE_RESULT = "state_result";

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, hasil.getText().toString());
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        inputPanjang = findViewById(R.id.input_panjang);
        inputLebar = findViewById(R.id.input_lebar);
        inputTinggi = findViewById(R.id.input_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        hasil = findViewById(R.id.hasil);

        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            hasil.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_hitung){
            String getPanjang = inputPanjang.getText().toString().trim();
            String getLebar = inputLebar.getText().toString().trim();
            String getTinggi = inputTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(getPanjang)){
                isEmptyFields = true;
                inputPanjang.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(getLebar)){
                isEmptyFields = true;
                inputLebar.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(getTinggi)){
                isEmptyFields = true;
                inputTinggi.setError("Field ini tidak boleh kosong");
            }

            Double panjang = toDouble(getPanjang);
            Double lebar = toDouble(getLebar);
            Double tinggi = toDouble(getTinggi);

            if (panjang == null){
                isInvalidDouble = true;
                inputPanjang.setError("Harus nomor yang valid");
            }

            if (lebar == null){
                isInvalidDouble = true;
                inputLebar.setError("Harus nomor yang valid");
            }

            if (tinggi == null){
                isInvalidDouble = true;
                inputTinggi.setError("Haurs nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble){
                double volume = panjang * lebar * tinggi;
                hasil.setText(String.valueOf(volume));
            }
        }
    }
    Double toDouble(String str){
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
