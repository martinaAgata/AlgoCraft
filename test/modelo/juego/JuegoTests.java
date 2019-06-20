package modelo.juego;

import modelo.estrategias.EstrategiaDesgaste;
import modelo.herramientas.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static modelo.juego.ConstantesJuego.*;


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
          mapaTest = new Mapa(10, 10);
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
        Juego juego = new Juego();
        juego.inicializarInventarioHerramienta();
        juego.inicializarJugador();
        Mapa mapaJuego = juego.obtenerMapa();
        assertTrue(mapaJuego.esIgualA(mapaTest));

    }

   /* @Test
    public void testSeDetectaHerramientaDelTableroCrafteo(){
        Juego juego = new Juego();
        juego.inicializarPatrones();

    }

    @Test
    public void testSeUbicaCorrectamenteMaterialEnTableroCrafteo(){
        Juego juego = new Juego();
    }
*/

}
