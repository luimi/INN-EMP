package com.uac.inn_emp;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MenuAdaptador extends ArrayAdapter<MenuPrincipal> {

	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public MenuAdaptador(Context ctx, int resourceId, List<MenuPrincipal> objects) {

		super(ctx, resourceId, objects);
		resource = resourceId;
		inflater = LayoutInflater.from(ctx);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = (LinearLayout) inflater.inflate(resource, null);
		MenuPrincipal obj = getItem(position);
		TextView txtName = (TextView) convertView.findViewById(R.id.listamenu_texto);
		ImageView imagen = (ImageView) convertView.findViewById(R.id.listamenu_imagen);
		//--asignar
		txtName.setText(obj.Titulo);
		String uri = "drawable/" + obj.Imagen;
		int imageResource = context.getResources().getIdentifier(uri, null,context.getPackageName());
		Drawable image = context.getResources().getDrawable(imageResource);
		imagen.setImageDrawable(image);

		return convertView;

	}
}
