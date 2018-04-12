package com.example.franciscoesteban.reservavuelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);


    }


    public void chRegistrar(View view) {

        Intent auxIntent = new Intent(this, ReservaVuelos.class);
        startActivity(auxIntent);
    }


    public void chToMostrar(View view) {

        Intent auxIntent = new Intent(this, MostarVuelos.class);
        startActivity(auxIntent);
    }

    public void chToEditar(View view) {
        Intent auxIntent = new Intent(this, EditarVuelo.class);
        startActivity(auxIntent);
    }


    public void chToEliminar(View view) {
        Intent auxIntent = new Intent(this, EliminarVuelo.class);
        startActivity(auxIntent);
    }
}
