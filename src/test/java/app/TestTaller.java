package app;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TestTaller {
    private final static Logger LOGGER = Logger.getLogger(TestTaller.class.getName());

    private Taller taller;
    private Bicicleta bicicleta1, bicicleta2;
    private Mecanico mecanico1, mecanico2;
    private Cliente cliente1, cliente2;

    @BeforeEach
    public void setUp() {
        taller = new Taller("Prueba Taller", "00000", "00000", 30);
        bicicleta1 = new Bicicleta("Shimano", "Gris", "12345", "2015");
        bicicleta2 = new Bicicleta("GW", "Rojo", "54321", "2016");
        mecanico1 = new Mecanico("Jairo", "Gomez", "12345");
        mecanico2 = new Mecanico("Julio", "Garo", "54321");
        cliente1 = new Cliente("Jaime", "88888", "55555", "11111");
        cliente2 = new Cliente("Maria", "77777", "33333", "22222");
    }

    @Test
    public void testAssertNotNull() {
        LOGGER.info("Inicio testAssertNotNull");
        assertNotNull(taller);
        LOGGER.info("Fin testAssertNotNull");
    }

    @Test
    public void testAssertNotNull2() {
        LOGGER.info("Inicio testAssertNotNull2");
        assertNotNull(bicicleta1);
        LOGGER.info("Fin testAssertNotNull2");
    }

    @Test
    public void testAssertNotEquals() {
        LOGGER.info("Inicio testAssertNotEquals");
        assertNotEquals(mecanico1, mecanico2);
        LOGGER.info("Fin testAssertNotEquals");
    }

    @Test
    public void testAssertNotEquals2() {
        LOGGER.info("Inicio testAssertNotEquals2");
        assertNotEquals(cliente1, cliente2);
        LOGGER.info("Fin testAssertNotEquals2");
    }

    @Test
    public void testAssertTrue() {
        LOGGER.info("Inicio testAssertTrue");
        assertTrue(taller.getListOrdenesServicio().isEmpty());
        assertTrue(taller.getListBicicletas().isEmpty());
        assertTrue(taller.getListMecanicos().isEmpty());
        assertTrue(taller.getListClientes().isEmpty());
        LOGGER.info("Fin testAssertTrue");
    }

}
