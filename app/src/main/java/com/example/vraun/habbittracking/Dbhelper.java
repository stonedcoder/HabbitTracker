package com.example.vraun.habbittracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vraun on 28-02-2017.
 */

public class Dbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HabitTracker";
    Context context;

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Dbcontract.Table.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If a table with same name is already existed or modified like updating the table name or anything,
        //this will delete the previous one and will create again

        context.deleteDatabase(DATABASE_NAME);
        onCreate(db);
    }

    void addHabit(Details newHabit) {
        //Create a Database Connection
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Dbcontract.Table.KEY_TITLE, newHabit.getHabitTitle());
        values.put(Dbcontract.Table.KEY_FREQUENCY, newHabit.getHabitFrequency());
        // Inserting Row
        db.insert(Dbcontract.Table.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public Cursor getDetails(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Dbcontract.Table.TABLE_NAME, new String[]{Dbcontract.Table.KEY_ID,
                        Dbcontract.Table.KEY_TITLE, Dbcontract.Table.KEY_FREQUENCY}, Dbcontract.Table.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    // Updating single habit row
    public void updateHabitRow(double rowId, String newContent, String newContent1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Dbcontract.Table.KEY_TITLE, newContent);
        values.put(Dbcontract.Table.KEY_FREQUENCY, newContent1);
        db.update(Dbcontract.Table.TABLE_NAME, values, Dbcontract.Table.KEY_ID + "=" + rowId, null);

    }

    // Deleting single habit from the table
    public void deleteHabitTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + Dbcontract.Table.TABLE_NAME);
    }
}
