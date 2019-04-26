package com.ctech.amir.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ctech.amir.criminalintent.database.CrimeDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// the com.ctech.bartucz.criminalintent.CrimeLab singleton class
public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {

        // the context is where the database is stored while the app is running
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
        }

    public void addCrime(Crime c) {
        // fill a contentValues object with the data from the crime and insert it into the database
        ContentValues newValues = getContentValues(c);
        mDatabase.insert(CrimeDbSchema.CrimeTable.NAME, null, newValues);
    }

    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();
        return crimes;
    }

    public Crime getCrime(UUID id) {


    }

    // convert a crime object into a content values object witch we can store in the database
    private static ContentValues getContentValues(Crime crime) {
        ContentValues myContentValues = new ContentValues();
        myContentValues.put(CrimeDbSchema.CrimeTable.Colums.UUID, crime.getId().toString());
        myContentValues.put(CrimeDbSchema.CrimeTable.Colums.TITTLE, crime.getTitle());
        myContentValues.put(CrimeDbSchema.CrimeTable.Colums.DATE, crime.getDate().getTime());
        myContentValues.put(CrimeDbSchema.CrimeTable.Colums.SOLVED, crime.isSolved() ? 1 : 0);

        return myContentValues;
        }
    public void updateCrime(Crime c) {
        String crimeId = c.getId().toString();
        ContentValues newValues = getContentValues(c);

        //we need to send a search string and the arguments you want it to match
        // in this case, we want to find the row WHERE the UUID = crimeId
        String searchString = CrimeDbSchema.CrimeTable.Colums.UUID + " = ?";
        String[] searchArgs = new String[] { crimeId };

        mDatabase.update(CrimeDbSchema.CrimeTable.NAME, newValues, searchString, searchArgs);
    }

    private Cursor queryCrimes(String whereClause, String[] whereArgs) {

        Cursor cursor= mDatabase.query(
                CrimeDbSchema.CrimeTable.NAME,
                            null,
                            whereClause,
                            whereArgs,
                             null,
                             null,
                            null);

        return cursor;
    }

    }


