package com.example.yusriyusron.volume.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yusriyusron.volume.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnPilih,btnTutup;
    private RadioGroup radioGroup;
    private RadioButton radioButtonSaf,radioButtonMou, radioButtonLvg, radioButtonMoyes;
    private OnOptionDialogListener onOptionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPilih = view.findViewById(R.id.btn_pilih);
        btnPilih.setOnClickListener(this);

        btnTutup = view.findViewById(R.id.btn_tutup);
        btnTutup.setOnClickListener(this);

        radioGroup = view.findViewById(R.id.radio_group_option);
        radioButtonSaf = view.findViewById(R.id.radio_button_saf);
        radioButtonMou = view.findViewById(R.id.radio_button_mou);
        radioButtonLvg = view.findViewById(R.id.radio_button_lvg);
        radioButtonMoyes = view.findViewById(R.id.radio_button_moyes);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tutup:
                getDialog().cancel();
                break;
            case R.id.btn_pilih:
                int checkRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (checkRadioButtonId != -1){
                    String coach = null;
                    switch (checkRadioButtonId){
                        case R.id.radio_button_saf:
                            coach = radioButtonSaf.getText().toString().trim();
                            break;
                        case R.id.radio_button_mou:
                            coach = radioButtonMou.getText().toString().trim();
                            break;
                        case R.id.radio_button_lvg:
                            coach = radioButtonLvg.getText().toString().trim();
                            break;
                        case R.id.radio_button_moyes:
                            coach = radioButtonMoyes.getText().toString().trim();
                            break;
                    }
                    if (onOptionDialogListener != null){
                        onOptionDialogListener.onOptionChoosen(coach);
                    }
                    getDialog().dismiss();
                }
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if (fragment instanceof DetailKategoriFragment){
            DetailKategoriFragment detailKategoriFragment = (DetailKategoriFragment) fragment;
            this.onOptionDialogListener = detailKategoriFragment.onOptionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.onOptionDialogListener = null;
    }

    public interface OnOptionDialogListener{
        void onOptionChoosen(String text);
    }
}
