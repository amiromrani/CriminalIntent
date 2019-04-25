package com.ctech.amir.criminalintent.database;

public class CrimeDbSchema {

    // define the table where we will store the crime data
    public static final  class CrimeTable {
        public static final String NAME = "crime";

        public static final class Colums {
            public static final String UUID = "uuid";
            public static final String TITTLE = "tittle";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
