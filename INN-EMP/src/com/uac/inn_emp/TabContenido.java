package com.uac.inn_emp;



import android.app.Activity;
import android.os.Bundle;
import co.edu.uac.inn_emp.R;

public class TabContenido extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenidoherramientas);
        Bundle bundle = getIntent().getExtras();
        String contenido=bundle.getString("Contenido");
    }
   
}