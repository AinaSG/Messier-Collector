package ml.melon_tau.aina.messiercollector;

import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        final Context context = getActivity();
        Bundle bun = getArguments();
        View view = inflater.inflate(R.layout.messier_object_details, container, false);
        //Pillar els camps
        TextView code_content = (TextView) view.findViewById(R.id.objectcode);
        TextView name_content = (TextView) view.findViewById(R.id.objectname);
        TextView desc_content = (TextView) view.findViewById(R.id.objectdescription);
        TextView magn_content = (TextView) view.findViewById(R.id.magnitudefield);
        TextView dist_content = (TextView) view.findViewById(R.id.distancefield);
        ImageView image_content = (ImageView) view.findViewById(R.id.objectimage);
        //Pillat el content
        Bundle args = getArguments();
        final String ob_code = args.getString("ob_code");
        String ob_name = args.getString("ob_name");
        String ob_desc = args.getString("ob_desc");
        final Integer actualObject = args.getInt("ob_which");
        Float ob_magn = args.getFloat("ob_magn");
        Float ob_dist = args.getFloat("ob_dist");
        //Assignar el content
        code_content.setText(ob_code);
        name_content.setText(ob_name);
        desc_content.setText(ob_desc);
        magn_content.setText(ob_magn.toString());
        dist_content.setText(ob_dist.toString() + " (*1,000 light years)");
        //Posem la imatge
        String actualImage ="m"+ actualObject.toString();
        image_content.setImageResource(context.getResources().getIdentifier(actualImage, "drawable", context.getPackageName()));

        //Programar el comportament del botó
        Button buttonskymap = (Button) view.findViewById(R.id.buttonskymap);
        buttonskymap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_SEARCH);
                i.setPackage("com.google.android.stardroid");
                i.putExtra(SearchManager.QUERY, ob_code);
                startActivity(i);
            }

        });


        //Not working well ;_;
        Button buttonskeye = (Button) view.findViewById(R.id.buttonskeye);
        buttonskeye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String objPath = "astro_object//messier/m" + actualObject.toString();
                Log.d("OBJ", objPath);
                Log.d("OBJ", "["+objPath+"]");
                Intent skEyeIntent = new Intent(Intent.ACTION_SEARCH);
                final Uri targetUri = new Uri.Builder().path(objPath).build();
                skEyeIntent.setDataAndType(targetUri, "text/astro_object");
                startActivity(skEyeIntent);
            }
        });

        return view;
    }
}
