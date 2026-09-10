package model;

public enum Especialidad {
    FRENOS_TRANSMISION("FrenosTransmision"), SUSPENSION("Suspension"), BICICLETAS_ELECTRICAS("BicicletasElectricas"), BALANCEO("Balanceo");

    private final String especialidad;

    private Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return especialidad;
    }
}
