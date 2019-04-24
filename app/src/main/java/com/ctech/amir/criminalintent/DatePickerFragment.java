package com.ctech.amir.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment {

    // this is the key into the bundle where we will store the date
    private static final String ARG_DATE = "crime_date";

    private DatePicker mDatePicker;

    //this is the method that the crime fragment will call to create a date picker
    public static DatePickerFragment newInstance(Date date) {

        //we'll store the date in a bundle
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        DatePickerFragment myFragment = new DatePickerFragment();
        myFragment.setArguments(args);
        return myFragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstancesState) {

        Date myDate = (Date) getArguments().getSerializable(ARG_DATE);

        // create a calender object so we can extract the year,month and day to initialize the datepicker
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(myDate);
        int year = myCalendar.get(Calendar.YEAR);



        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

        return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle(R.string.date_picker_title)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    }
}