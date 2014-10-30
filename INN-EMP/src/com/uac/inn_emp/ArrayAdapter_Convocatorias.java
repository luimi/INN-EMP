package com.uac.inn_emp;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrayAdapter_Convocatorias extends ArrayAdapter<Convocatoria>{
	Context context;
	public ArrayAdapter_Convocatorias(Context context,ArrayList<Convocatoria> Convocatoria) {
		super(context, 0, Convocatoria);
		this.context=context;
	}
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		Convocatoria no = getItem(position);    
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_convocatoria, parent, false);
       }
       TextView titulo = (TextView) convertView.findViewById(R.id.ConvocatoriaTitulo);
       TextView web = (TextView) convertView.findViewById(R.id.ConvocatoriaWeb);
       ImageView img = (ImageView) convertView.findViewById(R.id.ConvocatoriaLogo);
       titulo.setText(no.titulo);
       web.setText(no.link);
       String uri = "drawable/" + no.img;
		int imageResource = context.getResources().getIdentifier(uri, null,context.getPackageName());
		Drawable image = context.getResources().getDrawable(imageResource);
		img.setImageDrawable(image);
       return convertView;
   }
	

}
