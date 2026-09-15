package controller;

import model.Bicicleta;
import model.Taller;

import java.util.Collection;

public class BicicletaController {

    private Taller taller;


    public BicicletaController(Taller taller) {
        this.taller = taller;
    }


    public boolean crearBicicleta(Bicicleta bicicleta) {

        return taller.agregarBicicleta(bicicleta);
    }


    public Collection<Bicicleta> obtenerListaBicicletas() {

        return taller.getListBicicletas();
    }


    public boolean eliminarBicicleta(String numSerial) {

        return taller.eliminarBicicleta(numSerial);
    }


    public boolean actualizarBicicleta(
            String numSerial,
            Bicicleta bicicleta) {

        return taller.actualizarBicicleta(
                numSerial,
                bicicleta
        );
    }
}

