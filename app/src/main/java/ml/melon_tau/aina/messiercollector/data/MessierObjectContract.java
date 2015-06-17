package ml.melon_tau.aina.messiercollector.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by aina on 16/06/15.
 */
public class MessierObjectContract {
    public static final String CONTENT_AUTHORITY = "cml.melon_tau.aina.messiercollector";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_OBJECT = "MessierObjects";

    public static final class MessierObjectEntry implements BaseColumns
    {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_OBJECT).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_OBJECT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_OBJECT;

        public static final String TABLE_NAME = "messier_objects";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_OBJECT_CODE = "object_code";
        public static final String COLUMN_OBJECT_SEEN = "object_seen";
        public static final String COLUMN_OBJECT_NAME = "object_name";
        public static final String COLUMN_OBJECT_DESC = "object_desc";
        public static final String COLUMN_OBJECT_APARENTMAG = "object_aparentmag";
        public static final String COLUMN_OBJECT_DISTANCE = "object_distance";

        public static Uri buildLocationUri(long id)
        {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

}
