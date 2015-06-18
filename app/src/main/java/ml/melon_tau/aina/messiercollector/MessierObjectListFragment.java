package ml.melon_tau.aina.messiercollector;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ml.melon_tau.aina.messiercollector.data.MessierObjectDbHelper;

/**
 * Created by aina on 18/06/15.
 */
public class MessierObjectListFragment extends Fragment {

    MessierObjectListAdapter mAdapter;
    Cursor messierCursor;
    SQLiteDatabase datbas;
    ListView mListView;

    public MessierObjectListFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        //Fer coses rares natsis

        final Context cont = getActivity();

        View fragView = inflater.inflate(R.layout.object_list, container, false);
        MessierObjectDbHelper MesObHelp = new MessierObjectDbHelper(cont);
        datbas = MesObHelp.getWritableDatabase();
        messierCursor = datbas.rawQuery("SELECT * FROM messier_objects", null);
        mListView = (ListView) fragView.findViewById(R.id.messier_object_list);
        mAdapter = new MessierObjectListAdapter(cont, messierCursor, 0);
        mListView.setAdapter(mAdapter);


        //CLICK ////////////////////////////////////////////////////////////////////////////////////
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment, new MessierObjectInfoFragment(), "MessierInfoTag");
                ft.addToBackStack(null);
                ft.commit();
                Toast.makeText(cont,
                        "Has seleccionat l'objecte M" + (position + 1), Toast.LENGTH_LONG)
                        .show();
            }
        });


        // LONG CLICK //////////////////////////////////////////////////////////////////////////////
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
                Toast.makeText(cont,
                        "Click llarg a l'objecte M" + (position +1), Toast.LENGTH_LONG)
                        .show();
                return true;
            }
        });



        return fragView;
    }
}


