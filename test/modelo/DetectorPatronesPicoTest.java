package modelo;

import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Herramienta;
import modelo.herramientas.Pico;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronPico;
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
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
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
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
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
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
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
