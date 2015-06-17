package ml.melon_tau.aina.messiercollector;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aina on 14/06/15.
 */
public class MessierObjectListAdapter extends CursorAdapter {

    private LayoutInflater mInflater;

    public MessierObjectListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //Buscant els camps que popular
        TextView code_content = (TextView) view.findViewById(R.id.Object_Code);
        TextView name_content = (TextView) view.findViewById(R.id.Object_Name);
        TextView desc_content = (TextView) view.findViewById(R.id.Object_Desc);
        ImageView imageView = (ImageView) view.findViewById(R.id.object_image);

        //Traiem propietats del cursor
        String code = cursor.getString(cursor.getColumnIndexOrThrow("object_code"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("object_name"));
        String desc = cursor.getString(cursor.getColumnIndexOrThrow("object_desc"));

        //Populem els camps amb lo extret
        code_content.setText(code);
        name_content.setText(name);
        desc_content.setText(desc);

        //Populem la imatge que toca
        Integer actualObject = cursor.getPosition()+1;
        String actualImage ="m"+ actualObject.toString();
        imageView.setImageResource(context.getResources().getIdentifier(actualImage, "drawable", context.getPackageName()));

        if (cursor.getInt(cursor.getColumnIndexOrThrow("object_seen")) != 0){
            view.setBackgroundColor(context.getResources().getColor(R.color.darkred));
        }
        else {
            view.setBackgroundColor(context.getResources().getColor(R.color.green));
        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.messier_object, parent, false);
    }

}
