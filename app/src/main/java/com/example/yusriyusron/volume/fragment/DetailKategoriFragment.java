package com.example.yusriyusron.volume.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yusriyusron.volume.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailKategoriFragment extends Fragment implements View.OnClickListener {

    private TextView namaKategori,deskripsiKategori;
    private Button btnProfil,btnShowDialog;

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESCRIPTION = "extra_description";
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DetailKategoriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kategori, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String categoryName = getArguments().getString(EXTRA_NAME);
        namaKategori.setText(categoryName);
        deskripsiKategori.setText(getDescription());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        namaKategori = view.findViewById(R.id.nama_kategori);
        deskripsiKategori = view.findViewById(R.id.deskripsi_kategori);

        btnProfil = view.findViewById(R.id.btn_profil);
        btnProfil.setOnClickListener(this);

        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
    }

    OptionDialogFragment.OnOptionDialogListener onOptionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChoosen(String text) {
            Toast.makeText(getActivity(),text, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_profil:
                Intent intent = new Intent(getActivity(),ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_show_dialog:
                OptionDialogFragment optionDialogFragment = new OptionDialogFragment();

                FragmentManager fragmentManager = getChildFragmentManager();
                optionDialogFragment.show(fragmentManager,OptionDialogFragment.class.getSimpleName());
                break;
        }
    }
}
