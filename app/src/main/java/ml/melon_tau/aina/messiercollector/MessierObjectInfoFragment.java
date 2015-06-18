package ml.melon_tau.aina.messiercollector;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aina on 17/06/15.
 */
public class MessierObjectInfoFragment extends Fragment {

    public MessierObjectInfoFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bun = getArguments();
        View view = inflater.inflate(R.layout.messier_object_details, container, false);
        //Pillar els camps
        TextView code_content = (TextView) view.findViewById(R.id.objectcode);
        TextView name_content = (TextView) view.findViewById(R.id.objectname);
        ImageView image_content = (ImageView) view.findViewById(R.id.objectimage);
        //Pillat el content
        //Assignar el content
        return view;
    }
}
