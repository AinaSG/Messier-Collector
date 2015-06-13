package ml.melon_tau.aina.messiercollector;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ObjectListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int MESSIEROBJECT_LOADER = 0;
    // For the forecast view we're showing only a small subset of the stored data.
    // Specify the columns we need.
    private static final String[] OBJECTLIST_COLUMNS = {
            // In this case the id needs to be fully qualified with a table name, since
            // the content provider joins the location & weather tables in the background
            // (both have an _id column)
            // On the one hand, that's annoying.  On the other, you can search the weather table
            // using the location set by the user, which is only in the Location table.
            // So the convenience is worth it.
            MessierObjectContract.MessierObjectEntry.TABLE_NAME + "." + MessierObjectContract.MessierObjectEntry._ID,
            MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_SEEN,
            MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_CODE,
            MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_NAME,
    };

    // These indices are tied to FORECAST_COLUMNS.  If FORECAST_COLUMNS changes, these
    // must change.
    static final int COL_OBJECT_ID = 0;
    static final int COL_OBJECT_SEEN = 1;
    static final int COL_OBJECT_CODE = 2;
    static final int COL_OBJECT_NAME = 3;

    private CursorAdapter messierAdapter;


    public ObjectListFragment() {
    }

    private long addObject(String code, String name, String desc, int magni, int diameter) {
        long locationId;

        // First, check if the location with this city name exists in the db
        Cursor locationCursor = getActivity().getContentResolver().query(
                MessierObjectContract.MessierObjectEntry.CONTENT_URI,
                new String[]{MessierObjectContract.MessierObjectEntry._ID},
                MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_CODE + " = ?",
                new String[]{code},
                null);

        if (locationCursor.moveToFirst()) {
            Log.d("potato", "movetofirst");
            int locationIdIndex = locationCursor.getColumnIndex(MessierObjectContract.MessierObjectEntry._ID);
            locationId = locationCursor.getLong(locationIdIndex);
        } else {
            Log.d("potato", "elsemovetofirst");
            // Now that the content provider is set up, inserting rows of data is pretty simple.
            // First create a ContentValues object to hold the data you want to insert.
            ContentValues locationValues = new ContentValues();

            // Then add the data, along with the corresponding name of the data type,
            // so the content provider knows what kind of value is being inserted.
            locationValues.put(MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_CODE, code);
            locationValues.put(MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_NAME, name);
            locationValues.put(MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_DESC, desc);
            locationValues.put(MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_APARENTMAG, magni);
            locationValues.put(MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_DIAMETER, diameter);

            // Finally, insert location data into the database.
            Log.d("potato", "preinsert");

            Uri insertedUri = getActivity().getContentResolver().insert(
                    MessierObjectContract.MessierObjectEntry.CONTENT_URI,
                    locationValues
            );
            Log.d("potato", "postinsert");

            // The resulting URI contains the ID for the row.  Extract the locationId from the Uri.
            locationId = ContentUris.parseId(insertedUri);
        }

        locationCursor.close();
        // Wait, that worked?  Yes!
        return locationId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.object_list, container, false);
        /*List<String> placeholderlist = new ArrayList<String>();
        placeholderlist.add("M1 - Crab Nebula");
        placeholderlist.add("M2 - Globular Cluster");
        placeholderlist.add("M3 - Globular Cluster");
        placeholderlist.add("M4 - Mario Galaxy");
        placeholderlist.add("M5 - Globular Cluster");
        placeholderlist.add("M6 - Butterfly Cluster");
        placeholderlist.add("M7 - Ptolemy Cluster");
        placeholderlist.add("Andromeda");
        placeholderlist.add("Orion Galaxy");
        placeholderlist.add("Sombrero Galaxy");
        placeholderlist.add("Mario Galaxy");
        placeholderlist.add("Andromeda");
        placeholderlist.add("Orion Galaxy");
        placeholderlist.add("Sombrero Galaxy");
        placeholderlist.add("Mario Galaxy");
        placeholderlist.add("Andromeda");
        placeholderlist.add("Orion Galaxy");
        placeholderlist.add("Sombrero Galaxy");
        placeholderlist.add("Mario Galaxy");
        messierAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.messier_object, R.id.object_ID, placeholderlist);*/
        addObject("1", "Biuriful sinc", "Dis is biuriful", 34, 4);
        addObject("2", "Ugli sinc", "Dis is ugli", 45, 6);
        addObject("3", "Neddy sinc", "Dis is nerdy", 12, 5);
        addObject("4", "Joan sinc", "Dis is joan", 20, 400);
        addObject("5", "Aina sinc", "Dis is aina", 20, 4);
        Log.d("potato", " prelistview <3");
        ListView lv = (ListView) rootView.findViewById(R.id.messier_object_list);
        Log.d("potato", " postlistview <3");
        lv.setAdapter(messierAdapter);
        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Log.d("potato", "onCreateLoader <3");
        // Sort order:  Ascending, by date.
        String sortOrder = MessierObjectContract.MessierObjectEntry.COLUMN_OBJECT_CODE + " ASC";
        Uri weatherForLocationUri = MessierObjectContract.MessierObjectEntry.buildMessierObjectUri(1);

        return new CursorLoader(getActivity(),
                weatherForLocationUri,
                OBJECTLIST_COLUMNS,
                null,
                null,
                sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        Log.d("potato", "OnLoadFinished <3");
        messierAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        messierAdapter.swapCursor(null);
    }
}
