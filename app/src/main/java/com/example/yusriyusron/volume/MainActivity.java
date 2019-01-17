package com.example.yusriyusron.volume;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yusriyusron.volume.fragment.HomeFragment;
import com.example.yusriyusron.volume.fragment.MainFragment;
import com.example.yusriyusron.volume.intent.IntentActivity;
import com.example.yusriyusron.volume.recycler_view.RecyclerViewActivity;
import com.example.yusriyusron.volume.view.ViewViewGroupActivity;
import com.example.yusriyusron.volume.volume.VolumeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLatihanVolume, btnLatihanIntent,btnLatihanFragment,btnLatihanView,btnLatihanRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLatihanVolume= findViewById(R.id.btn_latihan_volume);
        btnLatihanVolume.setOnClickListener(this);

        btnLatihanIntent = findViewById(R.id.btn_latihan_intent);
        btnLatihanIntent.setOnClickListener(this);

        btnLatihanFragment = findViewById(R.id.btn_latihan_fragment);
        btnLatihanFragment.setOnClickListener(this);

        btnLatihanView = findViewById(R.id.btn_view_vgroup);
        btnLatihanView.setOnClickListener(this);

        btnLatihanRecyclerView = findViewById(R.id.btn_recycler_view);
        btnLatihanRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_latihan_volume) {
            makeIntent(VolumeActivity.class);
        }else if (view.getId() == R.id.btn_latihan_intent){
            makeIntent(IntentActivity.class);
        }else if (view.getId() == R.id.btn_latihan_fragment){
            makeIntent(MainFragment.class);
        }else if (view.getId() == R.id.btn_view_vgroup){
            makeIntent(ViewViewGroupActivity.class);
        }else if (view.getId() == R.id.btn_recycler_view){
            makeIntent(RecyclerViewActivity.class);
        }
    }

    private void makeIntent(Class activityTujuan){
        Intent intent = new Intent(MainActivity.this,activityTujuan);
        startActivity(intent);
    }
}
