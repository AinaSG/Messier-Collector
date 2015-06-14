package ml.melon_tau.aina.messiercollector;

/**
 * Created by aina on 13/06/15.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import ml.melon_tau.aina.messiercollector.MessierObjectContract.MessierObjectEntry;

/**
 * Manages a local database for weather data.
 */
public class MessierObjectDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "mesierobjects.db";

    public static final String TABLE_NAME = "messier_objects";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_OBJECT_CODE = "object_code";
    public static final String COLUMN_OBJECT_SEEN = "object_seen";
    public static final String COLUMN_OBJECT_NAME = "object_name";
    public static final String COLUMN_OBJECT_DESC = "object_desc";
    public static final String COLUMN_OBJECT_APARENTMAG = "object_aparentmag";
    public static final String COLUMN_OBJECT_DIAMETER = "object_diameter";

    private SQLiteDatabase mDB;

    public MessierObjectDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mDB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a table to hold locations.  A location consists of the string supplied in the
        // location setting, the city name, and the latitude and longitude
        final String SQL_CREATE_OBJECT_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_OBJECT_CODE + " TEXT NOT NULL, " +
                COLUMN_OBJECT_SEEN + " BOOLEAN NOT NULL DEFAULT 0, " +
                COLUMN_OBJECT_NAME + " TEXT, " +
                COLUMN_OBJECT_DESC + " TEXT, " +
                COLUMN_OBJECT_APARENTMAG + " REAL NOT NULL, " +
                COLUMN_OBJECT_DIAMETER + " REAL NOT NULL " +
                " );";


        db.execSQL(SQL_CREATE_OBJECT_TABLE);

        String q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm1', 0, 'nebulae', 'huge gas cloud', 6, 45 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm2', 0, NULL, 'huge helium ball', 34, 2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm3', 0, 'galaxy', 'tiny star collection', 3, 1 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm4', 0, 'cluster', 'white dots in the sky', 6, 45 )";
        db.execSQL(q);








        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm5', 0, 'nebulae', 'huge gas cloud', 6, 45 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm6', 0, 'star', 'huge helium ball', 34, 2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm7', 0, 'galaxy', 'tiny star collection', 3, 1 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm8', 0, 'cluster', 'white dots in the sky', 6, 45 )";
        db.execSQL(q);
        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm9', 0, 'nebulae', 'huge gas cloud', 6, 45 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm10', 0, NULL, 'huge helium ball', 34, 2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm11', 0, 'galaxy', 'tiny star collection', 3, 1 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DIAMETER + " ) " + "values ( 'm12', 0, 'cluster', 'white dots in the sky', 6, 45 )";
        db.execSQL(q);
    }

    public Cursor getAllObjects(){
        return mDB.query(TABLE_NAME, new String[] { COLUMN_ID,
                COLUMN_OBJECT_CODE,
                COLUMN_OBJECT_SEEN,
                COLUMN_OBJECT_NAME,
                COLUMN_OBJECT_DESC,
                COLUMN_OBJECT_APARENTMAG,
                COLUMN_OBJECT_DIAMETER },
                null, null, null, null, COLUMN_ID + " asc ");

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