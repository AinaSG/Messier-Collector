package ml.melon_tau.aina.messiercollector;

/**
 * Created by aina on 13/06/15.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


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
    public static final String COLUMN_OBJECT_DISTANCE = "object_distance";

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
                COLUMN_OBJECT_SEEN + " INTEGER NOT NULL DEFAULT 0, " +
                COLUMN_OBJECT_NAME + " TEXT, " +
                COLUMN_OBJECT_DESC + " TEXT, " +
                COLUMN_OBJECT_APARENTMAG + " REAL NOT NULL, " +
                COLUMN_OBJECT_DISTANCE + " REAL NOT NULL " +
                " );";


        db.execSQL(SQL_CREATE_OBJECT_TABLE);

        String q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M1', 0 , 'Crab Nebula', 'Bright (emission and/or reflection) nebula in Taurus', 8.4, 6.3 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M2', 0 , NULL, 'Globular star cluster in Aquarius', 6.5, 37.5 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M3', 0 , NULL, 'Globular star cluster in Canes Venatici', 6.4, 33.9 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M4', 0 , NULL, 'Globular star cluster in Scorpius', 5.9, 7.2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M5', 0 , NULL, 'Globular star cluster in Serpens', 5.8, 24.5 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M6', 0 , 'Butterfly Cluster', 'Open star cluster in Scorpius', 4.2, 2 )";
        db.execSQL(q);

       q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M7', 0 , 'Ptolemy''s Cluster', 'Open star cluster in Scorpius', 3.3, 0.8 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M8', 0 , 'Lagoon Nebula', 'Bright (emission and/or reflection) nebula in Sagittarius', 5.8, 5.2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M9', 0 , NULL, 'Globular star cluster in Ophiuchus', 7.9, 26.7 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M10', 0 , NULL, 'Globular star cluster in Ophiuchus', 6.6, 14.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M11', 0 , 'Wild Duck Cluster', 'Open star cluster in Scutum', 5.8, 6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M12', 0 , NULL, 'Globular star cluster in Ophiuchus', 6.6, 16.0 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M13', 0 , 'Hercules Cluster', 'Globular star cluster in Hercules', 5.9, 25.1 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M14', 0 , NULL, 'Globular star cluster in Ophiuchus', 7.6, 29.0 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M15', 0 , NULL, 'Globular star cluster in Pegasus', 6.4, 33.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M16', 0 , 'Eagle Nebula', 'Cluster associated with nebulosity in Serpens', 6.0, 7 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M17', 0 , 'Omega Nebula', 'Cluster associated with nebulosity in Sagittarius', 6.0, 5 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M18', 0 , NULL, 'Open star cluster in Sagittarius', 6.9, 4.9 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M19', 0 , NULL, 'Globular star cluster in Ophiuchus', 7.2, 28.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M20', 0 , 'Trifid Nebula', 'Cluster associated with nebulosity in Sagittarius', 6.3, 5.2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M21', 0 , NULL, 'Open star cluster in Sagittarius', 5.9, 4.25 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M22', 0 , NULL, 'Globular star cluster in Sagittarius', 5.1, 10.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M23', 0 , NULL, 'Open star cluster in Sagittarius', 5.5, 2.15 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M24', 0 , 'Sagittarius Star Cloud', 'Cluster associated with nebulosity in Sagittarius', 4.6, 10 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M25', 0 , NULL, 'Open star cluster in Sagittarius', 4.6, 2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M26', 0 , NULL, 'Open star cluster in Scutum', 8.0, 5 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M27', 0 , 'Dumbbell Nebula', 'Planetary nebula in Vulpecula', 8.1, 1.25 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M28', 0 , NULL, 'Globular star cluster in Sagittarius', 6.9, 18.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M29', 0 , NULL, 'Open star cluster in Cygnus', 6.6, 4.0 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M30', 0 , NULL, 'Globular star cluster in Capricornus', 7.5, 26.1 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M31', 0 , 'Andromeda Galaxy', 'Galaxy in Andromeda', 3.5, 2900 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M32', 0 , 'Andromeda Galaxy (Sat)', 'Galaxy in Andromeda', 8.2, 2900 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M33', 0 , 'Triangulum Galaxy', 'Galaxy in Triangulum', 5.7, 3000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M34', 0 , NULL, 'Open star cluster in Perseus', 5.2, 1.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M35', 0 , NULL, 'Open star cluster in Gemini', 5.1, 2.8 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M36', 0 , NULL, 'Open star cluster in Auriga', 6.0, 4.1 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M37', 0 , NULL, 'Open star cluster in Auriga', 5.6, 4.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M38', 0 , NULL, 'Open star cluster in Auriga', 6.4, 4.2 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M39', 0 , NULL, 'Open star cluster in Cygnus', 4.6, 0.825 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M40', 0 , 'Winnecke 4', 'Double star in Ursa Major', 8.4, 0.51 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M41', 0 , NULL, 'Open star cluster in Canis Major', 4.5, 2.3 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M42', 0 , 'Orion Nebula', 'Bright (emission and/or reflection) nebula in Orion', 4., 1.6 )";
        db.execSQL(q);

       q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M43', 0 , 'De Mairan''s Nebula', 'Bright (emission and/or reflection) nebula in Orion', 9.0, 1.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M44', 0 , 'Beehive Cluster', 'Open star cluster in Cancer', 3.1, 0.577 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M45', 0 , 'Pleiades', 'Cluster associated with nebulosity in Taurus', 1.6, 0.38 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M46', 0 , NULL, 'Open star cluster in Puppis', 6.1, 5.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M47', 0 , NULL, 'Open star cluster in Puppis', 4.4, 1.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M48', 0 , NULL, 'Open star cluster in Hydra', 5.8, 1.5 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M49', 0 , NULL, 'Galaxy in Virgo', 8.4, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M50', 0 , NULL, 'Open star cluster in Monoceros', 5.9, 3 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M51', 0 , 'Whirlpool Galaxy', 'Galaxy in Canes Venatici', 8.4, 37000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M52', 0 , NULL, 'Open star cluster in Cassiopeia', 6.9, 5.0 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M53', 0 , NULL, 'Globular star cluster in Coma Berenices', 7.7, 59.7 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M54', 0 , NULL, 'Globular star cluster in Sagittarius', 7.7, 88.7 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M55', 0 , NULL, 'Globular star cluster in Sagittarius', 7.0, 17.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M56', 0 , NULL, 'Globular star cluster in Lyra', 8.3, 32.9 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M57', 0 , 'Ring Nebula', 'Planetary nebula in Lyra', 9.0, 2.3 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M58', 0 , NULL, 'Galaxy in Virgo', 9.8, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M59', 0 , NULL, 'Galaxy in Virgo', 9.8, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M60', 0 , NULL, 'Galaxy in Virgo', 8.8, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M61', 0 , NULL, 'Galaxy in Virgo', 9.7, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M62', 0 , NULL, 'Globular star cluster in Ophiuchus', 6.6, 22.5 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M63', 0 , 'Sunflower Galaxy', 'Galaxy in Canes Venatici', 8.6, 37000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M64', 0 , 'Blackeye Galaxy', 'Galaxy in Coma Berenices', 8.5, 19000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M65', 0 , 'Leo Triplett', 'Galaxy in Leo', 9.3, 35000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M66', 0 , 'Leo Triplett', 'Galaxy in Leo', 9.0, 35000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M67', 0 , NULL, 'Open star cluster in Cancer', 6.9, 2.7 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M68', 0 , NULL, 'Globular star cluster in Hydra', 8.2, 33.3 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M69', 0 , NULL, 'Globular star cluster in Sagittarius', 7.7, 28.0 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M70', 0 , NULL, 'Globular star cluster in Sagittarius', 8.1, 29.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M71', 0 , NULL, 'Globular star cluster in Sagitta', 8.3, 12.7 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M72', 0 , NULL, 'Globular star cluster in Aquarius', 9.4, 55.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M73', 0 , NULL, 'Open star cluster in Aquarius', 9.0, 2.0 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M74', 0 , NULL, 'Galaxy in Pisces', 9.2, 35000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M75', 0 , NULL, 'Globular star cluster in Sagittarius', 8.6, 61.3 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M76', 0 , 'Little Dumbbell Nebula', 'Planetary nebula in Perseus', 12.0, 3.4 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M77', 0 , 'Cetus A', 'Galaxy in Cetus', 8.8, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M78', 0 , NULL, 'Bright (emission and/or reflection) nebula in Orion', 8.0, 1.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M79', 0 , NULL, 'Globular star cluster in Lepus', 8.0, 42.1 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M80', 0 , NULL, 'Globular star cluster in Scorpius', 7.2, 32.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M81', 0 , 'Bode''s Galaxy', 'Galaxy in Ursa Major', 6.9, 12000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M82', 0 , 'Cigar Galaxy', 'Galaxy in Ursa Major', 8.4, 12000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M83', 0 , 'Southern Pinwheel', 'Galaxy in Hydra', 7.6, 15000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M84', 0 , NULL, 'Galaxy in Virgo', 9.3, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M85', 0 , NULL, 'Galaxy in Coma Berenices', 9.2, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M86', 0 , NULL, 'Galaxy in Virgo', 9.2, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M87', 0 , 'Virgo A', 'Galaxy in Virgo', 8.6, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M88', 0 , NULL, 'Galaxy in Coma Berenices', 9.5, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M89', 0 , NULL, 'Galaxy in Virgo', 9.8, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M90', 0 , NULL, 'Galaxy in Virgo', 9.5, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M91', 0 , NULL, 'Galaxy in Coma Berenices', 10.2, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M92', 0 , NULL, 'Globular star cluster in Hercules', 6.5, 26.7 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M93', 0 , NULL, 'Open star cluster in Puppis', 6.2, 3.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M94', 0 , NULL, 'Galaxy in Canes Venatici', 8.2, 14500 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M95', 0 , NULL, 'Galaxy in Leo', 9.7, 38000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M96', 0 , NULL, 'Galaxy in Leo', 9.2, 38000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M97', 0 , 'Owl Nebula', 'Planetary nebula in Ursa Major', 11.2, 2.6 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M98', 0 , NULL, 'Galaxy in Coma Berenices', 10.1, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M99', 0 , NULL, 'Galaxy in Coma Berenices', 9.8, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M100', 0 , NULL, 'Galaxy in Coma Berenices', 9.4, 60000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M101', 0 , 'Pinwheel Galaxy', 'Galaxy in Ursa Major', 7.7, 27000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M102', 0 , 'Spindle Galaxy', 'Galaxy in Draco', 10.0, 40000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M103', 0 , NULL, 'Open star cluster in Cassiopeia', 7.4, 8.5 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M104', 0 , 'Sombrero Galaxy', 'Galaxy in Virgo', 8.3, 50000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M105', 0 , NULL, 'Galaxy in Leo', 9.3, 38000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M106', 0 , NULL, 'Galaxy in Canes Venatici', 8.3, 25000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M107', 0 , NULL, 'Globular star cluster in Ophiuchus', 8.1, 20.9 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M108', 0 , NULL, 'Galaxy in Ursa Major', 10.1, 45000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M109', 0 , NULL, 'Galaxy in Ursa Major', 9.8, 55000 )";
        db.execSQL(q);

        q = "insert into " + TABLE_NAME + " ( " + COLUMN_OBJECT_CODE + "," + COLUMN_OBJECT_SEEN +
                "," + COLUMN_OBJECT_NAME + "," + COLUMN_OBJECT_DESC + "," + COLUMN_OBJECT_APARENTMAG + ","
                + COLUMN_OBJECT_DISTANCE + " ) " + "values ( 'M110', 0 , 'Andromeda Gal. (Sat)', 'Galaxy in Andromeda', 8.0, 2900 )";
        db.execSQL(q);


    }


    public Cursor getAllObjects(){
        return mDB.query(TABLE_NAME, new String[] { COLUMN_ID,
                COLUMN_OBJECT_CODE,
                COLUMN_OBJECT_SEEN,
                COLUMN_OBJECT_NAME,
                COLUMN_OBJECT_DESC,
                COLUMN_OBJECT_APARENTMAG,
                COLUMN_OBJECT_DISTANCE},
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