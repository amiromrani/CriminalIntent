package com.ctech.amir.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {

    //this is just a constraint string we will use to set and het crimeid in our intent
    private static final String EXTRA_CRIME_ID = "com.ctech.amir.criminalintent.crime_id";

    private ViewPager mViewPager;
    private List<Crime> mCrimes;


    public static Intent newIntent(Context pakageContext, UUID crimeId) {
        Intent myIntent = new Intent(pakageContext, CrimePagerActivity.class );
        myIntent.putExtra(EXTRA_CRIME_ID, crimeId);
        return myIntent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        //get the crimeid that was passed to us from the crimelist via the intent
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);



        //set the layout for the viewpager to be this view
        mViewPager = findViewById(R.id.crime_view_pager );

        // get the list of crimes (to scroll through)
        mCrimes = CrimeLab.get(this).getCrimes();

        //set up the adapter so that it can create a crimefragment for a specific crime
        FragmentManager myFragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(myFragmentManager) {
            @Override
            public Fragment getItem(int i) {
                Crime myCrime = mCrimes.get(i);
                return CrimeFragment.newInstance(myCrime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
    }
}
