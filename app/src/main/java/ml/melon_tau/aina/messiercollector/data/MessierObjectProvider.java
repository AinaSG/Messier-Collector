package ml.melon_tau.aina.messiercollector.data;

/**
 * Created by aina on 13/06/15.
 */


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class MessierObjectProvider extends ContentProvider {


    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private MessierObjectDbHelper mOpenHelper;

    private static final SQLiteQueryBuilder sMessierObjectQueryBuilder;

    static{
        sMessierObjectQueryBuilder = new SQLiteQueryBuilder();
    }

    static UriMatcher buildUriMatcher()
    {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = MessierObjectContract.CONTENT_AUTHORITY;
        return matcher;
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new MessierObjectDbHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) { return MessierObjectContract.MessierObjectEntry.CONTENT_TYPE;}

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder)
    {
        Cursor retCursor = mOpenHelper.getReadableDatabase().query(
                MessierObjectContract.MessierObjectEntry.TABLE_NAME,
                projection, selection, selectionArgs, null, null, sortOrder );
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        long _id = db.insert(MessierObjectContract.MessierObjectEntry.TABLE_NAME, null, values);
        Uri returnUri = MessierObjectContract.MessierObjectEntry.buildLocationUri(_id);
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsDeleted;
        if ( null == selection ) selection = "1";
        rowsDeleted = db.delete(
                MessierObjectContract.MessierObjectEntry.TABLE_NAME, selection, selectionArgs);
        if (rowsDeleted != 0) getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsUpdated;
        rowsUpdated = db.update(MessierObjectContract.MessierObjectEntry.TABLE_NAME, values, selection,
                selectionArgs);
        if (rowsUpdated != 0)  getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }




}