package model;

import java.util.LinkedList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String numIdentificacion;
    private String telefono;
    private String direccion;
    private LinkedList<Bicicleta> listBicicletasCliente;

    //Constructor
    public Cliente(String nombre, String numIdentificacion, String telefono, String direccion) {
        this.nombre = nombre;
        this.numIdentificacion = numIdentificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listBicicletasCliente = new LinkedList<>();
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

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Bicicleta> getListBicicletasCliente() {
        return listBicicletasCliente;
    }

    public void setListBicicletasCliente(LinkedList<Bicicleta> listBicicletasCliente) {
        this.listBicicletasCliente = listBicicletasCliente;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + "Apellido: " + apellido + "\n"
                + "NumIdentificacion: " + numIdentificacion + "\n"
                + "Telefono: " + telefono + "\n"
                + "Direccion: " + direccion + "\n";
    }
}
