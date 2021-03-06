package com.ctech.amir.criminalintent;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.ctech.amir.criminalintent.database.CrimeDbSchema;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public CrimeCursorWrapper(Cursor) {
        super();
    }

    // get the Crime datails out of the database and store them in a Crime object
    public Crime getCrime () {
        String uuidString = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Colums.UUID));
        String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Colums.TITTLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.Colums.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.Colums.SOLVED));
        String suspect = getString(getColumnIndex(CrimeDbSchema.CrimeTable.SUSPECT));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved == 1);
        crime.setSuspect(suspect);

        return crime;
    }

    //  the user can now specify their own UUID
    public CrimeCursorWrapper(UUID id) {
        UUID mId = id;
        Date mDate = new Date(); // default the crime date to right now
    }

    // automatically create a guaranteed-unique ID if not provied
    public Crime() {
        this(UUID.randomUUID());
    }


}





