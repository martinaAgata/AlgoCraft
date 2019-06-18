package main;

import main.exceptions.CasilleroVacioException;
import main.ObjetoUbicable;
import main.exceptions.CasilleroEstaOcupadoException;
import main.mapa.Casillero;
import main.Ubicable;
import main.exceptions.CasilleroEstaOcupadoException;

import org.junit.Test;

import static org.junit.Assert.*;


public class CasilleroTests {
    @Test
    public void testGuardarUbicableEnCasilleroVacioNoLanzaExcepcion(){
        Casillero casillero = new Casillero();
        ObjetoUbicable o = new ObjetoUbicable();
        casillero.guardarUbicable(o);
    }

    @Test (expected = CasilleroEstaOcupadoException.class)
    public void testGuardarUbicableEnCasilleroLlenoLanzaException(){
        Casillero casillero = new Casillero();
        ObjetoUbicable objetoUbicable1 = new ObjetoUbicable();
        casillero.guardarUbicable(objetoUbicable1);
        ObjetoUbicable objetoUbicable2 = new ObjetoUbicable();
        casillero.guardarUbicable(objetoUbicable2);
    }

    @Test (expected = CasilleroVacioException.class)
    public void testEliminarUbicableEnCasilleroLanzaExcepcion(){
        Casillero casillero = new Casillero();
        casillero.eliminarUbicable();
    }

    @Test
    public void testEliminarUbicableEnCasilleroOcupadoNoLanzaExcepcion(){
        Casillero casillero = new Casillero();
        ObjetoUbicable objetoUbicable = new ObjetoUbicable();

        casillero.guardarUbicable(objetoUbicable);
        casillero.eliminarUbicable();
    }
}