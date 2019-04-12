package com.ctech.amir.criminalintent;

import android.support.v4.app.Fragment;


public class CrimeActivity extends SingleFragmentActivity2 {

   @Override
    protected Fragment createFragment() {
       return new CrimeFragment();
   }
}
