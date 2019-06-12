package main;

import main.estrategias.DesgasteLinealFactor;
import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DesgasteLinealFactorTests {
    @Test
    public void test01DesgasteLinealFactorDesgastaEstadoVivoSegunFactorIngresado() {
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(2/3);
        EstadoVivo estadoVivo = new EstadoVivo(20);
        Integer durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLineal.desgastar(3, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 3));
        desgasteLineal.desgastar(6, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 9));
        desgasteLineal = new DesgasteLinealFactor(0.5);
        estadoVivo = new EstadoVivo(20);
        durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLineal.desgastar(2, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 1));
        desgasteLineal.desgastar(6, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 4));

    }
    @Test
    public void test02DesgasteLinealFactorDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado() {
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(2/3);
        EstadoVivo estadoVivo = new EstadoVivo(6);
        assertTrue(desgasteLineal.desgastar(6, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLineal.desgastar(2, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLineal.desgastar(3, estadoVivo) instanceof EstadoVivo);
    }
    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test03DesgasteLinealFactorLanzaExcepcionAlDesgastarEstadoMuerto() {
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(2/3);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
