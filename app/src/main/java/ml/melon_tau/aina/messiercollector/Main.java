package ml.melon_tau.aina.messiercollector;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Main extends Activity{

   /* MessierObjectListAdapter mAdapter;
    Cursor messierCursor;
    SQLiteDatabase datbas;
    ListView mListView;*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.object_list);
        setContentView(R.layout.activity_main);
      /*  final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment, new MessierObjectListFragment(), "MessierListTag");
        //ft.addToBackStack(null);
        ft.commit();*/

        /*MessierObjectDbHelper MesObHelp = new MessierObjectDbHelper(this);
        datbas = MesObHelp.getWritableDatabase();
        messierCursor = datbas.rawQuery("SELECT * FROM messier_objects", null);

        mListView = (ListView) findViewById(R.id.messier_object_list);

        mAdapter = new MessierObjectListAdapter(this, messierCursor, 0);
        mListView.setAdapter(mAdapter);

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
                String seen = messierCursor.getString(messierCursor.getColumnIndexOrThrow("object_seen"));
                String q = "UPDATE messier_objects SET object_seen = 1 WHERE _id = " + s;
                if ( seen.equals("1")) {

                    q = "UPDATE messier_objects SET object_seen = 0 WHERE _id = " + s;
                }
                datbas.execSQL(q);
                Cursor newmessierCursor = datbas.rawQuery("SELECT * FROM messier_objects", null);
                mAdapter.swapCursor(newmessierCursor);
                messierCursor = newmessierCursor;
                Toast.makeText(getApplicationContext(),
                        "Click llarg a l'objecte M" + (position +1), Toast.LENGTH_LONG)
                        .show();
                return true;
            }
        });*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
