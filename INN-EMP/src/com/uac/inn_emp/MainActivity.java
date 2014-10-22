package com.uac.inn_emp;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setIcon(R.drawable.ic_drawer);
        setTitle("");
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00838f")));
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        
        List<MenuPrincipal> LstObj= new ArrayList<MenuPrincipal>();
        LstObj.add(new MenuPrincipal("GLOSARIO","glosario"));
		LstObj.add(new MenuPrincipal("CONVOCATORIAS","convocatorias"));
		LstObj.add(new MenuPrincipal("TIPS","tips"));
		LstObj.add(new MenuPrincipal("EMPRENDEDOR","emprendedor"));
		LstObj.add(new MenuPrincipal("HERRAMIENTAS","herramientas"));
		LstObj.add(new MenuPrincipal("DOCUMENTOS","documentos"));
		LstObj.add(new MenuPrincipal("CONTACTO","contacto"));
		
		mDrawerList.setAdapter( new MenuAdaptador(this, R.layout.menu_adaptador, LstObj ) );
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        getActionBar().setHomeButtonEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.ic_drawer,0,0) {
            public void onDrawerClosed(View view) {invalidateOptionsMenu();}
            public void onDrawerOpened(View drawerView) {invalidateOptionsMenu();}
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
		
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch(item.getItemId()) {
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private void selectItem(int position) {
    	Fragment frag = null;
        switch (position) {
        case 0:
        	frag = new Conceptos(this);
            break;
        case 4:
        	frag = new Herramientas(this);
            break;
        case 6:
        	frag = new Contacto(this);
            break;
        default:
        	Toast.makeText(getApplicationContext(),"no disponible! "+position, Toast.LENGTH_LONG).show();
        }
        if (frag != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, frag).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            mDrawerLayout.closeDrawer(mDrawerList);
            
        }
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main_actions, menu);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		return super.onCreateOptionsMenu(menu);
	}
}