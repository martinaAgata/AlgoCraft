package modelo;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import modelo.estrategias.DesgasteAbrupto;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DesgasteAbruptoTests {

    @Test
    public void testDesgastadorAbruptoSeInicializaCorrectamente(){
        DesgasteAbrupto desgasteAbrupto = new DesgasteAbrupto();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        assertTrue(desgasteAbrupto.desgastar(0, estadoVivo) instanceof EstadoVivo);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        assertTrue(desgasteAbrupto.desgastar(0, estadoMuerto) instanceof EstadoMuerto);
    }

    @Test
    public void testDesgastadorAbruptoDevuelveEstadoPasadoLasDiezPrimerasVeces(){
        DesgasteAbrupto desgasteAbrupto = new DesgasteAbrupto();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        for(int i=0; i<10; i++) assertThat(desgasteAbrupto.desgastar(1,estadoVivo), is(estadoVivo));
    }

    @Test
    public void testDesgastadorAbruptoDevuelveEstadoMuertoLuegoDeDiezDesgastes(){
        DesgasteAbrupto desgasteAbrupto = new DesgasteAbrupto();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        for(int i=0; i<10; i++) desgasteAbrupto.desgastar(1,estadoVivo);
        assertTrue(desgasteAbrupto.desgastar(1, estadoVivo) instanceof  EstadoMuerto);
    }
}
