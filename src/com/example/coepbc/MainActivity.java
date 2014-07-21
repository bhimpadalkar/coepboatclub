package com.example.coepbc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

  private DrawerLayout drawerLayout;
  private ListView drawerList;
  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
//    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.app_title);
    setContentView(R.layout.main);

    createDrawer();
    createButton(R.id.history_button, HistoryActivity.class);
    createButton(R.id.regatta_button, RegattaActivity.class);
    createButton(R.id.contact_us_button, ContactActivity.class);
  }

  private void createButton(int buttonId, final Class activityClass) {
    Button button = (Button) findViewById(buttonId);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent =  new Intent(MainActivity.this, activityClass);
        startActivity(intent);
      }
    });
  }

  private void createDrawer() {
//    CharSequence drawerTitle = getTitle();
//    String[] menuTitles = getResources().getStringArray(R.array.menu_list_array);
//    drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//    drawerList = (ListView) findViewById(R.id.left_drawer);
//
//    ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.drawer, R.drawable.drawer, R.drawable.drawer){
//      @Override
//      public void onDrawerClosed(View view){
//        super.onDrawerClosed(view);
//      }
//
//      @Override
//      public void onDrawerOpened(View view){
//        super.onDrawerOpened(view);
//      }
//    };
//
//    drawerLayout.setDrawerListener(drawerToggle);
//
//    drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.menu_item, menuTitles));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.activity_main_actions, menu);

    return super.onCreateOptionsMenu(menu);
  }
}
