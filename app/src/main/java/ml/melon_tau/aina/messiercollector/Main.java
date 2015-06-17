package ml.melon_tau.aina.messiercollector;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ml.melon_tau.aina.messiercollector.data.MessierObjectDbHelper;


public class Main extends Activity /*implements LoaderManager.LoaderCallbacks<Cursor> */{

    MessierObjectListAdapter mAdapter;
    Cursor messierCursor;
    SQLiteDatabase datbas;
    ListView mListView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_list);

        MessierObjectDbHelper MesObHelp = new MessierObjectDbHelper(this);
        datbas = MesObHelp.getWritableDatabase();
        messierCursor = datbas.rawQuery("SELECT * FROM messier_objects", null);

        mListView = (ListView) findViewById(R.id.messier_object_list);

        mAdapter = new MessierObjectListAdapter(this, messierCursor, 0);
        mListView.setAdapter(mAdapter);
        //getLoaderManager().initLoader(0, null, this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Has seleccionat l'objecte M" + (position + 1), Toast.LENGTH_LONG)
                        .show();
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                messierCursor.moveToPosition(position);
                String s = messierCursor.getString(messierCursor.getColumnIndexOrThrow("_id"));
                String q = "UPDATE messier_objects SET object_seen = 1 WHERE _id = " + s;
                datbas.execSQL(q);
                Cursor newmessierCursor = datbas.rawQuery("SELECT * FROM messier_objects", null);
                mAdapter.swapCursor(newmessierCursor);
                Toast.makeText(getApplicationContext(),
                        "Click llarg a l'objecte M" + (position +1), Toast.LENGTH_LONG)
                        .show();
                return true;
            }
        });

    }


/*
    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        Uri uri = MessierObjectContract.MessierObjectEntry.CONTENT_URI;
        return new CursorLoader(this, uri, null, null, null, null);
    }

    */
/** A callback method, invoked after the requested content provider returned all the data *//*

    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
        mAdapter.swapCursor(arg1);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> arg0) {
        mAdapter.swapCursor(null);
    }
*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
