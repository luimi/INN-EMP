package com.uac.inn_emp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class AsyncConector extends AsyncTask<Void, Void, Void> {
	ArrayList<Noticia> noticias=new ArrayList<Noticia>();
	private String url="http://www.uac.edu.co/noticias-generales.html/?format=feed";
	Context con;
	ListView lv;
	private String[] from={"titulo"};
	private int[] to={R.id.Titulo_AdaptadorNoticia};
	Fragment fr;
	ProgressDialog pd;
	private ArrayList<HashMap<String, String>> Datos=new ArrayList<HashMap<String,String>>();
	boolean sw=true;
	public AsyncConector(Context con,ListView lv,Fragment fr) {
		this.con=con;
		this.lv=lv;
		this.fr=fr;
		pd=new ProgressDialog(con);
		pd.setIndeterminate(true);
		pd.setMessage("Porfavor Espere");
		pd.show();
	}
	@Override
	protected Void doInBackground(Void... params) {
		ConectorHttpXML conector = new ConectorHttpXML(url);
		try {
			noticias = conector.execute();
			for (int i = 0; i < noticias.size(); i++) {
				Datos.add(noticias.get(i).Mapa());
			}
			SimpleAdapter sa=new SimpleAdapter(con, Datos, R.layout.adapter_noticias,from , to);
			sa.notifyDataSetChanged();
			lv.setAdapter(sa);
		} catch (Exception e) {
			sw=false;
			Log.e("Tab", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		if(!sw){
			try{
				pd.dismiss();
			}catch(Exception e){}
			Toast.makeText(con, "Error en la conexion", Toast.LENGTH_LONG).show();
		}else{
			try{
				pd.dismiss();
			}catch(Exception e){}
		}
		/*
		// Añadimos todas las publicaciones al Adapter.
		for (Publicacion tmp : publicaciones)
			adapter.add(tmp);

		// Indicamos al Adapter que ha cambiado su contenido, para que actualice
		// a su vez los datos mostrados en el ListView.
		adapter.notifyDataSetChanged();
		super.onPostExecute(result);*/
	}

}
