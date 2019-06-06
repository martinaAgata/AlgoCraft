package main;

import main.estrategias.DesgasteLinealFactor;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DesgasteLinealFactorTests {
    @Test
    public void test01DesgasteLinealFactorDesgastaEstadoVivoSegunFuerzaDivididaPorUnoYMedio(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor();
        EstadoVivo estadoVivo = new EstadoVivo(20);
        Integer durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLineal.desgastar(3, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 2));
        desgasteLineal.desgastar(6, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 6));
        desgasteLineal.desgastar(9, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 12));

    }

    @Test
    public void test02DesgasteLinealFactorDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor();
        EstadoVivo estadoVivo = new EstadoVivo(6);
        assertTrue(desgasteLineal.desgastar(3, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLineal.desgastar(4, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLineal.desgastar(3, estadoVivo) instanceof EstadoVivo);
    }

    @Test (expected = IllegalStateException.class)
    public void test03DesgasteLinealFactorLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor();
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
