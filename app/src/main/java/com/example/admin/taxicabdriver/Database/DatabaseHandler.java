package com.example.admin.taxicabdriver.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.admin.taxicabdriver.UserLogin.database.Driver_Table;

/**
 * Created by shree on 27/08/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    Context context;
    // Database Name
    public static final String DATABASE_NAME = "TaxiCab";
    private static DatabaseHandler sInstance;
    // Contacts table name

    public static synchronized DatabaseHandler getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHandler(context.getApplicationContext());
        }
        return sInstance;
    }


    private DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(Driver_Table.CREATE_DRIVER_TABLE);
        Log.d("Table created","");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Driver_Table.TABLE_DRIVER);

        // Create tables again
        onCreate(db);
    }

}