package com.ctech.amir.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class CrimeFragment extends Fragment {

    private Button mDateButton;
    private EditText mTitleFeild;
    private Crime mCrime;
    private CheckBox mSolvedCHeckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_crime,container,false  );

       mTitleFeild = v.findViewById(R.id.crime_title);
       mTitleFeild.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // do nothing here for now
           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
            // do nothing here for now
           }
       });
       mDateButton = v.findViewById(R.id.crime_date);
       mDateButton.setText(mCrime.getmDate().toString());
       mDateButton.setEnabled(false);

       mSolvedCHeckBox = v.findViewById(R.id.crime_solved);
       mSolvedCHeckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

           }
       });



        return super.onCreateView(inflater, container, savedInstanceState);
    }



}

