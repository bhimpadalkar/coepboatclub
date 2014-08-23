package com.example.coepbc;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.coepbc.tabs.HistoryFragment;
import com.example.coepbc.tabs.HomeFragment;
import com.example.coepbc.tabs.RegattaFragment;

public class MainActivity extends Activity {

  private static final int HOME_MENU_POSITION = 0;
  private static final int HISTORY_MENU_POSITION = 1;
  private static final int REGATTA_MENU_POSITION = 2;
  private DrawerLayout drawerLayout;
  private String[] menuTitles;
  private ListView drawerList;
  private ActionBarDrawerToggle drawerToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setHomeButtonEnabled(true);
    initializeDrawer();
    selectMenu(HOME_MENU_POSITION);
  }

  private void initializeDrawer() {
    menuTitles = getResources().getStringArray(R.array.menu_list_array);
    drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawerList = (ListView) findViewById(R.id.left_drawer);

    drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.drawer, R.drawable.drawer, R.drawable.drawer);

    drawerLayout.setDrawerListener(drawerToggle);
    drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.menu_item, menuTitles));

    drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectMenu(position);
      }
    });
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    drawerToggle.syncState();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    drawerToggle.onConfigurationChanged(newConfig);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
  }

  @Override
  public void setTitle(CharSequence title) {
    getActionBar().setTitle(title);
  }

  private void selectMenu(int position) {
    Fragment fragment = getFragment(position);
    FragmentManager fragmentManager = getFragmentManager();

    fragmentManager
        .beginTransaction()
        .replace(R.id.content_frame, fragment)
        .commit();

    drawerList.setItemChecked(position, true);
    setTitle(menuTitles[position]);
    drawerLayout.closeDrawer(drawerList);
  }

  private Fragment getFragment(int position) {
    Fragment fragment;
    switch (position) {
      case HOME_MENU_POSITION:
        fragment = new HomeFragment();
        break;
      case HISTORY_MENU_POSITION:
        fragment = new HistoryFragment();
        break;
      case REGATTA_MENU_POSITION:
        fragment = new RegattaFragment();
        break;
      default:
        fragment = new Fragment();
    }
    return fragment;
  }
}