package com.example.franciscoesteban.reservavuelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;


public class ReservaVuelos extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ListaVuelos auxListaVuelos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_vuelos);

        this.setAuxListaVuelos(new ListaVuelos());


        Button botonElegir = (Button) findViewById(R.id.btnElegir);
        botonElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String fechaDeHoy = DateFormat.getDateInstance().format(c.getTime());
        TextView fechaActual = (TextView) findViewById(R.id.txtFechaSeleccion);
        fechaActual.setText(fechaDeHoy);
    }

    public void guardar(View view) {
        try
        {
            EditText auxNombre = findViewById(R.id.textoNombre);
            EditText auxApellido = findViewById(R.id.textoApellido);
            EditText auxPais = findViewById(R.id.textoPais);
            EditText auxRut = findViewById(R.id.textoRut);
            TextView auxFecha = (TextView) findViewById(R.id.txtFechaSeleccion);

            Vuelos auxVuelo = new Vuelos();

            auxVuelo.setNombre(auxNombre.getText().toString());
            auxVuelo.setApellido(auxApellido.getText().toString());
            auxVuelo.setPaisDestino(auxPais.getText().toString());
            auxVuelo.setRut(auxRut.getText().toString());
            auxVuelo.setFecha(auxFecha.getText().toString());


            this.getAuxListaVuelos().agregaVuelo(auxVuelo);

            this.mensaje("Datos Guardados!!");
        }
        catch (Exception ex)
        {
            this.mensaje("Datos no guardados");
        }
    }

    public void mensaje(String texto)
    {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }

    public ListaVuelos getAuxListaVuelos() {
        return auxListaVuelos;
    }

    public void setAuxListaVuelos(ListaVuelos auxListaVuelos) {
        this.auxListaVuelos = auxListaVuelos;
    }
}
