package com.ctech.amir.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity2 {

    //thi is just a constant we will use to get and set crimeId in our intent
    private static final String EXTRA_CRIME_ID = "com.ctech.amir.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent myIntent = new Intent(packageContext, CrimeActivity.class);
        myIntent.putExtra(EXTRA_CRIME_ID, crimeId);
        return myIntent;
    }



   @Override
    protected Fragment createFragment() {
       return new CrimeFragment();
   }
}
