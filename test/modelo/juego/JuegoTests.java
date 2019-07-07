package modelo.juego;

import junit.framework.Assert;
import modelo.estrategias.DesgasteAbrupto;
import modelo.estrategias.DesgasteLinealFactor;
import modelo.estrategias.EstrategiaDesgaste;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.herramientas.*;
import modelo.mapa.Casillero;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.*;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JuegoTests {

    Herramienta hachaMaderaTest = new ConstructorHacha()
            .conMaterial(new Madera())
            .conDurabilidad(DURABILIDAD_HACHA_MADERA)
            .conDesgaste(DESGASTE_HACHA_MADERA)
            .conFuerza(FUERZA_HACHA_MADERA)
            .construir();
    Mapa mapaTest;
    Jugador jugadorTest = new Jugador(hachaMaderaTest, null,null);
    private HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientasTest;
    private HashMap<Material, Integer> inventarioMaterialesJugadorTest;
    private DetectorPatron detectorPatronTest;


    private void inicializarInventarioMaterialesTest(){
        inventarioMaterialesJugadorTest.put(new Madera(), 0);
        inventarioMaterialesJugadorTest.put(new Metal(), 0);
        inventarioMaterialesJugadorTest.put(new Piedra(), 0);
        inventarioMaterialesJugadorTest.put(new Diamante(), 0);
    }

    private void inicializarMapaTestConMateriales() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 9; j <= 11; j++) {
                mapaTest.ubicarEnCasillero(new Madera(),new Ubicacion(i, j));
            }
        }

        for (int i = 9; i <= 11; i++) {
            for (int j = 1; j <= 3; j++) {
                mapaTest.ubicarEnCasillero(new Madera(),new Ubicacion(i, j));
            }
        }

        for (int i = 4; i <= 7; i++) {
            for (int j = 4; j <= 7; j++) {
                mapaTest.ubicarEnCasillero(new Piedra(),new Ubicacion(i, j));
            }
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 2 ; j++) {
                mapaTest.ubicarEnCasillero(new Metal(),new Ubicacion(i, j));
            }
        }

        for (int i = 8; i <= 9; i++) {
            for (int j = 8; j <= 9 ; j++) {
                mapaTest.ubicarEnCasillero(new Metal(),new Ubicacion(i, j));
            }
        }

        Ubicacion ubicacion1 = new Ubicacion(10,10);
        Ubicacion ubicacion2 = new Ubicacion(12,1);
        mapaTest.ubicarEnCasillero(new Diamante(), ubicacion1);
        mapaTest.ubicarEnCasillero(new Diamante(), ubicacion2);
    }

    private void agregarListaDeHerramientasAinventarioHerramientasTest(ConstructorHerramientaAbstracto constructor,
                                                                   Material material, int durabilidad, int fuerza, EstrategiaDesgaste desgaste) {
        constructor.conMaterial(material).conDurabilidad(durabilidad)
                .conDesgaste(desgaste)
                .conFuerza(fuerza);
        inventarioHerramientasTest.put(constructor.construir(), new ArrayList<>());
    }

    public void inicializarInventarioHerramientaTest() {
        agregarListaDeHerramientasAinventarioHerramientasTest(new ConstructorHacha(), new Madera(),
                DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, DESGASTE_HACHA_MADERA);
        agregarListaDeHerramientasAinventarioHerramientasTest(new ConstructorHacha(), new Piedra(),
                DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, DESGASTE_HACHA_PIEDRA);
        agregarListaDeHerramientasAinventarioHerramientasTest(new ConstructorHacha(), new Metal(),
                DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, DESGASTE_HACHA_METAL);
        agregarListaDeHerramientasAinventarioHerramientasTest(new ConstructorPico(), new Madera(),
                DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, DESGASTE_PICO_MADERA);
        agregarListaDeHerramientasAinventarioHerramientasTest(new ConstructorPico(), new Piedra(),
                DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, DESGASTE_PICO_PIEDRA);
        agregarListaDeHerramientasAinventarioHerramientasTest(new ConstructorPico(), new Metal(),
                DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, DESGASTE_PICO_METAL);
        agregarListaDeHerramientasAinventarioHerramientasTest(new ConstructorPicoFino(), new Metal(),
                DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO, DESGASTE_PICO_FINO);
    }


    public void inicializarMapaTestConJugador(){
            Hacha hachaInicial = (Hacha) new ConstructorHacha()
                    .conMaterial(new Madera())
                    .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                    .conDesgaste(DESGASTE_HACHA_MADERA)
                    .conFuerza(FUERZA_HACHA_MADERA)
                    .construir();
            mapaTest.ubicarEnCasillero(jugadorTest, new Ubicacion(1,6));
            jugadorTest = new Jugador(hachaInicial, null,null);
            inventarioHerramientasTest.get(hachaInicial).add(hachaInicial);
        }

    private void inicializarPatronesTest() {
        DetectorPatron dPHachaMadera = new DetectorPatronHacha(new Madera(), () -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        DetectorPatron dPHachaPiedra = new DetectorPatronHacha(new Piedra(), () -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir(), dPHachaMadera);
        DetectorPatron dPHachaMetal = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir(), dPHachaPiedra);
        DetectorPatron dPPicoMadera = new DetectorPatronPico(new Madera(), () -> new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir(), dPHachaMetal);
        DetectorPatron dPPicoPiedra = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .construir(), dPPicoMadera);
        DetectorPatron dPPicoMetal = new DetectorPatronPico(new Metal(), () -> new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir(), dPPicoPiedra);
        DetectorPatron dPPicoFino = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir(), dPPicoMetal);
        detectorPatronTest = dPPicoFino;
    }

    @Before
    public void setup() {
          mapaTest = new Mapa(12, 12);
          inventarioHerramientasTest = new HashMap<>();
          inventarioMaterialesJugadorTest = new HashMap<>();

    }

    @Test
    public void testSeCreaElTableroDeJuegoConLosMaterialesDondeCorresponde() {
        inicializarMapaTestConMateriales();
        Juego juego = new Juego();
        juego.inicializarMapaConMateriales();
        Mapa mapaJuego = juego.obtenerMapa();
        assertTrue(mapaJuego.esIgualA(mapaTest));
    }


    @Test
    public void testSeCreaElJuegoConElJugadorDondeCorresponde() {
        inicializarInventarioHerramientaTest();
        inicializarMapaTestConJugador();
        inicializarMapaTestConMateriales();
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Mapa mapaJuego = juego.obtenerMapa();
        assertTrue(mapaJuego.esIgualA(mapaTest));

    }

    @Test
    public void testSeInicializaJugadorConUnHachaMadera(){
        Juego juego = new Juego();
        juego.inicializarMapaConMateriales();
        juego.inicializarInventarioHerramienta();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        assertTrue(jugador.obtenerHerramientaActual().equals(hachaInicial));
    }



    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteoParaPatronHachaMadera(){
        PatronHacha patron = new PatronHacha(new Madera());
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,1), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,3), new Madera());
        Mapa tableroJuego = juego.obtenerTableroCrafteo();
        Mapa tableroPatron = patron.getMapa();
        assertTrue(tableroJuego.esIgualA(tableroPatron));
    }

    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteoParaPatronHachaPiedra(){
        PatronHacha patron = new PatronHacha(new Piedra());
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), new Piedra());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,2), new Piedra());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,1), new Piedra());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,3), new Madera());
        Mapa tableroJuego = juego.obtenerTableroCrafteo();
        Mapa tableroPatron = patron.getMapa();
        assertTrue(tableroJuego.esIgualA(tableroPatron));
    }

    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteoParaPatronHachaMetal(){
        PatronHacha patron = new PatronHacha(new Metal());
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,2), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,3), new Madera());
        Mapa tableroJuego = juego.obtenerTableroCrafteo();
        Mapa tableroPatron = patron.getMapa();
        assertTrue(tableroJuego.esIgualA(tableroPatron));
    }

    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteoParaPatronPicoMadera(){
        PatronPico patron = new PatronPico (new Madera());
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,1), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(3,1), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,3), new Madera());
        Mapa tableroJuego = juego.obtenerTableroCrafteo();
        Mapa tableroPatron = patron.getMapa();
        assertTrue(tableroJuego.esIgualA(tableroPatron));
    }

    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteoParaPatronPicoPiedra(){
        PatronPico patron = new PatronPico (new Piedra());
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), new Piedra());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,1), new Piedra());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(3,1), new Piedra());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,3), new Madera());
        Mapa tableroJuego = juego.obtenerTableroCrafteo();
        Mapa tableroPatron = patron.getMapa();
        assertTrue(tableroJuego.esIgualA(tableroPatron));
    }

    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteoParaPatronPicoMetal(){
        PatronPico patron = new PatronPico (new Metal());
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(3,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,3), new Madera());
        Mapa tableroJuego = juego.obtenerTableroCrafteo();
        Mapa tableroPatron = patron.getMapa();
        assertTrue(tableroJuego.esIgualA(tableroPatron));
    }

    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteoParaPatronPicoFino(){
        PatronPicoFino patron = new PatronPicoFino (new Metal());
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(3,1), new Metal());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,2), new Piedra());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,2), new Madera());
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(2,3), new Madera());
        Mapa tableroJuego = juego.obtenerTableroCrafteo();
        Mapa tableroPatron = patron.getMapa();
        assertTrue(tableroJuego.esIgualA(tableroPatron));
    }

    @Test
    public void testJugadorDesgastaMaderaAlMoverseHaciaElla(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(1,9));
        Madera madera = (Madera) casillero.obtenerUbicable();
        assertThat(madera.getDurabilidad(), CoreMatchers.is(8));

    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlDesgastarMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Herramienta hachaMadera = jugador.obtenerHerramientaActual();
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorNoDesgastaPiedraAlMoverseHaciaEllaConHachaMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(4,6));
        Piedra piedra = (Piedra) casillero.obtenerUbicable();
        assertThat(piedra.getDurabilidad(), CoreMatchers.is(30));

    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlMoverseHaciaPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Herramienta hachaMadera = jugador.obtenerHerramientaActual();
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorNoDesgastaMetalAlMoverseHaciaElConHachaMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(2,1));
        Metal metal = (Metal) casillero.obtenerUbicable();
        assertThat(metal.getDurabilidad(), CoreMatchers.is(50));

    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Herramienta hachaMadera = jugador.obtenerHerramientaActual();
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorNoDesgastaDiamanteAlMoverseHaciaElConHachaMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Mapa tablero = juego.obtenerMapa();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, tablero);
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(10,10));
        Diamante diamante = (Diamante) casillero.obtenerUbicable();
        assertThat(diamante.getDurabilidad(), CoreMatchers.is(100));
    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlMoverseHaciaDiamante(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        Herramienta hachaMadera = jugador.obtenerHerramientaActual();
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorDesgastaMaderaAlMoverseHaciaEllaConHachaPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(1,9));
        Madera madera = (Madera) casillero.obtenerUbicable();
        assertThat(madera.getDurabilidad(), CoreMatchers.is(5));

    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlDesgastarMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(195));
    }

    @Test
    public void testJugadorNoDesgastaPiedraAlMoverseHaciaEllaConHachaPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(4,6));
        Piedra piedra = (Piedra) casillero.obtenerUbicable();
        assertThat(piedra.getDurabilidad(), CoreMatchers.is(30));

    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlMoverseHaciaPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(195));
    }

    @Test
    public void testJugadorNoDesgastaMetalAlMoverseHaciaElConHachaPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(2,1));
        Metal metal = (Metal) casillero.obtenerUbicable();
        assertThat(metal.getDurabilidad(), CoreMatchers.is(50));

    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Herramienta hachaMadera = jugador.obtenerHerramientaActual();
        assertThat(hachaMadera.getDurabilidad(), is(195));
    }

    @Test
    public void testJugadorNoDesgastaDiamanteAlMoverseHaciaElConHachaPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, tablero);
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(10,10));
        Diamante diamante = (Diamante) casillero.obtenerUbicable();
        assertThat(diamante.getDurabilidad(), CoreMatchers.is(100));
    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlMoverseHaciaDiamante(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1),200, 5, new Piedra());
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(195));
    }
    //--------------------------------------------------------------------------------------------------------------

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testJugadorDesgastaMaderaAlMoverseHaciaEllaConHachaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioMaterial();
        juego.inicializarInventarioHerramienta();
        juego.inicializarJugador();
        juego.inicializarMapaConMateriales();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(0.5), 400, 10, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(1,9));
        casillero.eliminarUbicable();
        }

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testJugadorDesgastaHachaMetalAlDesgastarMadera(){
        Juego juego = new Juego();

        juego.inicializarInventarioMaterial();
        juego.inicializarInventarioHerramienta();
        juego.inicializarJugador();
        juego.inicializarMapaConMateriales();

        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(0.5), 400, 10, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa mapa = juego.obtenerMapa();
        jugador.moverseALaDerecha(mapa);
        jugador.moverseALaDerecha(mapa);
        jugador.moverseALaDerecha(mapa);
        assertThat(jugador.obtenerHerramientaActual().getDurabilidad(), is(395));
    }

    @Test
    public void testJugadorNoDesgastaPiedraAlMoverseHaciaEllaConHachaMetal() {
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(0.5), 400, 10, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(4, 6));
        Piedra piedra = (Piedra) casillero.obtenerUbicable();
        assertThat(piedra.getDurabilidad(), CoreMatchers.is(30));
    }




    @Test
    public void testJugadorNoDesgastaMetalAlMoverseHaciaElConHachaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1/2), 400, 10, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(2,1));
        Metal metal = (Metal) casillero.obtenerUbicable();
        assertThat(metal.getDurabilidad(), CoreMatchers.is(50));

    }

    @Test
    public void testJugadorNoDesgastaDiamanteAlMoverseHaciaElConHachaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(1/2), 400, 10, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, tablero);
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(10,10));
        Diamante diamante = (Diamante) casillero.obtenerUbicable();
        assertThat(diamante.getDurabilidad(), CoreMatchers.is(100));
    }

    @Test
    public void testJugadorDesgastaHachaMetalAlMoverseHaciaDiamante(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(0.5), 400, 10, new Metal());
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(jugador.obtenerHerramientaActual().getDurabilidad(), is(395));
    }

    @Test
    public void testJugadorDesgastaHachaMetalAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(new DesgasteLinealFactor(0.5), 400, 10, new Metal());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(395));
    }

    //--------------------------------------------------------------------------------------------------------------

    @Test
    public void testJugadorNoDesgastaMaderaAlMoverseHaciaEllaConPicoMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteAbrupto(), 400, 12, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(1,9));
        Madera madera = (Madera) casillero.obtenerUbicable();
        assertThat(madera.getDurabilidad(), CoreMatchers.is(10));

    }

    @Test
    public void testJugadorDesgastaPicoMetalAlDesgastarMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteAbrupto(), 400, 12, new Metal());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(400));
    }

    @Test
    public void testJugadorDesgastaPiedraAlMoverseHaciaEllaConPicoMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteAbrupto(), 400, 12, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(4,6));
        Piedra piedra = (Piedra) casillero.obtenerUbicable();
        assertThat(piedra.getDurabilidad(), CoreMatchers.is(18));

    }

    @Test
    public void testJugadorDesgastaPicoMetalAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteAbrupto(), 400, 12, new Metal());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(400));
    }

    @Test
    public void testJugadorNoDesgastaMetalAlMoverseHaciaElConPicoMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteAbrupto(), 400, 12, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(2,1));
        Metal metal = (Metal) casillero.obtenerUbicable();
        assertThat(metal.getDurabilidad(), CoreMatchers.is(50));

    }

    @Test
    public void testJugadorNoDesgastaDiamanteAlMoverseHaciaElConPicoMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteAbrupto(), 400, 12, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, tablero);
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(10,10));
        Diamante diamante = (Diamante) casillero.obtenerUbicable();
        assertThat(diamante.getDurabilidad(), CoreMatchers.is(100));
    }

    @Test
    public void testJugadorDesgastaMetalAlMoverseHaciaElConPicoPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(2/3), 200, 4, new Piedra());

        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(2,2));
        Metal metal = (Metal) casillero.obtenerUbicable();
        assertThat(metal.getDurabilidad(), is(46));

    }

    @Test
    public void testJugadorNoDesgastaDiamanteAlMoverseHaciaElConPicoPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(2/3), 200, 4, new Piedra());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, tablero);
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(10,10));
        Diamante diamante = (Diamante) casillero.obtenerUbicable();
        assertThat(diamante.getDurabilidad(), CoreMatchers.is(100));
    }

    @Test
    public void testJugadorDesgastaPicoPiedraAlMoverseHaciaDiamante(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1/(1.5)), 200, 4, new Piedra());
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(198));
    }

    @Test
    public void testJugadorDesgastaPicoMetalAlMoverseHaciaDiamante(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteAbrupto(), 400, 12, new Metal());
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(400));
    }



    @Test
    public void testJugadorDesgastaPicoPiedraAlDesgastarMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1/(1.5)), 200, 4, new Piedra());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        assertThat(jugador.obtenerHerramientaActual().getDurabilidad(), is(198));
    }

    @Test
    public void testJugadorDesgastaPiedraAlMoverseHaciaEllaConPicoPiedra(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1/(1.5)), 200, 4, new Piedra());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(4,6));
        Piedra piedra = (Piedra) casillero.obtenerUbicable();
        assertThat(piedra.getDurabilidad(), CoreMatchers.is(26));

    }

    @Test
    public void testJugadorDesgastaPicoPiedraAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1/(1.5)), 200, 4, new Piedra());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(198));
    }


    //--------------------------------------------------------------------------------------------------------------

    @Test
    public void testJugadorNoDesgastaMaderaAlMoverseHaciaEllaConPicoFino(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new PicoFino(new DesgasteLinealFactor(0.1), 1000, 20);
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(1,9));
        Madera madera = (Madera) casillero.obtenerUbicable();
        assertThat(madera.getDurabilidad(), CoreMatchers.is(10));

    }

    @Test
    public void testJugadorDesgastaPicoFinoAlDesgastarMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new PicoFino(new DesgasteLinealFactor(0.1), 1000, 20);
        jugador.setHerramientaActual(herramienta);
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(998));
    }

    @Test
    public void testJugadorNoDesgastaPiedraAlMoverseHaciaEllaConPicoFino(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new PicoFino(new DesgasteLinealFactor(1/10), 1000, 20);
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(4,6));
        Piedra piedra = (Piedra) casillero.obtenerUbicable();
        assertThat(piedra.getDurabilidad(), CoreMatchers.is(30));

    }

    @Test
    public void testJugadorDesgastaPicoFinoAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new PicoFino(new DesgasteLinealFactor(0.1), 1000, 20);
        jugador.setHerramientaActual(herramienta);
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(jugador.obtenerHerramientaActual().getDurabilidad(), is(998));
    }

    @Test
    public void testJugadorNoDesgastaMetalAlMoverseHaciaElConPicoFino(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new PicoFino(new DesgasteLinealFactor(1/10), 1000, 20);
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(2,1));
        Metal metal = (Metal) casillero.obtenerUbicable();
        assertThat(metal.getDurabilidad(), CoreMatchers.is(50));

    }

    @Test
    public void testJugadorDesgastaDiamanteAlMoverseHaciaElConPicoFino(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new PicoFino(new DesgasteLinealFactor(1/10), 1000, 20);
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, tablero);
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(10,10));
        Diamante diamante = (Diamante) casillero.obtenerUbicable();
        assertThat(diamante.getDurabilidad(), CoreMatchers.is(80));
    }


    @Test
    public void testJugadorDesgastaPicoFinoAlMoverseHaciaDiamante(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new PicoFino(new DesgasteLinealFactor(0.1), 1000, 20);
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(jugador.obtenerHerramientaActual().getDurabilidad(), is(998));
    }


    //--------------------------------------------------------------------------------------------------------------

    @Test
    public void testJugadorNoDesgastaMaderaAlMoverseHaciaEllaConPicoMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1), 100, 2, new Madera());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(1,9));
        Madera madera = (Madera) casillero.obtenerUbicable();
        assertThat(madera.getDurabilidad(), CoreMatchers.is(10));

    }

    @Test
    public void testJugadorDesgastaPicoMaderaAlDesgastarMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1), 100, 2, new Madera());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorDesgastaPiedraAlMoverseHaciaEllaConPicoMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1), 100, 2, new Madera());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(4,6));
        Piedra piedra = (Piedra) casillero.obtenerUbicable();
        assertThat(piedra.getDurabilidad(), CoreMatchers.is(28));

    }

    @Test
    public void testJugadorDesgastaPicoMaderaAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1), 100, 2, new Madera());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorNoDesgastaMetalAlMoverseHaciaElConPicoMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1), 100, 2, new Madera());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        jugador.moverseALaIzquierda(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(2,1));
        Metal metal = (Metal) casillero.obtenerUbicable();
        assertThat(metal.getDurabilidad(), CoreMatchers.is(50));

    }

    @Test
    public void testJugadorNoDesgastaDiamanteAlMoverseHaciaElConPicoMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1), 100, 2, new Madera());
        Mapa tablero = juego.obtenerMapa();
        moverseHastaDiamanteSegunMapaPlaneado(jugador, tablero);
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(10,10));
        Diamante diamante = (Diamante) casillero.obtenerUbicable();
        assertThat(diamante.getDurabilidad(), CoreMatchers.is(100));
    }


    @Test
    public void testJugadorDesgastaPicoMaderaAlMoverseHaciaDiamante(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Pico(new DesgasteLinealFactor(1), 100, 2, new Madera());
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(98));
    }



    private void moverseHastaDiamanteSegunMapaPlaneado(Jugador jugador, Mapa mapa){
        jugador.moverseAbajo(mapa);
        jugador.moverseAbajo(mapa);
        jugador.moverseALaDerecha(mapa);
        jugador.moverseALaDerecha(mapa);
        for (int i=0; i<4; i++) jugador.moverseAbajo(mapa);
        jugador.moverseALaDerecha(mapa);
        jugador.moverseALaDerecha(mapa);
        for (int i=0; i<3; i++) jugador.moverseAbajo(mapa);
    }

    //Tests de la parte de Crafteo

    @Test
    public void testMapaCrafteoUbicaMaterialesParaHachaMaderaCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
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
        juego.ubicarMaterialTableroCrafteo(ubicacionA, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        assertTrue(tableroConHachaMadera.esIgualA(juego.obtenerTableroCrafteo()));
    }

    @Test
    public void testMapaCrafteoUbicaMaterialesParaHachaPiedraCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Mapa tableroHacha = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroHacha.ubicarEnCasillero(piedra, ubicacionA);
        tableroHacha.ubicarEnCasillero(piedra, ubicacionB);
        tableroHacha.ubicarEnCasillero(piedra, ubicacionC);
        tableroHacha.ubicarEnCasillero(madera, ubicacionD);
        tableroHacha.ubicarEnCasillero(madera, ubicacionE);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        assertTrue(tableroHacha.esIgualA(juego.obtenerTableroCrafteo()));
    }

    @Test
    public void testMapaCrafteoUbicaMaterialesParaHachaMetalCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroConHachaMadera = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConHachaMadera.ubicarEnCasillero(metal, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(metal, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(metal, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        assertTrue(tableroConHachaMadera.esIgualA(juego.obtenerTableroCrafteo()));
    }

    @Test
    public void testMapaCrafteoUbicaMaterialesParaPicoMaderaCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Madera madera = new Madera();
        Mapa tableroConHachaMadera = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 3);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        assertTrue(tableroConHachaMadera.esIgualA(juego.obtenerTableroCrafteo()));
    }

    @Test
    public void testMapaCrafteoUbicaMaterialesParaPicoPiedraCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Mapa tableroConHachaMadera = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 3);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(piedra, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        assertTrue(tableroConHachaMadera.esIgualA(juego.obtenerTableroCrafteo()));
    }

    @Test
    public void testMapaCrafteoUbicaMaterialesParaPicoMetalCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroConHachaMadera = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 3);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        tableroConHachaMadera.ubicarEnCasillero(metal, ubicacionA);
        tableroConHachaMadera.ubicarEnCasillero(metal, ubicacionB);
        tableroConHachaMadera.ubicarEnCasillero(metal, ubicacionC);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionD);
        tableroConHachaMadera.ubicarEnCasillero(madera, ubicacionE);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        assertTrue(tableroConHachaMadera.esIgualA(juego.obtenerTableroCrafteo()));
    }
    @Test
    public void testMapaCrafteoUbicaMaterialesParaPicoFinoCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Mapa tableroPicoFino = new Mapa(3,3);
        Ubicacion ubicacionA = new Ubicacion(1, 3);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        Ubicacion ubicacionF = new Ubicacion(2, 1);
        tableroPicoFino.ubicarEnCasillero(metal, ubicacionA);
        tableroPicoFino.ubicarEnCasillero(metal, ubicacionB);
        tableroPicoFino.ubicarEnCasillero(metal, ubicacionC);
        tableroPicoFino.ubicarEnCasillero(madera, ubicacionD);
        tableroPicoFino.ubicarEnCasillero(madera, ubicacionE);
        tableroPicoFino.ubicarEnCasillero(new Piedra(), ubicacionF);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionF, new Piedra());
        assertTrue(tableroPicoFino.esIgualA(juego.obtenerTableroCrafteo()));
    }

    @Test
    public void testMapaCrafeoUbicaCorrectamenteUnHachaDeMaderaYDevuelveHerramientaCorrecta(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Madera madera = new Madera();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        Material material = madera;
        Herramienta herramienta = juego.obtenerHerramientaCrafteable();
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
    public void testMapaCrafeoUbicaCorrectamenteUnHachaDePiedraYDevuelveHerramientaCorrecta(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        Material material = madera;
        Herramienta herramienta = juego.obtenerHerramientaCrafteable();
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

    @Test (expected = MaterialSeHaGastadoException.class)
    public void testMapaCrafteoUbicaCorrectamenteUnHachaDeMetalYDevuelveHerramientaCorrecta(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Madera madera = new Madera();
        Metal metal = new Metal();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        Material material = madera;
        Herramienta herramienta = juego.obtenerHerramientaCrafteable();
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
    public void testMapaCrafeoUbicaCorrectamenteUnPicoDeMaderaYDevuelveHerramientaCorrecta() {
        Juego juego = new Juego();
        juego.inicializarJuego();
        Madera madera = new Madera();
        Mapa tableroConPicoMadera = new Mapa(3, 3);
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        Herramienta herramienta = juego.obtenerHerramientaCrafteable();
        Material material = new Madera();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 10);
        Assert.assertEquals(herramienta.getDurabilidad(), 100 - 2);
        material = new Piedra();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 30 - 2);
        Assert.assertEquals(herramienta.getDurabilidad(), 100 - 4);
        material = new Metal();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 50);
        Assert.assertEquals(herramienta.getDurabilidad(), 100 - 6);
        material = new Diamante();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 100);
        Assert.assertEquals(herramienta.getDurabilidad(), 100 - 8);
    }

    @Test
    public void testMapaCrafeoUbicaCorrectamenteUnPicoDePiedraYDevuelveHerramientaCorrecta(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        Herramienta herramienta = juego.obtenerHerramientaCrafteable();
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
    public void testMapaCrafeoUbicaCorrectamenteUnPicoDeMetalYDevuelveHerramientaCorrecta(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        Herramienta herramienta = juego.obtenerHerramientaCrafteable();
        Material material = new Madera();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 10);
        Assert.assertEquals(herramienta.getDurabilidad(), 400);
        material = new Piedra();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 30 - 12);
        Assert.assertEquals(herramienta.getDurabilidad(), 400);
        material = new Metal();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 50);
        Assert.assertEquals(herramienta.getDurabilidad(), 400);
        material = new Diamante();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 100);
        Assert.assertEquals(herramienta.getDurabilidad(), 400);
    }

    @Test
    public void testMapaCrafeoUbicaCorrectamenteUnPicoFinoYDevuelveHerramientaCorrecta() {
        Juego juego = new Juego();
        juego.inicializarJuego();
        juego.ubicarMaterialTableroCrafteo((new Ubicacion(1,1)), (new Metal()));
        juego.ubicarMaterialTableroCrafteo((new Ubicacion(2,1)), (new Metal()));
        juego.ubicarMaterialTableroCrafteo((new Ubicacion(3,1)), (new Metal()));
        juego.ubicarMaterialTableroCrafteo((new Ubicacion(1,2)), new Piedra());
        juego.ubicarMaterialTableroCrafteo((new Ubicacion(2,2)), (new Madera()));
        juego.ubicarMaterialTableroCrafteo((new Ubicacion(2,3)), (new Madera()));
        Herramienta herramienta = juego.obtenerHerramientaCrafteable();
        Material material = new Madera();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 10);
        Assert.assertEquals(herramienta.getDurabilidad(), 1000 - 2);
        material = new Piedra();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 30);
        Assert.assertEquals(herramienta.getDurabilidad(), 1000 - 4);
        material = new Metal();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 50);
        Assert.assertEquals(herramienta.getDurabilidad(), 1000 - 6);
        material = new Diamante();
        herramienta.usar(material);
        Assert.assertEquals(material.getDurabilidad(), 100 - 20);
        Assert.assertEquals(herramienta.getDurabilidad(), 1000 - 8);
    }
    @Test
    public void testSeCreaHachaMaderaCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        ArrayList<Herramienta> hachasMadera;
        Madera madera = new Madera();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        hachasMadera = juego.obtenerInventarioHerramientas().get(juego.obtenerHerramientaCrafteable());
        assertThat(hachasMadera.size(), is(1));
        juego.crearHerramienta();
        assertThat(hachasMadera.size(), is(2));
    }

    @Test
    public void testSeCreaHachaPiedraCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        ArrayList<Herramienta> herramientasTipo;
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        herramientasTipo = juego.obtenerInventarioHerramientas().get(juego.obtenerHerramientaCrafteable());
        assertThat(herramientasTipo.size(), is(0));
        juego.crearHerramienta();
        assertThat(herramientasTipo.size(), is(1));
    }

    @Test
    public void testSeCreaHachaMetalCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        ArrayList<Herramienta> herramientasTipo;
        Madera madera = new Madera();
        Metal metal = new Metal();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        herramientasTipo = juego.obtenerInventarioHerramientas().get(juego.obtenerHerramientaCrafteable());
        assertThat(herramientasTipo.size(), is(0));
        juego.crearHerramienta();
        assertThat(herramientasTipo.size(), is(1));
    }

    @Test
    public void testSeCreaPicoMetalCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        ArrayList<Herramienta> herramientasTipo;
        Madera madera = new Madera();
        Metal metal = new Metal();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        herramientasTipo = juego.obtenerInventarioHerramientas().get(juego.obtenerHerramientaCrafteable());
        assertThat(herramientasTipo.size(), is(0));
        juego.crearHerramienta();
        assertThat(herramientasTipo.size(), is(1));
    }

    @Test
    public void testSeCreaPicoPiedraPiedraCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        ArrayList<Herramienta> herramientasTipo;
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, piedra);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        herramientasTipo = juego.obtenerInventarioHerramientas().get(juego.obtenerHerramientaCrafteable());
        assertThat(herramientasTipo.size(), is(0));
        juego.crearHerramienta();
        assertThat(herramientasTipo.size(), is(1));
    }

    @Test
    public void testSeCreaPicoMaderaPiedraCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        ArrayList<Herramienta> herramientasTipo;
        Madera madera = new Madera();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        herramientasTipo = juego.obtenerInventarioHerramientas().get(juego.obtenerHerramientaCrafteable());
        assertThat(herramientasTipo.size(), is(0));
        juego.crearHerramienta();
        assertThat(herramientasTipo.size(), is(1));
    }

    @Test
    public void testSeCreaPicoFinoPiedraCorrectamente(){
        Juego juego = new Juego();
        juego.inicializarJuego();
        ArrayList<Herramienta> herramientasTipo;
        Madera madera = new Madera();
        Metal metal = new Metal();
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        Ubicacion ubicacionD = new Ubicacion(2, 2);
        Ubicacion ubicacionE = new Ubicacion(2, 3);
        Ubicacion ubicacionF = new Ubicacion(1, 2);
        juego.ubicarMaterialTableroCrafteo(ubicacionA, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, metal);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionF, new Piedra());
        herramientasTipo = juego.obtenerInventarioHerramientas().get(juego.obtenerHerramientaCrafteable());
        assertThat(herramientasTipo.size(), is(0));
        juego.crearHerramienta();
        assertThat(herramientasTipo.size(), is(1));
    }

    @Test
    public void testSeCreaHerramientaVaciaTableroCrafteo(){
        Juego juego = new Juego();
        juego.inicializarJuego();
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
        juego.ubicarMaterialTableroCrafteo(ubicacionA, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionB, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionC, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionD, madera);
        juego.ubicarMaterialTableroCrafteo(ubicacionE, madera);
        assertTrue(tableroConHachaMadera.esIgualA(juego.obtenerTableroCrafteo()));
        juego.crearHerramienta();
        tableroConHachaMadera.eliminarDeCasillero(ubicacionA);
        tableroConHachaMadera.eliminarDeCasillero(ubicacionB);
        tableroConHachaMadera.eliminarDeCasillero(ubicacionC);
        tableroConHachaMadera.eliminarDeCasillero(ubicacionD);
        tableroConHachaMadera.eliminarDeCasillero(ubicacionE);
        assertTrue(tableroConHachaMadera.esIgualA(juego.obtenerTableroCrafteo()));
    }

    @Test
    public void testJugadorPuedeMoverseHaciaLaDerechaEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarJuego();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseALaDerecha(juego.obtenerMapa());
    }


    @Test
    public void testJugadorNoCambiaDePosicionALaTerceraVezDeMoverseAbajoEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Ubicacion ubicacion1 = jugador.obtenerUbicacion();
        jugador.moverseAbajo(juego.obtenerMapa());
        assertFalse(jugador.obtenerUbicacion() == ubicacion1);
        Ubicacion ubicacion2 = jugador.obtenerUbicacion();
        jugador.moverseAbajo(juego.obtenerMapa());
        assertFalse(jugador.obtenerUbicacion() == ubicacion2);
        Ubicacion ubicacion3 = jugador.obtenerUbicacion();
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(jugador.obtenerUbicacion(), CoreMatchers.is(ubicacion3));
    }


    @Test
    public void testElInventarioDeMaterialesSeInicializaCorrectamente() {
        Juego juego = new Juego();
        juego.inicializarInventarioMaterial();
        inicializarInventarioMaterialesTest();
        assertTrue(juego.obtenerInventarioMaterialesJugador().equals(inventarioMaterialesJugadorTest));
    }

    @Test
        public void testElInventarioDeHerramientasSeInicializaCorrectamente() {
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        inicializarInventarioHerramientaTest();
        assertTrue(juego.obtenerInventarioHerramientas().equals(inventarioHerramientasTest));
    }

    @Test(expected = NoExisteNingunCasilleroParaLaUbicacionDadaException.class)
    public void testJugadorNoPuedeMoverseHaciaArribaEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarJuego();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseArriba(juego.obtenerMapa());
    }

}
