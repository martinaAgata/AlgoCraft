package modelo.detectorPatrones;

import modelo.herramientas.*;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronPico;
import modelo.patrones.DetectorPatronPicoFino;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class DetectorPatronPicoFinoTest {

    //    1        2       3
    //  Metal | Metal  | Metal   1
    // Piedra | Madera |         2
    //        | Madera |         3

        @Test
        public void testSeCreaUnPicoFinoYSeReconocePatron() {
            Madera madera = new Madera();
            Mapa tableroPicoFino = new Mapa(3, 3);
            tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(1,1)));
            tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(2,1)));
            tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(3,1)));
            tableroPicoFino.ubicarEnCasillero(new Piedra(), new Ubicacion(1,2));
            tableroPicoFino.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
            tableroPicoFino.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
            DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().conMaterial(new Metal())
                    .conDurabilidad(DURABILIDAD_PICO_FINO).conDesgaste(DESGASTE_PICO_FINO).conFuerza(FUERZA_PICO_FINO)
                    .construir());
            Optional<Herramienta> resultado = dp.resolverPatron(tableroPicoFino);
            Herramienta herramienta = resultado.get();
            Material material = new Madera();
            herramienta.usar(material);
            assertEquals(material.getDurabilidad(), 10);
            assertEquals(herramienta.getDurabilidad(), 1000 - 2);
            material = new Piedra();
            herramienta.usar(material);
            assertEquals(material.getDurabilidad(), 30);
            assertEquals(herramienta.getDurabilidad(), 1000 - 4);
            material = new Metal();
            herramienta.usar(material);
            assertEquals(material.getDurabilidad(), 50);
            assertEquals(herramienta.getDurabilidad(), 1000 - 6);
            material = new Diamante();
            herramienta.usar(material);
            assertEquals(material.getDurabilidad(), 100 - 20);
            assertEquals(herramienta.getDurabilidad(), 1000 - 8);
        }


    @Test
    public void testDetectorPatronDePicoFinoDetectaPatronPicoMadera(){
        Madera madera = new Madera();
        Mapa tableroPico = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroPico.ubicarEnCasillero(madera, ubicacionA);
        tableroPico.ubicarEnCasillero(madera, ubicacionB);
        tableroPico.ubicarEnCasillero(madera, ubicacionC);
        tableroPico.ubicarEnCasillero(madera, ubicacionD);
        tableroPico.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO).conDesgaste(DESGASTE_PICO_FINO).conFuerza(FUERZA_PICO_FINO)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoFinoDetectaPatronPicoPiedra(){
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Mapa tableroPico = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroPico.ubicarEnCasillero(piedra, ubicacionA);
        tableroPico.ubicarEnCasillero(piedra, ubicacionB);
        tableroPico.ubicarEnCasillero(piedra, ubicacionC);
        tableroPico.ubicarEnCasillero(madera, ubicacionD);
        tableroPico.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO).conDesgaste(DESGASTE_PICO_FINO).conFuerza(FUERZA_PICO_FINO)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoFinoNODetectaPatronPicoMetal(){
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroPico = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroPico.ubicarEnCasillero(metal, ubicacionA);
        tableroPico.ubicarEnCasillero(metal, ubicacionB);
        tableroPico.ubicarEnCasillero(metal, ubicacionC);
        tableroPico.ubicarEnCasillero(madera, ubicacionD);
        tableroPico.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO).conDesgaste(DESGASTE_PICO_FINO).conFuerza(FUERZA_PICO_FINO)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoFinoNODetectaPatronHachaMadera(){
        Madera madera = new Madera();
        Mapa tableroHacha = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroHacha.ubicarEnCasillero(madera, ubicacionA);
        tableroHacha.ubicarEnCasillero(madera, ubicacionB);
        tableroHacha.ubicarEnCasillero(madera, ubicacionC);
        tableroHacha.ubicarEnCasillero(madera, ubicacionD);
        tableroHacha.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO).conDesgaste(DESGASTE_PICO_FINO).conFuerza(FUERZA_PICO_FINO)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoFinoNODetectaPatronHachaPiedra(){
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Mapa tableroHacha = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroHacha.ubicarEnCasillero(piedra, ubicacionA);
        tableroHacha.ubicarEnCasillero(piedra, ubicacionB);
        tableroHacha.ubicarEnCasillero(piedra, ubicacionC);
        tableroHacha.ubicarEnCasillero(madera, ubicacionD);
        tableroHacha.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO).conDesgaste(DESGASTE_PICO_FINO).conFuerza(FUERZA_PICO_FINO)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoFinoNODetectaPatronHachaMetal(){
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroHacha = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroHacha.ubicarEnCasillero(metal, ubicacionA);
        tableroHacha.ubicarEnCasillero(metal, ubicacionB);
        tableroHacha.ubicarEnCasillero(metal, ubicacionC);
        tableroHacha.ubicarEnCasillero(madera, ubicacionD);
        tableroHacha.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO).conDesgaste(DESGASTE_PICO_FINO).conFuerza(FUERZA_PICO_FINO)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

}
