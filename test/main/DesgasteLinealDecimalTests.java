package main;

import main.estrategias.DesgasteLinealDecimal;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DesgasteLinealDecimalTests {
    @Test
    public void test01DesgasteLinealDecimalDesgastaEstadoVivoSegunFuerzaDivididaPorUnDecimo(){
        DesgasteLinealDecimal desgasteLineal = new DesgasteLinealDecimal();
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
        DesgasteLinealDecimal desgasteLineal = new DesgasteLinealDecimal();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        assertTrue(desgasteLineal.desgastar(30, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLineal.desgastar(70, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLineal.desgastar(120, estadoVivo) instanceof EstadoVivo);
    }

    @Test (expected = IllegalStateException.class)
    public void test03DesgasteLinealFactorLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealDecimal desgasteLineal = new DesgasteLinealDecimal();
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
