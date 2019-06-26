package modelo.estado;

import modelo.estados.EstadoMuerto;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.NoSePuedeDesgastarUnElementoConEstadoMuertoException;
import org.junit.Test;

import static org.junit.Assert.*;

public class EstadoMuertoTests {
    @Test
    public void testEstadoMuertoSeInicializaCorrectamente(){
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        assertEquals(estadoMuerto.getDurabilidad(), 0);
    }
    @Test(expected = NoSePuedeDesgastarUnElementoConEstadoMuertoException.class)
    public void testEstadoMuertoDesgastarLanzaError(){
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        estadoMuerto.desgastar(10);
    }

/*    @Test
    public void test03EstadoMuertoSePuedeUsarDevuelveFalse(){
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        assertFalse(estadoMuerto.sePuedeUsar());
    }*/
}
