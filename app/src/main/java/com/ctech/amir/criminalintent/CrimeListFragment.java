package com.ctech.amir.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertController;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CrimeListFragment extends Fragment {


    private RecyclerView mCrimeRecyclerViiew;
    private CrimeAdapter mAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstancesState) {


        View myView = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerViiew = myView.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerViiew.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return myView;
    }
    private class CrimeHolder extends RecyclerView.ViewHolder {
        public CrimeHolder(LayoutInflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
        }
    }


    private void updatedUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getmCrimes();

        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerViiew.setAdapter(mAdapter);
    }



    private class CrimeAdapter extends RecyclerView.Adaptor<CrimeHolder> {
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater myLayoutInflator = LayoutInflater.from(getActivity());
            return new CrimeHolder(myLayoutInflator, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int i) {
            //nothing yet
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

    }
}


