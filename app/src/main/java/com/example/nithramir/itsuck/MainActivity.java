package com.example.nithramir.itsuck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    ArrayAdapter<String> adapter;
    ConstraintLayout layout;
    ListView search_prop;
    ViewStub stub;
    Context context;
    Menu menu;
    DrawerLayout main_view;
    String pseudo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        View frag =  findViewById(R.id.details_fragment);
        frag.setVisibility(View.GONE);
        //main_view = (DrawerLayout) DrawerLayout.inflate(this, R.layout.activity_main, null);
        /*View view = CoordinatorLayout.inflate(this, R.layout.app_bar_main, null);
        FrameLayout yolo = (FrameLayout) findViewById(R.id.frame_layout);
        yolo.addView(view);
        yolo.removeView(findViewById(R.id.search_prop));
        layout = (ConstraintLayout)ConstraintLayout.inflate(this, R.layout.list_elem, null);*/

        ObjectItem[] ObjectItemData = new ObjectItem[1];
        ObjectItemData[0] = new ObjectItem(91, "Entreprise");
        list_elem adapter = new list_elem(context, R.layout.list_elem, ObjectItemData);
        ListView listViewItems = (ListView) findViewById(R.id.search_prop);
        listViewItems.setAdapter(adapter);
        Log.e("arrive","ici");
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("yolo","test");
                if (id == R.id.itsuck){
                    int duration = Toast.LENGTH_SHORT;

                }
            }
        });



        //yolo.removeView(findViewById(R.id.search_prop));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        ConstraintLayout layout = (ConstraintLayout)ConstraintLayout.inflate(this, R.layout.list_elem, null);

        /*drawer.removeView(findViewById(R.id.inscription));
        */

        /*search_prop = (ListView) findViewById(R.id.search_prop);
        ArrayList<String> array_prop = new ArrayList<String>();
        array_prop.addAll(Arrays.asList(getResources().getStringArray(R.array.array_search)));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_prop);
        search_prop.setAdapter(adapter);*/


       NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public Menu get_menu(){
        return (menu) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                Menu men = get_menu();
                MenuItem item = men.findItem(R.id.search);
                invalidateOptionsMenu();
                ObjectItem[] ObjectItemData = new ObjectItem[1];
                ObjectItemData[0] = new ObjectItem(91, "Entreprise");
                list_elem adapter = new list_elem(context, R.layout.list_elem, ObjectItemData);
                ListView listViewItems = (ListView) findViewById(R.id.search_prop);
                listViewItems.setAdapter(adapter);


                return false;
            }
            @Override
            public boolean onQueryTextChange(String newtext){
                search_prop = (ListView) findViewById(R.id.search_prop);
                ArrayList<String> array_prop = new ArrayList<>();
                array_prop.addAll(Arrays.asList(getResources().getStringArray(R.array.array_search)));
                adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, array_prop);
                search_prop.setAdapter(adapter);
                adapter.getFilter().filter(newtext);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        Log.e("test","test2");
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.e("test","test2");
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Log.e("fuck", "it2");
        if (id == R.id.worst_marque) {
            new Most_hated(this, layout);

            // Handle the camera action
        } else if (id == R.id.worst_sites) {
            new Most_hated(this, layout);

        } else if (id == R.id.random){
            new Most_hated(this, layout);

        } else if (id == R.id.best_comment) {

        } else if (id == R.id.worst_marque) {
            new Most_hated(this, layout);

        }else if (id == R.id.new_marques) {
            new Most_hated(this, layout);
        } else if (id == R.id.connection) {
            ListView listViewItems = (ListView) findViewById(R.id.search_prop);
            listViewItems.setVisibility(View.GONE);

            View frag =  findViewById(R.id.details_fragment);
        frag.setVisibility(View.VISIBLE);

            /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.inscription).setVisible(false);*/
            //startActivity(new Intent(this, connection.class));
            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            yolo.removeView(view);*/
        } else if (id == R.id.inscription) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
