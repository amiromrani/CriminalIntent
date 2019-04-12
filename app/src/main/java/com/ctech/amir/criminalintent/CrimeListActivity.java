package com.ctech.amir.criminalintent;

import android.support.v4.app.Fragment;

import com.ctech.amir.criminalintent.CrimeFragment;
import com.ctech.amir.criminalintent.SingleFragmentActivity2;

public class CrimeListActivity extends SingleFragmentActivity2 {
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
