package main;

import main.estados.EstadoMuerto;
import main.estados.EstadoVivo;
import main.estrategias.DesgasteLinealFactor;
import main.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealMitadTests {
    @Test
    public void test01DesgasteLinealMitadDesgastaEstadoVivoSegunMitadDeFuerza(){
        DesgasteLinealFactor desgasteLinealMitad = new DesgasteLinealFactor(0.5);
        EstadoVivo estadoVivo = new EstadoVivo(10);
        Integer durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLinealMitad.desgastar(2, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 1));
        desgasteLinealMitad.desgastar(4, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 3));
        desgasteLinealMitad.desgastar(4, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 5));

    }

    @Test
    public void test02DesgasteLinealMitadDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado(){
        DesgasteLinealFactor desgasteLinealMitad = new DesgasteLinealFactor(0.5);
        EstadoVivo estadoVivo = new EstadoVivo(8);
        assertTrue(desgasteLinealMitad.desgastar(8, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLinealMitad.desgastar(4, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLinealMitad.desgastar(8, estadoVivo) instanceof EstadoVivo);
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void test03DesgasteLinealMitadLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealFactor desgasteLinealMitad = new DesgasteLinealFactor(0.5);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLinealMitad.desgastar(1, estadoMuerto);
    }
}
