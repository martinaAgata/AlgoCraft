package modelo.juego;

import modelo.estrategias.EstrategiaDesgaste;
import modelo.herramientas.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.Patron;
import modelo.patrones.PatronHacha;
import modelo.patrones.PatronPico;
import modelo.patrones.PatronPicoFino;
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
    Jugador jugadorTest = new Jugador(hachaMaderaTest);
    private HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientasTest;



    public void inicializarMapaTestConMateriales() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                mapaTest.ubicarEnCasillero(new Madera(),new Ubicacion(i, j));
            }
        }
        for (int i = 4; i <= 7; i++) {
            for (int j = 4; j <= 7; j++) {
                mapaTest.ubicarEnCasillero(new Piedra(),new Ubicacion(i, j));
            }
        }

        for (int i = 8; i <= 9; i++) {
            for (int j = 8; j <= 9; j++) {
                mapaTest.ubicarEnCasillero(new Metal(),new Ubicacion(i, j));
            }
        }

        for (int i = 10; i <= 10; i++) {
            for (int j = 10; j <= 10; j++) {
                mapaTest.ubicarEnCasillero(new Diamante(),new Ubicacion(i, j));
            }
        }
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
            jugadorTest = new Jugador(hachaInicial);
            inventarioHerramientasTest.get(hachaInicial).add(hachaInicial);
        }

    @Before
    public void setup() {
          mapaTest = new Mapa(14, 14);
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


}
