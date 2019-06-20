package modelo.detectorPatrones;

import modelo.herramientas.ConstructorHacha;
import modelo.herramientas.Hacha;
import modelo.herramientas.Herramienta;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronHacha;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static modelo.juego.ConstantesJuego.*;
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
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronHacha(new Madera(),() -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConHachaMadera);
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
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronHacha(new Piedra(),() -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConHachaMadera);
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
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConHachaMetal.ubicarEnCasillero(metal, ubicacionA);
        tableroConHachaMetal.ubicarEnCasillero(metal, ubicacionB);
        tableroConHachaMetal.ubicarEnCasillero(metal, ubicacionC);
        tableroConHachaMetal.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMetal.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConHachaMetal);
        assertTrue(resultado.isPresent());
        assertThat(resultado.get(), instanceOf(Hacha.class));
    }
}


