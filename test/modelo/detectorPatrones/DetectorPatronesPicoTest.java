package modelo.detectorPatrones;

import modelo.estrategias.DesgasteAbrupto;
import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Herramienta;
import modelo.herramientas.Pico;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronPico;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static modelo.juego.ConstantesJuego.*;
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
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA).conDesgaste(DESGASTE_PICO_MADERA).conFuerza(FUERZA_PICO_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConPicoMadera);
        Herramienta herramienta = resultado.get();
        Material material = new Madera();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 10);
        assertEquals(herramienta.getDurabilidad(), 100 - 2);
        material = new Piedra();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 30 - 2);
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
    public void testDetectorPatronDePicoMaderaNODetectaPatronPicoPiedra(){
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
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA).conDesgaste(DESGASTE_PICO_MADERA).conFuerza(FUERZA_PICO_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConPicoPiedra);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMaderaNODetectaPatronPicoMetal(){
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroConPicoPiedra = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConPicoPiedra.ubicarEnCasillero(metal, ubicacionA);
        tableroConPicoPiedra.ubicarEnCasillero(metal, ubicacionB);
        tableroConPicoPiedra.ubicarEnCasillero(metal, ubicacionC);
        tableroConPicoPiedra.ubicarEnCasillero(madera, ubicacionD);
        tableroConPicoPiedra.ubicarEnCasillero(madera, ubicacionE);
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA).conDesgaste(DESGASTE_PICO_MADERA).conFuerza(FUERZA_PICO_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConPicoPiedra);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMaderaNODetectaPatronPicoFino(){
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
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA).conDesgaste(DESGASTE_PICO_MADERA).conFuerza(FUERZA_PICO_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMaderaNODetectaPatronHachaMadera(){
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
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA).conDesgaste(DESGASTE_PICO_MADERA).conFuerza(FUERZA_PICO_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMaderaNODetectaPatronHachaPiedra(){
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
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA).conDesgaste(DESGASTE_PICO_MADERA).conFuerza(FUERZA_PICO_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMaderaNODetectaPatronHachaMetal(){
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
        DetectorPatron dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA).conDesgaste(DESGASTE_PICO_MADERA).conFuerza(FUERZA_PICO_MADERA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
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
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA).conDesgaste(DESGASTE_PICO_PIEDRA).conFuerza(FUERZA_PICO_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConPicoPiedra);
        Herramienta herramienta = resultado.get();
        Material material = new Madera();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 10);
        assertEquals(herramienta.getDurabilidad(), 198);
        material = new Piedra();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 30 - 4);
        assertEquals(herramienta.getDurabilidad(), 196);
        material = new Metal();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 50 - 4);
        assertEquals(herramienta.getDurabilidad(), 194);
        material = new Diamante();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 100);
        assertEquals(herramienta.getDurabilidad(), 192);
    }

    @Test
    public void testDetectorPatronDePicoPiedraNODetectaPatronPicoMadera(){
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
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA).conDesgaste(DESGASTE_PICO_PIEDRA).conFuerza(FUERZA_PICO_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoPiedraNODetectaPatronPicoMetal(){
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
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA).conDesgaste(DESGASTE_PICO_PIEDRA).conFuerza(FUERZA_PICO_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoPiedraNODetectaPatronPicoFino(){
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
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA).conDesgaste(DESGASTE_PICO_PIEDRA).conFuerza(FUERZA_PICO_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoPiedraNODetectaPatronHachaMadera(){
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
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA).conDesgaste(DESGASTE_PICO_PIEDRA).conFuerza(FUERZA_PICO_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoPiedraNODetectaPatronHachaPiedra(){
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
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA).conDesgaste(DESGASTE_PICO_PIEDRA).conFuerza(FUERZA_PICO_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoPiedraNODetectaPatronHachaMetal(){
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
        DetectorPatron dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA).conDesgaste(DESGASTE_PICO_PIEDRA).conFuerza(FUERZA_PICO_PIEDRA)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
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
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().conMaterial(new Metal())
                .conDurabilidad(400).conDesgaste(new DesgasteAbrupto()).conFuerza(12)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroConPicoMetal);
        Herramienta herramienta = resultado.get();
        Material material = new Madera();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 10);
        assertEquals(herramienta.getDurabilidad(), 400);
        material = new Piedra();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 30 - 12);
        assertEquals(herramienta.getDurabilidad(), 400);
        material = new Metal();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 50);
        assertEquals(herramienta.getDurabilidad(), 400);
        material = new Diamante();
        herramienta.usar(material);
        assertEquals(material.getDurabilidad(), 100);
        assertEquals(herramienta.getDurabilidad(), 400);
    }

    @Test
    public void testDetectorPatronDePicoMetalNODetectaPatronPicoMadera(){
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
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL).conDesgaste(DESGASTE_PICO_METAL).conFuerza(FUERZA_PICO_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMetalNODetectaPatronPicoPiedra(){
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
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL).conDesgaste(DESGASTE_PICO_METAL).conFuerza(FUERZA_PICO_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMetalNODetectaPatronPicoFino(){
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
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL).conDesgaste(DESGASTE_PICO_METAL).conFuerza(FUERZA_PICO_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroPico);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMetalNODetectaPatronHachaMadera(){
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
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL).conDesgaste(DESGASTE_PICO_METAL).conFuerza(FUERZA_PICO_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMetalNODetectaPatronHachaPiedra(){
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
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL).conDesgaste(DESGASTE_PICO_METAL).conFuerza(FUERZA_PICO_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testDetectorPatronDePicoMetalNODetectaPatronHachaMetal(){
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
        DetectorPatron dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL).conDesgaste(DESGASTE_PICO_METAL).conFuerza(FUERZA_PICO_METAL)
                .construir());
        Optional<Herramienta> resultado = dp.resolverPatron(tableroHacha);
        assertFalse(resultado.isPresent());
    }

}
