package model;

import java.util.LinkedList;

public class Mecanico {
    private String nombre;
    private String apellido;
    private String id;
    private LinkedList<OrdenServicio> listOrdenesServicio;

    //Constructor
    public Mecanico(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.listOrdenesServicio = new LinkedList<>();
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<OrdenServicio> getListOrdenesServicio() {
        return listOrdenesServicio;
    }

    public void setListOrdenesServicio(LinkedList<OrdenServicio> listOrdenesServicio) {
        this.listOrdenesServicio = listOrdenesServicio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + ", Apellido: " + apellido + "\n"
                + ", Id: " + id;
    }
}
