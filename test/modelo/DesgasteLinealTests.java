package modelo;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import modelo.estrategias.DesgasteLinealFactor;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealTests {
    @Test
    public void test01DesgasteLinealDesgastaEstadoVivoSegunFuerza(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(1);
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
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(1);
        EstadoVivo estadoVivo = new EstadoVivo(3);
        assertTrue(desgasteLineal.desgastar(1, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLineal.desgastar(1, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLineal.desgastar(4, estadoVivo) instanceof EstadoVivo);
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test03DesgasteLinealLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(1);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
