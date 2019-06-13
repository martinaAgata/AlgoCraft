package main;

import main.exceptions.CasilleroEstaOcupadoException;
import main.mapa.Casillero;
import main.Ubicable;
import main.exceptions.CasilleroEstaOcupadoException;

import org.junit.Test;

public class ObjetoUbicable implements Ubicable {
}

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CasilleroTest{

	@Test
	public void testCasilleroSeInicializaVacio(){
		Casillero casillero = new Casillero;
		assertTrue( casillero.ubicableOptional.isEmpty());
	}

	@Test
	public void testCasilleroGuardaUbicableEnCasilleroVacio(){
		Casillero casillero = new Casillero;
		ObjetoUbicable objetoUbicable = new ObjetoUbicable;
		assertTrue( casillero.ubicableOptional = Optional.of(objetoUbicable))
	}

	@Test ( expected = CasilleroEstaOcupadoException.class)
	public void testCasilleroGuardaUbicableEnCasilleroLlenoYlanzaException(){
		Casillero casillero = new Casillero;
		ObjetoUbicable objetoUbicable = new ObjetoUbicable;
		casillero.ubicableOptional = Optional.of(objetoUbicable);
		ObjetoUbicable objetoUbicable2 = new ObjetoUbicable;
		casillero.ubicableOptional = Optional.of(objetoUbicable2);
	}

	@Test
	public void testCasilleroEliminarUbicableEnCasilleroVacioDaNull(){
		Casillero casillero = new Casillero;
		assertThat( casillero.eliminarUbicable(), null);
	}

	@Test
	public void testCasilleroEliminarUbicableEnCasilleroOcupadoDevuelveUbicable(){
		Casillero casillero = new Casillero;
		ObjetoUbicable objetoUbicable = new ObjetoUbicable;
		casillero.ubicableOptional = Optional.of(objetoUbicable);
		ObjetoUbicable ubicableDevuelto = ;
		assertEquals( casillero.eliminarUbicable(), objetoUbicable);

	}
}