package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class EstadoMuertoTests {
    @Test
    public void test01EstadoMuertoSeInicializaCorrectamente(){
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        assertEquals(estadoMuerto.getDurabilidad(), 0);
        assertFalse(estadoMuerto.sePuedeUsar());
    }
    @Test(expected = IllegalStateException.class)
    public void test02EstadoMuertoDesgastarLanzaError(){
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        estadoMuerto.desgastar(10);
    }

    @Test
    public void test03EstadoMuertoSePuedeUsarDevuelveFalse(){
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        assertFalse(estadoMuerto.sePuedeUsar());
    }
}
