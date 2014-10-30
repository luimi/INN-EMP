package com.uac.inn_emp;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Convocatorias extends Fragment implements OnClickListener {
	private ListView lv;
	private Context cont;
	private String[] Titulos,Definiciones;
	public Convocatorias(Context c){
		cont=c;
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment_convocatorias, container, false);
        return rootView;
    }
    @Override 
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);
        //CambiarTexto((TextView) getActivity().findViewById(R.id.ContenidoHerramientas), getActivity().getString(R.string.Prototipaje));
        Button b1=(Button) getActivity().findViewById(R.id.PublicaConvocatorias);
        Button b2=(Button) getActivity().findViewById(R.id.PrivadasNacConvocatorias);
        Button b3=(Button) getActivity().findViewById(R.id.PrivadasIntConvocatorias);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        lv=(ListView) getActivity().findViewById(R.id.ListaConvocatorias);
        AgregarListado(getResources().getStringArray(R.array.ConvPub));
    }
	private Typeface Letra(){
		return Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
	}
	public void Publicas(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PublicaConvocatorias),R.color.NaranjaRojizo);
		CambiarColor((Button) getActivity().findViewById(R.id.PrivadasNacConvocatorias),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.PrivadasIntConvocatorias),R.color.Gris);
		AgregarListado(getResources().getStringArray(R.array.ConvPub));
		//CambiarTexto((TextView) getActivity().findViewById(R.id.ContenidoHerramientas), getActivity().getString(R.string.Prototipaje));
	}
	private void AgregarListado(String[] l) {
		ArrayList<Convocatoria> conv=new ArrayList<Convocatoria>();
		for (int i = 0; i < l.length; i++) {
			String[] t=l[i].split(",");
			conv.add(new Convocatoria(t[0], t[1], t[2]));
		}
		ArrayAdapter_Convocatorias ad=new ArrayAdapter_Convocatorias(getActivity(), conv);
		lv.setAdapter(ad);
		lv.setOnItemClickListener(new ClickConvocatoria(conv));
	}
	private class ClickConvocatoria implements ListView.OnItemClickListener {
		ArrayList<Convocatoria> conv;
		public ClickConvocatoria(ArrayList<Convocatoria> conv){
			this.conv=conv;
		}
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	Navegar(conv.get(position).link);
        }
    }
	public void Navegar(String url){
		Intent browserIntent = new Intent(Intent.ACTION_VIEW);
		browserIntent.setData(Uri.parse(url));
    	startActivity(browserIntent);
	}
	public void PrivadasNac(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PublicaConvocatorias),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.PrivadasNacConvocatorias),R.color.NaranjaRojizo);
		CambiarColor((Button) getActivity().findViewById(R.id.PrivadasIntConvocatorias),R.color.Gris);
		AgregarListado(getResources().getStringArray(R.array.ConvPriNac));
	}
	public void PrivadasInt(View v){
		CambiarColor((Button) getActivity().findViewById(R.id.PublicaConvocatorias),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.PrivadasNacConvocatorias),R.color.Gris);
		CambiarColor((Button) getActivity().findViewById(R.id.PrivadasIntConvocatorias),R.color.NaranjaRojizo);
		AgregarListado(getResources().getStringArray(R.array.ConvPriInt));
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
        case R.id.PublicaConvocatorias:
        	Publicas(v);
            break;
        case R.id.PrivadasNacConvocatorias:
        	PrivadasNac(v);
            break;
        case R.id.PrivadasIntConvocatorias:
        	PrivadasInt(v);
            break;
        }
	}
}
