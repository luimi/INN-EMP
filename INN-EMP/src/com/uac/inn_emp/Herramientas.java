package com.uac.inn_emp;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Herramientas extends Fragment{
	private ListView lv;
	private Context cont;
	private String[] Titulos,Definiciones;
	public Herramientas(Context c){
		cont=c;
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment_herramientas, container, false);
        return rootView;
    }
    @Override 
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);
        
        TabHost tabHost = (TabHost)getActivity().findViewById(android.R.id.tabhost);
        TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        TabSpec tab3 = tabHost.newTabSpec("Third Tab");
        Intent temp=new Intent(cont, TabContenido.class);
        temp.putExtra("Contenido","bla1" );
        
        tab1.setIndicator("Tab1");
        tab1.setContent(temp);

        tab2.setIndicator("Tab2");
        tab2.setContent(temp);

        tab3.setIndicator("Tab3");
        tab3.setContent(temp);
        if(tab1!=null){
        	tabHost.addTab(tab1);
            tabHost.addTab(tab2);
            tabHost.addTab(tab3);
        }
        
        /*
        Titulos = getActivity().getResources().getStringArray(R.array.glosariotitulos);
        Definiciones = getActivity().getResources().getStringArray(R.array.glosariodefiniciones);
        ListView lst = (ListView) getActivity().findViewById(R.id.ListaGlosario);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_1, Titulos);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) { 
              CargarGlosario(position);
            }});
        CargarGlosario(0);
        ((TextView) getActivity().findViewById(R.id.TituloGlosario)).setTypeface(Letra());
        ((TextView) getActivity().findViewById(R.id.ContenidoGlosario)).setTypeface(Letra());
        ((TextView) getActivity().findViewById(R.id.TextoGlosario)).setTypeface(Letra());
        */
        
    }
	private Typeface Letra(){
		return Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
	}
	
}
