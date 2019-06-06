package main;

import main.estrategias.DesgasteLinealMitad;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealMitadTests {
    @Test
    public void test01DesgasteLinealMitadDesgastaEstadoVivoSegunMitadDeFuerza(){
        DesgasteLinealMitad desgasteLinealMitad = new DesgasteLinealMitad();
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
        DesgasteLinealMitad desgasteLinealMitad = new DesgasteLinealMitad();
        EstadoVivo estadoVivo = new EstadoVivo(8);
        assertTrue(desgasteLinealMitad.desgastar(8, estadoVivo) instanceof EstadoVivo);
        assertTrue(desgasteLinealMitad.desgastar(4, estadoVivo) instanceof EstadoVivo);
        assertFalse(desgasteLinealMitad.desgastar(8, estadoVivo) instanceof EstadoVivo);
    }

    @Test (expected = IllegalStateException.class)
    public void test03DesgasteLinealMitadLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealMitad desgasteLinealMitad = new DesgasteLinealMitad();
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLinealMitad.desgastar(1, estadoMuerto);
    }
}
