package main;

import main.estrategias.DesgasteLinealFactor;
import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DesgasteLinealDecimalTests {
    @Test
    public void test01DesgasteLinealDecimalDesgastaEstadoVivoSegunFuerzaDivididaPorUnDecimo(){
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
    public void test02DesgasteLinealDecimalDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(0.1);
        EstadoVivo estadoVivo = new EstadoVivo(10);
        assertTrue(desgasteLineal.desgastar(30, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLineal.desgastar(60, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLineal.desgastar(120, estadoVivo) instanceof EstadoVivo);
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test03DesgasteLinealFactorLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(0.1);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
