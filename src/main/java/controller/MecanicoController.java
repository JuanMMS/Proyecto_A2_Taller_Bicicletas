package controller;

import model.Mecanico;
import model.Taller;

import java.util.Collection;

public class MecanicoController {

    private Taller taller;

    public MecanicoController(Taller taller) {
        this.taller = taller;
    }

    public boolean crearMecanico(Mecanico mecanico) {
        return taller.agregarMecanico(mecanico);
    }

    public Collection<Mecanico> obtenerListaMecanicos() {
        return taller.getListMecanicos();
    }

    public boolean eliminarMecanico(String identificador) {
        return taller.eliminarMecanico(identificador);
    }

    public boolean actualizarMecanico(
            String identificador,
            Mecanico mecanico
    ) {
        return taller.actualizarMecanico(
                identificador,
                mecanico
        );
    }
}