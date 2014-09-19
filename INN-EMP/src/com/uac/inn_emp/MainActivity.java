package com.uac.inn_emp;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String[] Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#25AEC5")));
        Menu = getResources().getStringArray(R.array.menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        
        List<MenuPrincipal> LstObj= new ArrayList<MenuPrincipal>();
        LstObj.add(new MenuPrincipal("GLOSARIO","glosario"));
		LstObj.add(new MenuPrincipal("CONVOCATORIAS","convocatorias"));
		LstObj.add(new MenuPrincipal("TIPS","tips"));
		mDrawerList.setAdapter( new MenuAdaptador(this, R.layout.menu_adaptador, LstObj ) );
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

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
        default:
        	Toast.makeText(getApplicationContext(),"no disponible! "+position, Toast.LENGTH_LONG).show();
        }
        if (frag != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, frag).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(Menu[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
            
        }
    }
   
}