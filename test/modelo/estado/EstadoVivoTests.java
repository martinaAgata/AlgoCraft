package modelo.estado;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EstadoVivoTests {
    @Test
    public void testEstadoVivoSeInicializaCorrectamente(){
        EstadoVivo estadoVivo = new EstadoVivo(100);
        assertThat(estadoVivo.getDurabilidad(), is(100));
        estadoVivo = new EstadoVivo(12395346);
        assertThat(estadoVivo.getDurabilidad(), is(12395346));
        estadoVivo = new EstadoVivo(-1);
        assertThat(estadoVivo.getDurabilidad(), is(-1));
    }

    @Test
    public void testEstadoVivoDesgastaDurabilidadSegunValorRecibido(){
        Integer durabilidadInicial = 100;
        EstadoVivo estadoVivo = new EstadoVivo(durabilidadInicial);
        estadoVivo.desgastar(10);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadInicial - 10));
        estadoVivo.desgastar(20);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadInicial - 30));
        estadoVivo.desgastar(30);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadInicial - 60));
    }

    @Test
    public void testEstadoVivoDevueleveEstadoVivoConDurabilidadMayorACero(){
        EstadoVivo estadoVivo = new EstadoVivo(100);
        //assertTrue((estadoVivo.desgastar(10)) instanceof EstadoVivo);
        assertThat(estadoVivo.desgastar(10), is(estadoVivo));
        assertThat(estadoVivo.desgastar(30), is(estadoVivo));
        assertThat(estadoVivo.desgastar(50), is(estadoVivo));
    }

    @Test
    public void testEstadoVivoDevueleveEstadoMuertoConDurabilidadMenorIgualACero(){
        EstadoVivo estadoVivo = new EstadoVivo(100);
        assertNotEquals(estadoVivo, estadoVivo.desgastar(100));
        estadoVivo = new EstadoVivo(100);
        assertNotEquals(estadoVivo, estadoVivo.desgastar(120));
    }

}
