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
        TextView code_content = (TextView) view.findViewById(R.id.Object_Code);
        code_content.setText(cursor.getString(cursor.getColumnIndex(MessierObjectDbHelper.COLUMN_OBJECT_CODE)));
        TextView name_content = (TextView) view.findViewById(R.id.Object_Name);
        name_content.setText(cursor.getString(cursor.getColumnIndex(MessierObjectDbHelper.COLUMN_OBJECT_NAME)));
        TextView desc_content = (TextView) view.findViewById(R.id.Object_Desc);
        desc_content.setText(cursor.getString(cursor.getColumnIndex(MessierObjectDbHelper.COLUMN_OBJECT_DESC)));
        ImageView imageView = (ImageView) view.findViewById(R.id.object_image);
        Integer actualObject = cursor.getPosition()+1;
        String actualImage ="m"+ actualObject.toString();
        imageView.setImageResource(context.getResources().getIdentifier(actualImage, "drawable", context.getPackageName()));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.messier_object, parent, false);
    }

}
