package modelo.juego;

import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;
import modelo.mapa.Ubicacion;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NullUbicableTests {

    @Test (expected = NoSePuedeEliminarPorqueEstaVacioException.class)
    public void testNullUbicableEliminarUbicableLanzaException(){
        NullUbicable nullUbicable = new NullUbicable(null);
        nullUbicable.eliminarUbicable();
    }

    @Test
    public void testNullUbicableGuardarUbicableDevuelveElUbicable(){
        Ubicable u = new Madera();
        NullUbicable nullUbicable = new NullUbicable(new Ubicacion(1,1));
        assertThat(nullUbicable.guardarUbicable(u), is(u));
        u = new Metal();
        assertThat(nullUbicable.guardarUbicable(u), is(u));
        u = new Piedra();
        assertThat(nullUbicable.guardarUbicable(u), is(u));
        u = new Diamante();
        assertThat(nullUbicable.guardarUbicable(u), is(u));
        u = new Jugador(null, null, new Ubicacion(1,1));
        assertThat(nullUbicable.guardarUbicable(u), is(u));

    }
}
