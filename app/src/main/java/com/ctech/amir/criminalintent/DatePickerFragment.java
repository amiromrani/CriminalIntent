package com.ctech.amir.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
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

    //this is the key into the intent where we store the dateto pass back to crimefragment
    public static final String EXTRA_DATE = "com.ctech.amir.criminalintent.date";

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

    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent myIntent = new Intent();
        myIntent.putExtra(Intent.EXTRA_DATE, date);

        }

        Date myDate = (Date) getArguments().getSerializable(ARG_DATE);

        // create a calender object so we can extract the year,month and day to initialize the datepicker
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(myDate);
        int year = myCalendar.get(Calendar.YEAR);
        int month = myCalendar.get(Calendar.MONTH);
        int day = myCalendar.get(Calendar.DAY_OF_MONTH);

        //create a view of the calendar in the dialog
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

        //initialize the date picker
        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        mDatePicker.init(year, month, day, null);

        return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle(R.string.date_picker_title)
            .setPositiveButton(android.R.string.ok, null)
            .create();
    }
}