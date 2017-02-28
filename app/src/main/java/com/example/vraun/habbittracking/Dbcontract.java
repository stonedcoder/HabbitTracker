package com.example.vraun.habbittracking;

import android.provider.BaseColumns;

/**
 * Created by vraun on 28-02-2017.
 */

public final class Dbcontract {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private Dbcontract() {
    }

    public static abstract class Table implements BaseColumns {

        // Contacts table name
        public static final String TABLE_NAME = "TrackingHabbits";
        // Contacts Table Columns names
        public static final String KEY_ID = "id";
        public static final String KEY_TITLE = "title";
        public static final String KEY_FREQUENCY = "frequency";


        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                KEY_ID + " INTEGER PRIMARY KEY UNIQUE ," +
                KEY_TITLE + TEXT_TYPE + COMMA_SEP +
                KEY_FREQUENCY + " INTEGER" +
                " )";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
