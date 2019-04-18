package com.ctech.amir.criminalintent;


import java.util.Date;
import java.util.UUID;



public class Crime {

    private UUID mId;    // crimes ID
    private String mTitle;  //title of the crime
    private Date mDate; // date of the crime
    private boolean mSolved; // has the crime been solved

    public Crime(){

        mId = UUID.randomUUID();  //aoutomaticly create a guaranteed-unique ID
        mDate = new Date();
    }
    public UUID getId(){
        return mId;
    }
    public String getTitle (){
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
    public Date getDate (){
        return mDate;
    }
    public void setDate(Date date ){
        mDate = date;
    }
    public boolean isSolved(){
        return mSolved;
    }
    public void setSolved(boolean solved) {
        mSolved = solved;

    }

}



