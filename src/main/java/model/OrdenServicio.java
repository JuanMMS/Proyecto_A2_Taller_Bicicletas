package model;

import java.sql.Time;
import java.util.Date;

public class OrdenServicio {
    private Date fechaIngreso;
    private Time horaIngreso;
    private String motivoServicio;
    private String diagnostico;
    private String trabajoRealizado;
    private double costoTotal;
    private Mecanico theMecanicoBicicleta;

    //Constructor

    public OrdenServicio(Date fechaIngreso, Time horaIngreso, String motivoServicio, String diagnostico, String trabajoRealizado, double costoTotal) {
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.motivoServicio = motivoServicio;
        this.diagnostico = diagnostico;
        this.trabajoRealizado = trabajoRealizado;
        this.costoTotal = costoTotal;
        this.theMecanicoBicicleta = null;
    }

    //Getters y Setters

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Time getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Time horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getMotivoServicio() {
        return motivoServicio;
    }

    public void setMotivoServicio(String motivoServicio) {
        this.motivoServicio = motivoServicio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTrabajoRealizado() {
        return trabajoRealizado;
    }

    public void setTrabajoRealizado(String trabajoRealizado) {
        this.trabajoRealizado = trabajoRealizado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Mecanico getTheMecanicoBicicleta() {
        return theMecanicoBicicleta;
    }

    public void setTheMecanicoBicicleta(Mecanico theMecanicoBicicleta) {
        this.theMecanicoBicicleta = theMecanicoBicicleta;
    }

    @Override
    public String toString() {
        return "Fecha de ingreso: " + fechaIngreso + "\n"
                + "Hora de ingreso: " + horaIngreso + "\n"
                + "Motivo Servicio: " + motivoServicio + "\n"
                + "Diagnostico: " + (diagnostico != null ? diagnostico : "Sin diagnostico") + "\n"
                + "Trabajo realizado: " + (trabajoRealizado != null ?  trabajoRealizado : "Sin trabajo realizado") + "\n"
                + "Costo total: " + (costoTotal != 0.0 ? costoTotal : "Sin valuar") + "\n"
                + "Mecanico: " + (theMecanicoBicicleta != null ? theMecanicoBicicleta.getNombre() + theMecanicoBicicleta.getApellido() : "Sin asignar");
    }
}
