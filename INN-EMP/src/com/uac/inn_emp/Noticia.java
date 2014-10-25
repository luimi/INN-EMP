package com.uac.inn_emp;

import java.util.HashMap;

public class Noticia {
	public String titulo;
	public String categoria;
	public String fecha;
	public String link;
	public String img;
	public Noticia(){
		
	}
	public Noticia(String titulo, String categoria, String fecha, String link, String img) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.fecha = fecha;
		this.link = link;
		this.img = img;
	}
	public HashMap<String, String> Mapa(){
		HashMap<String, String> t=new HashMap<String, String>();
		t.put("titulo",titulo );
		t.put("categoria", categoria);
		t.put("fecha", fecha);
		t.put("link", link);
		t.put("img", img);
		return t;
	}
	
}
