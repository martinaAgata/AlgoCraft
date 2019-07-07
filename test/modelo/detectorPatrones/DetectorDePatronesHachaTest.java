package modelo.detectorPatrones;

import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.herramientas.ConstructorHacha;
import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Hacha;
import modelo.herramientas.Herramienta;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronHacha;
import modelo.patrones.DetectorPatronPico;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class DetectorDePatronesHachaTest {
    @Test
    public void testSeCreaUnHachaDeMaderaYDevuelveHerramientaCorrecta(){
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
        Material material = madera;
        Herramienta herramienta = resultado.get();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 10 - 2);
        assertEquals(herramienta.getDurabilidad(), 100 - 2);
        material = new Piedra();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 30);
        assertEquals(herramienta.getDurabilidad(), 100 - 4);
        material = new Metal();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 50);
        assertEquals(herramienta.getDurabilidad(), 100 - 6);
        material = new Diamante();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 100);
        assertEquals(herramienta.getDurabilidad(), 100 - 8);
    }

    @Test
    public void testDetectorPatronDeHachaMaderaNODetectaPatronPicoMadera(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Madera(),() -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMaderaNODetectaPatronPicoPiedra(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Madera(),() -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMaderaNODetectaPatronPicoMetal(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Madera(),() -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMaderaNODetectaPatronPicoFino(){
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroPico = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        Ubicacion ubicacionF = new Ubicacion(1, 2);
        tableroPico.ubicarEnCasillero(metal, ubicacionA);
        tableroPico.ubicarEnCasillero(metal, ubicacionB);
        tableroPico.ubicarEnCasillero(metal, ubicacionC);
        tableroPico.ubicarEnCasillero(madera, ubicacionD);
        tableroPico.ubicarEnCasillero(madera, ubicacionE);
        tableroPico.ubicarEnCasillero(new Piedra(), ubicacionF);
        DetectorPatron dp = new DetectorPatronHacha(new Madera(),() -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMaderaNODetectaPatronHachaPiedra(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Madera(),() -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMaderaNODetectaPatronHachaMetal(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Madera(),() -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
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
        Material material = madera;
        Herramienta herramienta = resultado.get();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 10 - 5);
        assertEquals(herramienta.getDurabilidad(), 200 - 5);
        material = new Piedra();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 30);
        assertEquals(herramienta.getDurabilidad(), 200 - 10);
        material = new Metal();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 50);
        assertEquals(herramienta.getDurabilidad(), 200 - 15);
        material = new Diamante();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 100);
        assertEquals(herramienta.getDurabilidad(), 200 - 20);
    }


    @Test
    public void testDetectorPatronDeHachaPiedraNODetectaPatronPicoMadera(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Piedra(),() -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaPiedraNODetectaPatronPicoPiedra(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Piedra(),() -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaPiedraNODetectaPatronPicoMetal(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Piedra(),() -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaPiedraNODetectaPatronPicoFino(){
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroPico = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        Ubicacion ubicacionF = new Ubicacion(1, 2);
        tableroPico.ubicarEnCasillero(metal, ubicacionA);
        tableroPico.ubicarEnCasillero(metal, ubicacionB);
        tableroPico.ubicarEnCasillero(metal, ubicacionC);
        tableroPico.ubicarEnCasillero(madera, ubicacionD);
        tableroPico.ubicarEnCasillero(madera, ubicacionE);
        tableroPico.ubicarEnCasillero(new Piedra(), ubicacionF);
        DetectorPatron dp = new DetectorPatronHacha(new Piedra(),() -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaPiedraNODetectaPatronHachaMadera(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Piedra(),() -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaPiedraNODetectaPatronHachaMetal(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Piedra(),() -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test (expected = MaterialSeHaGastadoException.class)
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
        Material material = madera;
        Herramienta herramienta = resultado.get();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 10 - 10);
        assertEquals(herramienta.getDurabilidad(), 400 - (10/2));
        material = new Piedra();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 30);
        assertEquals(herramienta.getDurabilidad(), 400 - 2*(10/2));
        material = new Metal();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 50);
        assertEquals(herramienta.getDurabilidad(), 400 - 3*(10/2));
        material = new Diamante();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 100);
        assertEquals(herramienta.getDurabilidad(), 400 - 4*(10/2));
    }


    @Test
    public void testDetectorPatronDeHachaMetalNODetectaPatronPicoMadera(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMetalNODetectaPatronPicoPiedra(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMetalNODetectaPatronPicoMetal(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMetalNODetectaPatronPicoFino(){
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroPico = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        Ubicacion ubicacionF = new Ubicacion(1, 2);
        tableroPico.ubicarEnCasillero(metal, ubicacionA);
        tableroPico.ubicarEnCasillero(metal, ubicacionB);
        tableroPico.ubicarEnCasillero(metal, ubicacionC);
        tableroPico.ubicarEnCasillero(madera, ubicacionD);
        tableroPico.ubicarEnCasillero(madera, ubicacionE);
        tableroPico.ubicarEnCasillero(new Piedra(), ubicacionF);
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMetalNODetectaPatronHachaMadera(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDeHachaMetalNODetectaPatronHachaPiedra(){
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
        DetectorPatron dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

}



