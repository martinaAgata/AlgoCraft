package main;

import main.estrategias.DesgasteLineal;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealTests {
    @Test
    public void test01DesgasteLinealDesgastaEstadoVivoSegunFuerza(){
        DesgasteLineal desgasteLineal = new DesgasteLineal();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        Integer durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLineal.desgastar(1, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 1));
        desgasteLineal.desgastar(1, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 2));
        desgasteLineal.desgastar(1, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 3));

    }

    @Test
    public void test02DesgasteLinealDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado(){
        DesgasteLineal desgasteLineal = new DesgasteLineal();
        EstadoVivo estadoVivo = new EstadoVivo(3);
        assertTrue(desgasteLineal.desgastar(1, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLineal.desgastar(1, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLineal.desgastar(4, estadoVivo) instanceof EstadoVivo);
    }

    @Test (expected = IllegalStateException.class)
    public void test03DesgasteLinealLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLineal desgasteLineal = new DesgasteLineal();
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
