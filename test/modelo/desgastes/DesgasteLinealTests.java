package modelo.desgastes;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import modelo.estrategias.DesgasteLinealFactor;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealTests {
    @Test
    public void testDesgasteLinealDesgastaEstadoVivoSegunFuerza(){
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
    public void testDesgasteLinealDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(1);
        EstadoVivo estadoVivo = new EstadoVivo(3);
        assertThat(desgasteLineal.desgastar(1, estadoVivo), is(estadoVivo));
        assertThat(desgasteLineal.desgastar(1, estadoVivo), is(estadoVivo));
        assertNotEquals(estadoVivo, desgasteLineal.desgastar(4, estadoVivo));
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testDesgasteLinealLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealFactor desgasteLineal = new DesgasteLinealFactor(1);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLineal.desgastar(1, estadoMuerto);
    }
}
