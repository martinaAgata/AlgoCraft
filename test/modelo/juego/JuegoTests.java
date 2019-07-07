package modelo.juego;

import modelo.estrategias.EstrategiaDesgaste;
import modelo.herramientas.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.mapa.Casillero;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.Patron;
import modelo.patrones.PatronHacha;
import modelo.patrones.PatronPico;
import modelo.patrones.PatronPicoFino;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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



    public void inicializarMapaTestConMateriales() {
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

    private void agregarHerramientaAinventarioHerramientas(ConstructorHerramientaAbstracto constructor,
                                                           Material material, int durabilidad, int fuerza, EstrategiaDesgaste desgaste){
        constructor.conMaterial(material).conDurabilidad(durabilidad)
                .conDesgaste(desgaste)
                .conFuerza(fuerza);
        inventarioHerramientasTest.put(constructor.construir(), new ArrayList<>());
    }

    private void inicializarInventarioHerramientaTest() {
        agregarHerramientaAinventarioHerramientas(new ConstructorHacha(), new Madera(),
                DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, DESGASTE_HACHA_MADERA);
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

    @Before
    public void setup() {
          mapaTest = new Mapa(12, 12);
          inventarioHerramientasTest = new HashMap<>();
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
    public void testSeInicializaJuegoConUnJugadorConUnHachaMadera(){
        Juego juego = new Juego();

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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(195));
    }
    //--------------------------------------------------------------------------------------------------------------

    @Test
    public void testJugadorDesgastaMaderaAlMoverseHaciaEllaConHachaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        jugador.setHerramientaActual(herramienta);
        Mapa tablero = juego.obtenerMapa();
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        Casillero casillero = tablero.obtenerCasillero(new Ubicacion(1,9));
        Madera madera = (Madera) casillero.obtenerUbicable();
        assertThat(madera.getDurabilidad(), CoreMatchers.is(0));

    }

    @Test
    public void testJugadorDesgastaHachaMetalAlDesgastarMadera(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        jugador.moverseALaDerecha(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(395));
    }

    @Test
    public void testJugadorNoDesgastaPiedraAlMoverseHaciaEllaConHachaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
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
    public void testJugadorDesgastaHachaMetalAlMoverseHaciaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        jugador.setHerramientaActual(herramienta);
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        jugador.moverseAbajo(juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(395));
    }

    @Test
    public void testJugadorNoDesgastaMetalAlMoverseHaciaElConHachaMetal(){
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarMapaConMateriales();
        juego.inicializarJugador();
        Jugador jugador = juego.obtenerJugador();
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
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
        Herramienta herramienta = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        jugador.setHerramientaActual(herramienta);
        moverseHastaDiamanteSegunMapaPlaneado(jugador, juego.obtenerMapa());
        assertThat(herramienta.getDurabilidad(), is(395));
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
}
