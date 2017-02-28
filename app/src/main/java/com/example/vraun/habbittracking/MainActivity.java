package com.example.vraun.habbittracking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dbhelper db = new Dbhelper(this);
        Log.v("DB", "OK");
        Log.v("Query: ", Dbcontract.Table.CREATE_TABLE);
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Insert in process..");

        Log.d("Reading: ", "Reading all contacts..");
        db.addHabit(new Details("Read", 3));
        db.addHabit(new Details("Sleep", 5));

        Cursor c = db.getDetails(2);
        Details H = new Details(c.getString(1), Integer.parseInt(c.getString(2)));
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        Log.v("Update: ", H.getHabitTitle() + " " + H.getHabitFrequency());

    }
}
