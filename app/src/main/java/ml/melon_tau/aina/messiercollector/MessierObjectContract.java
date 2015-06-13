package ml.melon_tau.aina.messiercollector;

/**
 * Created by aina on 13/06/15.
 */

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Defines table and column names for the weather database.
 */
public class MessierObjectContract {


    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.
    public static final String CONTENT_AUTHORITY = "ml.melon_tau.aina.messiercollector.MessierObjectProvider";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_MESSIEROBJECT = "messierobject";
    /*
        Inner class that defines the contents of the location table
     */
    public static final class MessierObjectEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MESSIEROBJECT).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MESSIEROBJECT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MESSIEROBJECT;

        public static final String TABLE_NAME = "messier_objects";
        public static final String COLUMN_OBJECT_CODE = "object_code";
        public static final String COLUMN_OBJECT_SEEN = "object_seen";
        public static final String COLUMN_OBJECT_NAME = "object_name";
        public static final String COLUMN_OBJECT_DESC = "object_desc";
        public static final String COLUMN_OBJECT_APARENTMAG = "object_aparentmag";
        public static final String COLUMN_OBJECT_DIAMETER = "object_diameter";

        public static Uri buildMessierObjectUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

}