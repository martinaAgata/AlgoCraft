package main;

import main.herramientas.ConstructorHacha;
import main.herramientas.Hacha;
import main.herramientas.Herramienta;
import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import main.patrones.DetectorPatron;
import main.patrones.DetectorPatronHacha;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class DetectorDePatronesHachaTest {
    @Test
    public void testSeCreaUnHachaDeMaderaYSeReconocePatron(){
        Madera madera = new Madera();
        Mapa tableroConHachaMadera = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(3, 2);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronHacha(new Madera(), () -> new ConstructorHacha().construirHachaMadera());
        Optional<Herramienta> resultado = dp.resolver(tableroConHachaMadera);
        assertTrue(resultado.isPresent());
        assertThat(resultado.get(), instanceOf(Hacha.class));
    }

    @Test
    public void testSeCreaUnHachaDePiedraYSeReconocePatron(){
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Mapa tableroConHachaMadera = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(3, 2);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronHacha(new Madera(), () -> new ConstructorHacha().construirHachaMadera());
        Optional<Herramienta> resultado = dp.resolver(tableroConHachaMadera);
        assertTrue(resultado.isPresent());
        assertThat(resultado.get(), instanceOf(Hacha.class));
    }

    @Test
    public void testSeCreaUnHachaDeMetalYSeReconocePatron(){
        Madera madera = new Madera();
        Metal metal = new Metal();
        Mapa tableroConHachaMetal = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(3, 2);
        tableroConHachaMetal.ubicarEnCasillero(metal, ubicacionA);
        tableroConHachaMetal.ubicarEnCasillero(metal, ubicacionB);
        tableroConHachaMetal.ubicarEnCasillero(metal, ubicacionC);
        tableroConHachaMetal.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMetal.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha().construirHachaMetal());
        Optional<Herramienta> resultado = dp.resolver(tableroConHachaMetal);
        assertTrue(resultado.isPresent());
        assertThat(resultado.get(), instanceOf(Hacha.class));
    }
}


