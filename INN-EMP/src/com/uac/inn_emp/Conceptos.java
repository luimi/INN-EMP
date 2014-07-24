package com.uac.inn_emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class Conceptos extends Fragment{
	private ListView lv;
	private Context cont;
	public Conceptos(Context c){
		cont=c;
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.listado, container, false);
        return rootView;
    }
    @Override 
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        HashMap<String, List<String>> definiciones = new HashMap<String, List<String>>();
        
        List<String> titulos= Lista(getResources().getStringArray(R.array.definicion));
        definiciones.put(titulos.get(0), Lista(getResources().getStringArray(R.array.definicion)));
        
        ExpandableListView expListView = (ExpandableListView) getActivity().findViewById(R.id.lista);
           
        
        ExpandableListAdapter listAdapter = new ExpandableListAdapter(cont, titulos, definiciones);
        expListView.setAdapter(listAdapter);
    }

	private List<String> Lista(String [] t) {
		List<String> te=new ArrayList<String>();
		for (int i = 0; i < t.length; i++) {
			te.add(t[i]);
		}
		return te;
	} 
	
}
