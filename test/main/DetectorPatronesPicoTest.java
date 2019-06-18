package main;

import main.herramientas.ConstructorPico;
import main.herramientas.Herramienta;
import main.herramientas.Pico;
import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import main.patrones.DetectorPatron;
import main.patrones.DetectorPatronPico;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class DetectorPatronesPicoTest {
    @Test
    public void testSeCreaUnPicoDeMaderaYSeReconocePatron() {
        Madera madera = new Madera();
        Mapa tableroConPicoMadera = new Mapa(3, 3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 2);
        Ubicacion ubicacionC = new Ubicacion(1, 3);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(3, 2);
        tableroConPicoMadera.ubicarEnCasillero(madera, ubicacionA);
        tableroConPicoMadera.ubicarEnCasillero(madera, ubicacionB);
        tableroConPicoMadera.ubicarEnCasillero(madera, ubicacionC);
        tableroConPicoMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConPicoMadera.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().construir());
        Optional<Herramienta> resultado = dp.resolver(tableroConPicoMadera);
        assertThat(resultado.get(), instanceOf(Pico.class));
    }

    @Test
    public void testSeCreaUnPicoDePiedraYSeReconocePatron(){
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Mapa tableroConPicoPiedra = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 2);
        Ubicacion ubicacionC = new Ubicacion(1, 3);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(3, 2);
        tableroConPicoPiedra.ubicarEnCasillero(piedra, ubicacionA);
        tableroConPicoPiedra.ubicarEnCasillero(piedra, ubicacionB);
        tableroConPicoPiedra.ubicarEnCasillero(piedra, ubicacionC);
        tableroConPicoPiedra.ubicarEnCasillero(madera, ubicacionD);
        tableroConPicoPiedra.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().construir());
        Optional<Herramienta> resultado = dp.resolver(tableroConPicoPiedra);
        assertThat(resultado.get(), instanceOf(Pico.class));
    }

    @Test
    public void testSeCreaUnPicoDeMetalYSeReconocePatron(){
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroConPicoMetal = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 2);
        Ubicacion ubicacionC = new Ubicacion(1, 3);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(3, 2);
        tableroConPicoMetal.ubicarEnCasillero(metal, ubicacionA);
        tableroConPicoMetal.ubicarEnCasillero(metal, ubicacionB);
        tableroConPicoMetal.ubicarEnCasillero(metal, ubicacionC);
        tableroConPicoMetal.ubicarEnCasillero(madera, ubicacionD);
        tableroConPicoMetal.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().construir());
        Optional<Herramienta> resultado = dp.resolver(tableroConPicoMetal);
        assertThat(resultado.get(), instanceOf(Pico.class));
    }

    @Test
    public void testNoSeCreaUnPicoDeMetalYNoSeReconocePatron(){
        Mapa tablero = new Mapa(3,3);
        Metal metal = new Metal();
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 2);
        tablero.ubicarEnCasillero(metal, ubicacionA);
        tablero.ubicarEnCasillero(metal, ubicacionB);
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().construir());
        Optional<Herramienta> resultado = dp.resolver(tablero);
        assertFalse(resultado.isPresent());
        //assertThat(resultado.get(), not(instanceOf(Pico.class)));
    }
}
