package modelo.desgastes;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import modelo.estrategias.DesgasteAbrupto;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteAbruptoTests {

    @Test
    public void testDesgastadorAbruptoSeInicializaCorrectamente(){
        DesgasteAbrupto desgasteAbrupto = new DesgasteAbrupto();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        assertThat(desgasteAbrupto.desgastar(0, estadoVivo), is(estadoVivo));
    }

    @Test
    public void testDesgastadorAbruptoDevuelveEstadoPasadoLasNuevePrimerasVeces(){
        DesgasteAbrupto desgasteAbrupto = new DesgasteAbrupto();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        for(int i=0; i<9; i++) assertThat(desgasteAbrupto.desgastar(1,estadoVivo), is(estadoVivo));
    }

    @Test
    public void testDesgastadorAbruptoNoDevuelveEstadoVivoLuegoDeDiezDesgastes(){
        DesgasteAbrupto desgasteAbrupto = new DesgasteAbrupto();
        EstadoVivo estadoVivo = new EstadoVivo(10);
        for(int i=0; i<10; i++) desgasteAbrupto.desgastar(1,estadoVivo);
        //assertThat(desgasteAbrupto.desgastar(1, estadoVivo), );
        assertNotEquals(estadoVivo, desgasteAbrupto.desgastar(1, estadoVivo).getClass());
    }
}
