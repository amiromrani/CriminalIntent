package com.ctech.amir.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerViiew;


    @Override
    public View onCreateView (@NonNull LayoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancesState){


        View myView = inflater.inflate(R.layout.fragment_crime_list , container , false);

        mCrimeRecyclerViiew = myView.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerViiew.setLayoutManager(new LinearLayoutManager(getActivity()));

        return myView;
    }

    private class CrimeHolder extends RecyclerView.ViewHolder {
        public CrimeHolder (LayoutInflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime,parent,false ));
        }
    }





}
