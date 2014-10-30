package com.uac.inn_emp;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
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
		CambiarImagen("herramientas1", (ImageView) getActivity().findViewById(R.id.HerramientasImg1));
		CambiarImagen("herramientas2", (ImageView) getActivity().findViewById(R.id.HerramientasImg2));
	}
	public void resumen(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PrototipajeHerramientas),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.ResumenHerramientas),R.color.NaranjaRojizo);
		CambiarColor((Button) getActivity().findViewById(R.id.ElevadorHerramientas),R.color.Gris);
		CambiarImagen("herramientas3", (ImageView) getActivity().findViewById(R.id.HerramientasImg1));
		CambiarImagen("herramientas4", (ImageView) getActivity().findViewById(R.id.HerramientasImg2));
	}
	public void elevador(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PrototipajeHerramientas),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.ResumenHerramientas),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.ElevadorHerramientas),R.color.NaranjaRojizo);
		CambiarImagen("herramientas5", (ImageView) getActivity().findViewById(R.id.HerramientasImg1));
		CambiarImagen("herramientas6", (ImageView) getActivity().findViewById(R.id.HerramientasImg2));
	}
	private void CambiarColor(Button b,int color){
		b.setBackgroundResource(color);
	}
	private void CambiarTexto(TextView tv,String Texto){
		tv.setText(Texto);
	}
	private void CambiarImagen(String nom,ImageView img){
		String uri = "drawable/" + nom;
		int imageResource = getActivity().getResources().getIdentifier(uri, null,getActivity().getPackageName());
		Drawable image = getActivity().getResources().getDrawable(imageResource);
		img.setImageDrawable(image);
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
