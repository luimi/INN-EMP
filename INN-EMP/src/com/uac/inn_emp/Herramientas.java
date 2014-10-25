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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Herramientas extends Fragment implements OnClickListener {
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
        CambiarTexto((TextView) getActivity().findViewById(R.id.ContenidoHerramientas), getActivity().getString(R.string.Prototipaje));
        Button b1=(Button) getActivity().findViewById(R.id.PrototipajeHerramientas);
        Button b2=(Button) getActivity().findViewById(R.id.ResumenHerramientas);
        Button b3=(Button) getActivity().findViewById(R.id.ElevadorHerramientas);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }
	private Typeface Letra(){
		return Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
	}
	public void prototipaje(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PrototipajeHerramientas),R.color.NaranjaRojizo);
		CambiarColor((Button) getActivity().findViewById(R.id.ResumenHerramientas),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.ElevadorHerramientas),R.color.Gris);
		CambiarTexto((TextView) getActivity().findViewById(R.id.ContenidoHerramientas), getActivity().getString(R.string.Prototipaje));
	}
	public void resumen(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PrototipajeHerramientas),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.ResumenHerramientas),R.color.NaranjaRojizo);
		CambiarColor((Button) getActivity().findViewById(R.id.ElevadorHerramientas),R.color.Gris);
		CambiarTexto((TextView) getActivity().findViewById(R.id.ContenidoHerramientas), getActivity().getString(R.string.Prototipaje));
	}
	public void elevador(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PrototipajeHerramientas),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.ResumenHerramientas),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.ElevadorHerramientas),R.color.NaranjaRojizo);
		CambiarTexto((TextView) getActivity().findViewById(R.id.ContenidoHerramientas), getActivity().getString(R.string.Prototipaje));
	}
	private void CambiarColor(Button b,int color){
		b.setBackgroundResource(color);
	}
	private void CambiarTexto(TextView tv,String Texto){
		tv.setText(Texto);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
        case R.id.PrototipajeHerramientas:
        	prototipaje(v);
            break;
        case R.id.ResumenHerramientas:
        	resumen(v);
            break;
        case R.id.ElevadorHerramientas:
        	elevador(v);
            break;
        }
	}
}
