package model;

import java.util.LinkedList;

public class Bicicleta {
    private String marca;
    private String color;
    private String numSerial;
    private String anio;
    private LinkedList<OrdenServicio> listOrdenesServicio;
    private Cliente theClienteDueno;

    //Constructor

    public Bicicleta(String marca, String color, String numSerial, String anio) {
        this.marca = marca;
        this.color = color;
        this.numSerial = numSerial;
        this.anio = anio;
        this.listOrdenesServicio = new LinkedList<>();
        this.theClienteDueno = null;
    }

    //Getters y Setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumSerial() {
        return numSerial;
    }

    public void setNumSerial(String numSerial) {
        this.numSerial = numSerial;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public LinkedList<OrdenServicio> getListOrdenesServicio() {
        return listOrdenesServicio;
    }

    public void setListOrdenesServicio(LinkedList<OrdenServicio> listOrdenesServicio) {
        this.listOrdenesServicio = listOrdenesServicio;
    }

    public Cliente getTheClienteDueno() {
        return theClienteDueno;
    }

    public void setTheClienteDueno(Cliente theClienteDueno) {
        this.theClienteDueno = theClienteDueno;
    }

    @Override
    public String toString() {
        return "Marca='" + marca + "\n" +
                ", Color='" + color + "\n" +
                ", numSerial='" + numSerial + "\n" +
                ", anio='" + anio + "\n" +
                ", theClienteDueno=" + theClienteDueno;
    }
}
