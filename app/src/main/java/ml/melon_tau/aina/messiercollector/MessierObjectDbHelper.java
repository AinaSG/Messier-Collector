package ml.melon_tau.aina.messiercollector;

/**
 * Created by aina on 13/06/15.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ml.melon_tau.aina.messiercollector.MessierObjectContract.MessierObjectEntry;


/**
 * Manages a local database for weather data.
 */
public class MessierObjectDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "mesierobjects.db";

    public MessierObjectDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table to hold locations.  A location consists of the string supplied in the
        // location setting, the city name, and the latitude and longitude
        final String SQL_CREATE_OBJECT_TABLE = "CREATE TABLE " + MessierObjectEntry.TABLE_NAME + " (" +
                MessierObjectEntry._ID + " INTEGER PRIMARY KEY," +
                MessierObjectEntry.COLUMN_OBJECT_CODE + " TEXT UNIQUE NOT NULL, " +
                MessierObjectEntry.COLUMN_OBJECT_SEEN + " BOOLEAN NOT NULL DEFAULT 0, " +
                MessierObjectEntry.COLUMN_OBJECT_NAME + " TEXT, " +
                MessierObjectEntry.COLUMN_OBJECT_DESC + " TEXT, " +
                MessierObjectEntry.COLUMN_OBJECT_APARENTMAG + " REAL NOT NULL, " +
                MessierObjectEntry.COLUMN_OBJECT_DIAMETER + " REAL NOT NULL " +
                " );";


        sqLiteDatabase.execSQL(SQL_CREATE_OBJECT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // Note that this only fires if you change the version number for your database.
        // It does NOT depend on the version number for your application.
        // If you want to update the schema without wiping data, commenting out the next 2 lines
        // should be your top priority before modifying this method.
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MessierObjectEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}