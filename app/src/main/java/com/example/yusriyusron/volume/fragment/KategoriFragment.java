package com.example.yusriyusron.volume.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.yusriyusron.volume.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KategoriFragment extends Fragment implements View.OnClickListener {


    public KategoriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategori, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailKategori = view.findViewById(R.id.btn_detail_kategori);
        btnDetailKategori.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_detail_kategori){
            DetailKategoriFragment detailKategoriFragment = new DetailKategoriFragment();

            Bundle bundle = new Bundle();
            bundle.putString(detailKategoriFragment.EXTRA_NAME,"Lifestyle");
            String desc = "Kategori ini berisi lifestyle";

            detailKategoriFragment.setArguments(bundle);
            detailKategoriFragment.setDescription(desc);

            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null){
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main, detailKategoriFragment, DetailKategoriFragment.class.getSimpleName());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }
    }
}
