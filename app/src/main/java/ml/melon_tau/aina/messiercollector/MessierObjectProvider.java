package ml.melon_tau.aina.messiercollector;

/**
 * Created by aina on 13/06/15.
 */


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class MessierObjectProvider extends ContentProvider {



    public static final String PROVIDER_NAME = "ml.melon_tau.aina.messiercollector.objects";

    /** A uri to do operations on cust_master table. A content provider is identified by its uri */
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/messierobjects" );

    /** Constants to identify the requested operation */
    private static final int MESSIEROBJECT = 1;



    // The URI Matcher used by this content provider.
    private static final UriMatcher uriMatcher ;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "messierobjects", MESSIEROBJECT);
    }

    MessierObjectDbHelper mMessierObjectDB;

    @Override
    public boolean onCreate() {
        mMessierObjectDB = new MessierObjectDbHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        if(uriMatcher.match(uri)==MESSIEROBJECT){
            return mMessierObjectDB.getAllObjects();
        }else{
            return null;
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO Auto-generated method stub
        return 0;
    }



    }