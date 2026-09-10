package model;

public enum tipoBicicleta {
    RUTA("Ruta"), MTB("MTB"), URBANA("Urbana"), ELECTRICA("Electrica");

    private final String tipoBicicleta;

    tipoBicicleta(String tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }

    @Override
    public String toString() {
        return tipoBicicleta;
    }
}
