package com.example.nithramir.itsuck;

/**
 * Created by Nithramir on 25/06/2017.
 */



import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// here's our beautiful adapter
public class list_elem extends ArrayAdapter<ObjectItem>{

    Context mContext;
    int layoutResourceId;
    ObjectItem data[] = null;

    public list_elem(Context mContext, int layoutResourceId, ObjectItem[] data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row layout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
         */
        if (convertView == null) {
            // inflate the layout
            /*LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);*/
            convertView = (View) ConstraintLayout.inflate(this.mContext, layoutResourceId, null);
        }

        // object item based on the position
        ObjectItem objectItem = data[position];

        // get the TextView and then set the text (item name) and tag (item ID) values
        /*TextView textViewItem = (TextView) convertView.findViewById(R.id.Name);
        textViewItem.setText(objectItem.itemName);
        textViewItem.setTag(objectItem.itemId);*/

        return convertView;

    }


}