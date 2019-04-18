package com.ctech.amir.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );

        FragmentManager fm = getSupportFragmentManager();
        Fragment myFragment = fm.findFragmentById(R.id.fragment_container);

        //first time through, the fragment will be null
        if (myFragment == null) {
            myFragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, myFragment )
                    .commit();
        }
    }

}
