package com.uac.inn_emp;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import co.edu.uac.inn_emp.R;

public class Contacto extends Fragment{
	private ListView lv;
	private Context cont;
	private String[] Titulos,Definiciones;
	public Contacto(Context c){
		cont=c;
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment_contacto, container, false);
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
