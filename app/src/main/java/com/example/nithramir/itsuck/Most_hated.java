package com.example.nithramir.itsuck;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Nithramir on 05/07/2017.
 */

public class Most_hated {
    Activity act;
    ConstraintLayout layout;
    public Most_hated(Context activity, ConstraintLayout layout){
        this.act = (Activity)activity;

        ObjectItem[] ObjectItemData = new ObjectItem[14];
        ObjectItemData[0] = new ObjectItem(91, "Entreprise");
        ObjectItemData[1] = new ObjectItem(91, "Entreprise");
        ObjectItemData[2] = new ObjectItem(91, "Entreprise");
        ObjectItemData[3] = new ObjectItem(91, "Entreprise");
        ObjectItemData[4] = new ObjectItem(91, "Entreprise");
        ObjectItemData[5] = new ObjectItem(91, "Entreprise");
        ObjectItemData[6] = new ObjectItem(91, "Entreprise");
        ObjectItemData[7] = new ObjectItem(91, "Entreprise");
        ObjectItemData[8] = new ObjectItem(91, "Entreprise");
        ObjectItemData[9] = new ObjectItem(91, "Entreprise");
        ObjectItemData[10] = new ObjectItem(91, "Entreprise");
        ObjectItemData[11] = new ObjectItem(91, "Entreprise");
        ObjectItemData[12] = new ObjectItem(91, "Entreprise");
        ObjectItemData[13] = new ObjectItem(91, "Entreprise");
        list_elem adapter = new list_elem(act, R.layout.list_elem, ObjectItemData);
        ListView listViewItems = (ListView) this.act.findViewById(R.id.search_prop);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("yolo","test");
                if (id == R.id.itsuck){
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(act, "It_Suck", duration);
                    toast.show();
                }
            }
        });
        listViewItems.setVisibility(View.VISIBLE);
        View frag =  this.act.findViewById(R.id.details_fragment);
        frag.setVisibility(View.GONE);




    }
}
