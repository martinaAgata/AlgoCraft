package modelo.desgastes;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import modelo.estrategias.DesgasteLinealFactor;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealFactorTests {
    @Test
    public void testDesgasteLinealFactorDesgastaEstadoVivoSegunFactorIngresado() {
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor((double)2/3);
        EstadoVivo estadoVivo = new EstadoVivo(20);
        Integer durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLineal.desgastar(3, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 2));
        desgasteLineal.desgastar(6, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 6));
        desgasteLineal = new DesgasteLinealFactor(0.5);
        estadoVivo = new EstadoVivo(20);
        durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLineal.desgastar(2, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 1));
        desgasteLineal.desgastar(6, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 4));

    }

    @Test
    public void testDesgasteLinealFactorDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado() {
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor((double)2/3);
        EstadoVivo estadoVivo = new EstadoVivo(6);
        assertThat(desgasteLineal.desgastar(6, estadoVivo), is(estadoVivo));
        assertThat(desgasteLineal.desgastar(2, estadoVivo), is(estadoVivo));
        assertNotEquals(estadoVivo, desgasteLineal.desgastar(3, estadoVivo));
    }

    @Test(expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testDesgasteLinealFactorLanzaExcepcionAlDesgastarEstadoMuerto() {
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(2 / 3);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}