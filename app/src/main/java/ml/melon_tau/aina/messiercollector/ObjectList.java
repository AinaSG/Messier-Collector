package ml.melon_tau.aina.messiercollector;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ObjectList extends Fragment {

    public ObjectList() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.object_list, container, false);
        List<String> placeholderlist = new ArrayList<String>();
        placeholderlist.add("M1 - Andromeda");
        placeholderlist.add("Orion Galaxy");
        placeholderlist.add("M32 - Sombrero Galaxy");
        placeholderlist.add("Mario Galaxy");
        placeholderlist.add("M17 - Orion Galaxy");
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
        placeholderlist.add("Andromeda");
        placeholderlist.add("Orion Galaxy");
        placeholderlist.add("Sombrero Galaxy");
        placeholderlist.add("Mario Galaxy");
        ArrayAdapter <String> messierAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.messier_object, R.id.object_ID, placeholderlist);

        ListView lv = (ListView) rootView.findViewById(R.id.messier_object_list);
        lv.setAdapter(messierAdapter);
        return rootView;
    }
}
