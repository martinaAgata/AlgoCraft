package modelo.jugador;

import modelo.herramientas.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import org.junit.Test;
import java.util.HashMap;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertFalse;
import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class JugadorTests {

    @Test
    public void testJugadorSeInicializaConUnItemEnElInventario() {
        ConstructorHerramientaAbstracto constructor = new ConstructorHacha();
        constructor.conMaterial(new Madera()).conDesgaste(DESGASTE_HACHA_MADERA)
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Jugador jugador = new Jugador(constructor.construir(), null,null);
    }

    @Test
    public void testJugadorSeInicializaConUnHachaDeMadera() {
        ConstructorHerramientaAbstracto constructor = new ConstructorHacha();
        constructor.conMaterial(new Madera()).conDesgaste(DESGASTE_HACHA_MADERA)
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaInicial = (Hacha) constructor.construir();
        Jugador jugador = new Jugador(hachaInicial, null,null);
        assertThat(jugador.obtenerHerramientaActual(), is(hachaInicial));
    }
    @Test
    public void testJugadorPuedeMoverseEnMapaNuevoHaciaArribaLuegoAbajo(){
        Mapa mapa = new Mapa(10,10);
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Jugador jugador = new Jugador(hachaInicial, null,null);
        Ubicacion ubicacionJugador = new Ubicacion(3,3);
        jugador.setUbicacion(ubicacionJugador);
        mapa.ubicarEnCasillero(jugador,ubicacionJugador);
        jugador.moverseArriba(mapa);
        jugador.moverseAbajo(mapa);
    }

    /*el jugador se inicializa en la posicion (1,6)*/

    @Test
    public void testJugadorPuedeMoverseHaciaLaDerechaEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarJuego();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseALaDerecha(juego.obtenerMapa());
    }

    @Test
    public void testJugadorNoPuedeMoverseHaciaArribaEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarJuego();
        Jugador jugador = juego.obtenerJugador();
        Ubicacion ubicacionAnterior = jugador.obtenerUbicacion();
        jugador.moverseArriba(juego.obtenerMapa());
        assertThat(jugador.obtenerUbicacion(), is(ubicacionAnterior));

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
        assertThat(jugador.obtenerUbicacion(), is(ubicacion3));
    }

    @Test
    public void testJugadorSeMueveArribaYEstaEnLaPosicionEsperada(){
        Mapa mapa = new Mapa(10,10);
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Jugador jugador = new Jugador(hachaInicial, null,null);
        Ubicacion ubicacionInicialJugador = new Ubicacion(3,3);
        jugador.setUbicacion(ubicacionInicialJugador);
        mapa.ubicarEnCasillero(jugador,ubicacionInicialJugador);
        jugador.moverseArriba(mapa);
        Ubicacion ubicacionEsperada = ubicacionInicialJugador.getUbicacionArriba();
        assertTrue(ubicacionEsperada.equals(jugador.obtenerUbicacion()));

    }

    @Test
    public void testJugadorSeMuevAbajoYEstaEnLaPosicionEsperada(){
        Mapa mapa = new Mapa(10,10);
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Jugador jugador = new Jugador(hachaInicial, null,null);
        Ubicacion ubicacionInicialJugador = new Ubicacion(3,3);
        jugador.setUbicacion(ubicacionInicialJugador);
        mapa.ubicarEnCasillero(jugador,ubicacionInicialJugador);
        jugador.moverseAbajo(mapa);
        Ubicacion ubicacionEsperada = ubicacionInicialJugador.getUbicacionAbajo();
        assertTrue(ubicacionEsperada.equals(jugador.obtenerUbicacion()));

    }

    @Test
    public void testJugadorSeMueveDerechaYEstaEnLaPosicionEsperada(){
        Mapa mapa = new Mapa(10,10);
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Jugador jugador = new Jugador(hachaInicial, null,null);
        Ubicacion ubicacionInicialJugador = new Ubicacion(3,3);
        jugador.setUbicacion(ubicacionInicialJugador);
        mapa.ubicarEnCasillero(jugador,ubicacionInicialJugador);
        jugador.moverseALaDerecha(mapa);
        Ubicacion ubicacionEsperada = ubicacionInicialJugador.getUbicacionDerecha();
        assertTrue(ubicacionEsperada.equals(jugador.obtenerUbicacion()));

    }

    @Test
    public void testJugadorSeMueveIzquierdaYEstaEnLaPosicionEsperada(){
        Mapa mapa = new Mapa(10,10);
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Ubicacion ubicacionInicialJugador = new Ubicacion(3,3);
        Jugador jugador = new Jugador(hachaInicial, null,ubicacionInicialJugador);
        mapa.ubicarEnCasillero(jugador,ubicacionInicialJugador);
        jugador.moverseALaIzquierda(mapa);
        Ubicacion ubicacionEsperada = ubicacionInicialJugador.getUbicacionIzquierda();
        assertTrue(ubicacionEsperada.equals(jugador.obtenerUbicacion()));
    }

    @Test
    public void testJugadorSeteaHachaPiedraCorrectamente(){
        Hacha hacha = new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra());
        Jugador jugador = new Jugador(null, null, null);
        assertNotSame(jugador.obtenerHerramientaActual(), hacha);
        jugador.setHerramientaActual(hacha);
        assertThat(hacha, is(jugador.obtenerHerramientaActual()));
    }

    @Test
    public void testJugadorSeteaHachaMetalCorrectamente(){
        Hacha hacha = new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal());
        Jugador jugador = new Jugador(null, null, null);
        assertNotSame(jugador.obtenerHerramientaActual(), hacha);
        jugador.setHerramientaActual(hacha);
        assertThat(hacha, is(jugador.obtenerHerramientaActual()));
    }

    @Test
    public void testJugadorSeteaHachaMaderaCorrectamente(){
        Hacha hacha = new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera());
        Jugador jugador = new Jugador(null, null, null);
        assertNotSame(jugador.obtenerHerramientaActual(), hacha);
        jugador.setHerramientaActual(hacha);
        assertThat(hacha, is(jugador.obtenerHerramientaActual()));
    }

    @Test
    public void testJugadorSeteaPicoMaderaCorrectamente(){
        Pico pico = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        Jugador jugador = new Jugador(null, null, null);
        assertNotSame(jugador.obtenerHerramientaActual(), pico);
        jugador.setHerramientaActual(pico);
        assertThat(pico, is(jugador.obtenerHerramientaActual()));
    }

    @Test
    public void testJugadorSeteaPicoPiedraCorrectamente(){
        Pico pico = new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Piedra());
        Jugador jugador = new Jugador(null, null, null);
        assertNotSame(jugador.obtenerHerramientaActual(), pico);
        jugador.setHerramientaActual(pico);
        assertThat(pico, is(jugador.obtenerHerramientaActual()));
    }

    @Test
    public void testJugadorSeteaPicoMetalCorrectamente(){
        Pico pico = new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        Jugador jugador = new Jugador(null, null, null);
        assertNotSame(jugador.obtenerHerramientaActual(), pico);
        jugador.setHerramientaActual(pico);
        assertThat(pico, is(jugador.obtenerHerramientaActual()));
    }

    @Test
    public void testJugadorSeteaPicoFinoCorrectamente(){
        PicoFino pico = new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        Jugador jugador = new Jugador(null, null, null);
        assertNotSame(jugador.obtenerHerramientaActual(), pico);
        jugador.setHerramientaActual(pico);
        assertThat(pico, is(jugador.obtenerHerramientaActual()));
    }

    @Test
    public void testJugadorDesgasteMaterialAlMovecerseHaciaEl(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(8));
    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlGolpearUnaMadera(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hachaMadera.getDurabilidad(), is(98));

    }
}