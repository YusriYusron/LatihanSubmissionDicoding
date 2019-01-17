package com.example.yusriyusron.volume.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yusriyusron.volume.R;
import com.example.yusriyusron.volume.recycler_view.card_view.CardPresidenAdapter;
import com.example.yusriyusron.volume.recycler_view.grid_view.GridPresidenAdapter;
import com.example.yusriyusron.volume.recycler_view.list_view.PresidenAdapter;
import com.example.yusriyusron.volume.recycler_view.model.Presiden;
import com.example.yusriyusron.volume.recycler_view.model.PresidenData;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCategory;
    private ArrayList<Presiden> arrayList;

    private final String STATE_TITLE = "state_string";
    private final String STATE_LIST = "state_list";
    private final String STATE_MODE = "state_mode";
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerViewCategory = findViewById(R.id.rv_category);
        recyclerViewCategory.setHasFixedSize(true);

        arrayList = new ArrayList<>();

        if (savedInstanceState == null){
            setActionBarTitle("Mode List");
            arrayList.addAll(PresidenData.getListData());
            showListView();
            mode = R.id.action_list;
        }else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Presiden> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            arrayList.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void setMode(int selectedMode){
        String title = null;
        switch (selectedMode){
            case R.id.action_list:
                title = "Mode List";
                showListView();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showGridView();
                break;
            case R.id.action_card:
                title = "Mode Card";
                showCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE,getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST,arrayList);
        outState.putInt(STATE_MODE,mode);
    }

    private void showListView(){
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this));
        PresidenAdapter presidenAdapter = new PresidenAdapter(this);
        presidenAdapter.setListPresiden(arrayList);
        recyclerViewCategory.setAdapter(presidenAdapter);
    }
    private void showGridView(){
        recyclerViewCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridPresidenAdapter gridPresidenAdapter = new GridPresidenAdapter(this);
        gridPresidenAdapter.setListPresiden(arrayList);
        recyclerViewCategory.setAdapter(gridPresidenAdapter);
    }
    private void showCardView(){
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this));
        CardPresidenAdapter cardPresidenAdapter = new CardPresidenAdapter(this);
        cardPresidenAdapter.setListPresiden(arrayList);
        recyclerViewCategory.setAdapter(cardPresidenAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
