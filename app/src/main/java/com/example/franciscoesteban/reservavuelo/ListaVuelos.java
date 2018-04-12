package com.example.franciscoesteban.reservavuelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaVuelos implements Serializable {

    private ArrayList<Vuelos>listVuelos;

    public ListaVuelos()
    {
        this.setListVuelos(new ArrayList<Vuelos>());
    }

    public ArrayList<Vuelos> getListVuelos() {
        return listVuelos;
    }

    public void setListVuelos(ArrayList<Vuelos> listVuelos) {
        this.listVuelos = listVuelos;
    }


    public void agregaVuelo (Vuelos vuelo)
    {
        this.getListVuelos().add(vuelo);
    }
}
