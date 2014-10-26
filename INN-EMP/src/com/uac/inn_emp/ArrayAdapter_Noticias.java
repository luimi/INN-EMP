package com.uac.inn_emp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ArrayAdapter_Noticias extends ArrayAdapter<Noticia>{

	public ArrayAdapter_Noticias(Context context,ArrayList<Noticia> noticia) {
		super(context, 0, noticia);
	}
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Noticia no = getItem(position);    
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_noticias, parent, false);
       }
       TextView titulo = (TextView) convertView.findViewById(R.id.Titulo_AdaptadorNoticia);
       WebView wb = (WebView) convertView.findViewById(R.id.wb_AdaptadorNoticia);
       titulo.setText(no.titulo);
       wb.loadDataWithBaseURL("", no.img, "text/html", "UTF-8", "");
       return convertView;
   }
	

}
