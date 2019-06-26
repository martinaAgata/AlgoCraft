package modelo.desgastes;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import modelo.estrategias.DesgasteLinealFactor;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.NoSePuedeDesgastarUnElementoConEstadoMuertoException;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealDecimalTests {
    @Test
    public void testDesgasteLinealDecimalDesgastaEstadoVivoSegunFuerzaDivididaPorUnDecimo(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(0.1);
        EstadoVivo estadoVivo = new EstadoVivo(100);
        Integer durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLineal.desgastar(100, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 10));
        desgasteLineal.desgastar(200, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 30));
        desgasteLineal.desgastar(300, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 60));

    }

    @Test
    public void testDesgasteLinealDecimalDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(0.1);
        EstadoVivo estadoVivo = new EstadoVivo(10);
        assertThat(desgasteLineal.desgastar(30, estadoVivo), is(estadoVivo));
        assertThat(desgasteLineal.desgastar(60, estadoVivo), is(estadoVivo));
        assertNotEquals(estadoVivo, desgasteLineal.desgastar(120, estadoVivo));
    }

    @Test (expected = NoSePuedeDesgastarUnElementoConEstadoMuertoException.class)
    public void testDesgasteLinealFactorLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(0.1);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
