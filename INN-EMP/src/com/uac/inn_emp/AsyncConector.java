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
	ProgressDialog pd;
	boolean sw=true;
	ArrayAdapter_Noticias arad;
	public AsyncConector(Context con,ListView lv) {
		this.con=con;
		this.lv=lv;
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
			arad=new ArrayAdapter_Noticias(con, noticias);
		} catch (Exception e) {
			sw=false;
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		if(!sw){
			try{
				pd.dismiss();
			}catch(Exception e){}
			Toast.makeText(con, "Error en la conexion", Toast.LENGTH_LONG).show();
		}else{
			try{
				lv.setAdapter(arad);
				pd.dismiss();
			}catch(Exception e){}
		}
	}

}
