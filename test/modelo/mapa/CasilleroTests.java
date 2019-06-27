package modelo.mapa;

import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;
import modelo.juego.ObjetoUbicable;
import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;

import org.junit.Test;


public class CasilleroTests {
    @Test
    public void testGuardarUbicableEnCasilleroVacioNoLanzaExcepcion(){
        Casillero casillero = new Casillero();
        ObjetoUbicable o = new ObjetoUbicable(null);
        casillero.guardarUbicable(o);
    }

    @Test (expected = NoSePuedeUbicarPorqueEstaOcupadoException.class)
    public void testGuardarUbicableEnCasilleroLlenoLanzaException(){
        Casillero casillero = new Casillero();
        ObjetoUbicable objetoUbicable1 = new ObjetoUbicable(null);
        casillero.guardarUbicable(objetoUbicable1);
        ObjetoUbicable objetoUbicable2 = new ObjetoUbicable(null);
        casillero.guardarUbicable(objetoUbicable2);
    }

    @Test (expected = NoSePuedeEliminarPorqueEstaVacioException.class)
    public void testEliminarUbicableEnCasilleroLanzaExcepcion(){
        Casillero casillero = new Casillero();
        casillero.eliminarUbicable();
    }

    @Test
    public void testEliminarUbicableEnCasilleroOcupadoNoLanzaExcepcion(){
        Casillero casillero = new Casillero();
        ObjetoUbicable objetoUbicable = new ObjetoUbicable(null);

        casillero.guardarUbicable(objetoUbicable);
        casillero.eliminarUbicable();
    }
}