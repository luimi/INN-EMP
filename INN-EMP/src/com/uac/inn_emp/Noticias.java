package com.uac.inn_emp;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Noticias extends Fragment{
	private ListView lv;
	private Context cont;
	public Noticias(Context c){
		cont=c;
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment_noticias, container, false);
    	lv=(ListView) rootView.findViewById(R.id.ListaNoticias);
    	new AsyncConector(cont, lv).execute();
        return rootView;
    }
    @Override 
    public void onActivityCreated(Bundle savedInstanceState) { 
    	super.onActivityCreated(savedInstanceState);
    	
    	
    }
	private Typeface Letra(){
		return Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
	}
	
}
