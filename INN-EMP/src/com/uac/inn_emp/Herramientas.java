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
