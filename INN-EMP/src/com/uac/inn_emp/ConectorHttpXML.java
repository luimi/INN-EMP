package com.uac.inn_emp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


public class ConectorHttpXML {
	private String url;

	public ConectorHttpXML(String url) {
		this.url = url;
	}
	public ArrayList<Noticia> execute() throws XmlPullParserException, IOException {
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		boolean insideItem = false;
		String titulo = "";
		String link = "";
		String categoria= "";
		String fecha="";
		String img="";
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser xpp = factory.newPullParser();
		xpp.setInput(getInputStream(new URL(url)), "UTF-8");
		int event = xpp.getEventType();
		while (event != XmlPullParser.END_DOCUMENT) {
			if (event == XmlPullParser.START_TAG) {
				if (xpp.getName().equalsIgnoreCase("item")) {
					insideItem = true;
				} else if (xpp.getName().equalsIgnoreCase("title") && insideItem) {
					titulo = xpp.nextText();
				} else if (xpp.getName().equalsIgnoreCase("link") && insideItem) {
					link = xpp.nextText();
				} else if (xpp.getName().equalsIgnoreCase("category") && insideItem) {
					categoria = xpp.nextText();
				} else if (xpp.getName().equalsIgnoreCase("pubDate") && insideItem) {
					fecha = xpp.nextText();
				} else if (xpp.getName().equalsIgnoreCase("description") && insideItem) {
					img = xpp.nextText();
				}
			} else if (event == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
				noticias.add(new Noticia(titulo,categoria,fecha,link,img));
				insideItem = false;
			}
			event = xpp.next();
		}
		return noticias;
	}
	public InputStream getInputStream(URL url) {
		try {
			return url.openConnection().getInputStream();
		} catch (IOException e) {
			return null;
		}
	}
}
