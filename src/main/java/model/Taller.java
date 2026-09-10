package model;

import java.util.LinkedList;

public class Taller {
    private String nombre;
    private String id;
    private String direccion;
    private LinkedList<Cliente> listClientes;
    private LinkedList<Mecanico> listMecanicos;
    private LinkedList<Bicicleta> listBicicletas;
    private LinkedList<OrdenServicio> listOrdenesServicio;

    //Constructor
    public Taller(String nombre, String id, String direccion) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(LinkedList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public LinkedList<Mecanico> getListMecanicos() {
        return listMecanicos;
    }

    public void setListMecanicos(LinkedList<Mecanico> listMecanicos) {
        this.listMecanicos = listMecanicos;
    }

    public LinkedList<Bicicleta> getListBicicletas() {
        return listBicicletas;
    }

    public void setListBicicletas(LinkedList<Bicicleta> listBicicletas) {
        this.listBicicletas = listBicicletas;
    }

    public LinkedList<OrdenServicio> getListOrdenesServicio() {
        return listOrdenesServicio;
    }

    public void setListOrdenesServicio(LinkedList<OrdenServicio> listOrdenesServicio) {
        this.listOrdenesServicio = listOrdenesServicio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "/n"
                + ", Id: " + id + "/n"
                + ", Direccion: " + direccion;
    }
}
