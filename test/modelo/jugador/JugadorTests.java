package modelo.jugador;

import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
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

    @Test (expected = NoExisteNingunCasilleroParaLaUbicacionDadaException.class)
    public void testJugadorNoPuedeMoverseHaciaArribaEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarJuego();
        Jugador jugador = juego.obtenerJugador();
        Ubicacion ubicacionAnterior = jugador.obtenerUbicacion();
        jugador.moverseArriba(juego.obtenerMapa());

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
    public void testJugadorDesgastaMaderaAlGolpearlaConHachaMadera(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(8));

    }

    @Test
    public void testJugadorNoSeDesgastaPiedraAlGolpearlaConHachaMadera(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(piedra.getDurabilidad(), is(30));

    }

    @Test
    public void testJugadorNoSeDesgastaMetalAlGolpearloConHachaMadera(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(metal.getDurabilidad(), is(50));

    }

    @Test
    public void testJugadorNoSeDesgastaDiamanteAlGolpearloConHachaMadera(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void testJugadorDesgastaMaderaAlGolpearlaConHachaPiedra(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(5));

    }

    @Test
    public void testJugadorNoSeDesgastaPiedraAlGolpearlaConHachaPiedra(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(piedra.getDurabilidad(), is(30));

    }

    @Test
    public void testJugadorNoSeDesgastaMetalAlGolpearloConHachaPiedra(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(metal.getDurabilidad(), is(50));

    }

    @Test
    public void testJugadorNoSeDesgastaDiamanteAlGolpearloConHachaPiedra(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(diamante.getDurabilidad(), is(100));
    }


    @Test (expected = MaterialSeHaGastadoException.class)
    public void testJugadorDesgastaMaderaAlGolpearlaConHachaMetal(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(0));
    }

    @Test
    public void testJugadorNoSeDesgastaPiedraAlGolpearlaConHachaMetal(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(piedra.getDurabilidad(), is(30));

    }

    @Test
    public void testJugadorNoSeDesgastaMetalAlGolpearloConHachaMetal(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(metal.getDurabilidad(), is(50));

    }

    @Test
    public void testJugadorNoSeDesgastaDiamanteAlGolpearloConHachaMetal(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void testJugadorNoSeDesgastaMaderaAlGolpearlaConPicoMadera(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(10));
    }

    @Test
    public void testJugadorDesgastaPiedraAlGolperlaConPicoMadera(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(piedra.getDurabilidad(), is(28));
    }

    @Test
    public void testJugadorNoSeDesgastaMetalAlGolpearloConPicoMadera(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(metal.getDurabilidad(), is(50));
    }

    @Test
    public void testJugadorNoSeDesgastaDiamanteAlGolpearloConPicoMadera(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void testJugadorNoSeDesgastaMaderaAlGolpearlaConPicoPiedra(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(10));
    }

    @Test
    public void testJugadorDesgastaPiedraAlGolpearlaConPicoPiedra(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(piedra.getDurabilidad(), is(26));
    }

    @Test
    public void testJugadorDesgastaMetalAlGolpearloConPicoPiedra(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(metal.getDurabilidad(), is(46));
    }

    @Test
    public void testJugadorNoSeDesgastaDiamanteAlGolpearloConPicoPiedra(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void testJugadorNoSeDesgastaMaderaAlGolpearlaConPicoMetal(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(10));
    }

    @Test
    public void testJugadorNoSeDesgastaPiedraAlGolpearloConPicoMetal(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(piedra.getDurabilidad(), is(18));
    }

    @Test
    public void testJugadorNoSeDesgastaMetalAlGolpearloConPicoMetal(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(metal.getDurabilidad(), is(50));
    }

    @Test
    public void testJugadorNoSeDesgastaDiamanteAlGolperaloConPicoMetal(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(diamante.getDurabilidad(), is(100));
    }

    @Test
    public void testJugadorNoSeDesgastaMaderaAlGolpearlaConPicoFino(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(madera.getDurabilidad(), is(10));
    }

    @Test
    public void testJugadorNoSeDesgastaPiedraAlGolpearlaConPicoFino(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(piedra.getDurabilidad(), is(30));
    }

    @Test
    public void testJugadorNoSeDesgastaMetalAlGolpearloConPicoFino(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(metal.getDurabilidad(), is(50));
    }

    @Test
    public void testJugadorDesgastaDiamanteAlGolpearloConPicoFino(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(diamante.getDurabilidad(), is(80));
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
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hachaMadera.getDurabilidad(), is(98));

    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlGolpearUnaPiedra(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hachaMadera.getDurabilidad(), is(98));

    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlGolpearUnMetal(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hachaMadera.getDurabilidad(), is(98));

    }

    @Test
    public void testJugadorDesgastaHachaMaderaAlGolpearUnDiamante(){
        Hacha hachaMadera = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hachaMadera, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlGolpearUnaMadera(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(195));

    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlGolpearUnaPiedra(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(195));

    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlGolpearUnMetal(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(195));

    }

    @Test
    public void testJugadorDesgastaHachaPiedraAlGolpearUnDiamante(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(195));
    }


    @Test (expected = MaterialSeHaGastadoException.class)
    public void testJugadorDesgastaHachaMetalAlGolpearUnaMadera(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(395));
    }

    @Test
    public void testJugadorDesgastaHachaMetalAlGolpearUnaPiedra(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(395));

    }

    @Test
    public void testJugadorDesgastaHachaMetalAlGolpearUnMetal(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(395));

    }

    @Test
    public void testJugadorDesgastaHachaMetalAlGolpearUnDiamante(){
        Hacha hacha = (Hacha) new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();;
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(hacha, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(hacha.getDurabilidad(), is(395));
    }

    @Test
    public void testJugadorDesgastaPicoMaderaAlGolpearUnaMadera(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorDesgastaPicoMaderaAlGolpearUnaPiedra(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorDesgastaPicoMaderaAlGolpearUnMetal(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorDesgastaPicoMaderaAlGolpearUnDiamante(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(98));
    }

    @Test
    public void testJugadorDesgastaPicoPiedraAlGolpearUnaMadera(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(198));
    }

    @Test
    public void testJugadorDesgastaPicoPiedraAlGolpearUnaPiedra(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(198));
    }

    @Test
    public void testJugadorDesgastaPicoPiedraAlGolpearUnMetal(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(198));
    }

    @Test
    public void testJugadorDesgastaPicoPiedraAlGolpearUnDiamante(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(198));
    }

    @Test
    public void testJugadorDesgastaPicoMetalAlGolpearUnaMadera(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(400));
    }

    @Test
    public void testJugadorDesgastaPicoMetalAlGolpearUnaPiedra(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(400));
    }

    @Test
    public void testJugadorDesgastaPicoMetalAlGolpearUnMetal(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(400));
    }

    @Test
    public void testJugadorDesgastaPicoMetalAlGolpearUnDiamante(){
        Pico pico = (Pico) new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(400));
    }

    @Test
    public void testJugadorDesgastaPicoFinoAlGolpearUnaMadera(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Madera madera = new Madera();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(madera, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(998));
    }

    @Test
    public void testJugadorDesgastaPicoFinoAlGolpearUnaPiedra(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Piedra piedra = new Piedra();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(piedra, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(998));
    }

    @Test
    public void testJugadorDesgastaPicoFinoAlGolpearUnMetal(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Metal metal = new Metal();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(metal, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(998));
    }

    @Test
    public void testJugadorDesgastaPicoFinoAlGolpearUnDiamante(){
        PicoFino pico = (PicoFino) new ConstructorPicoFino()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir();
        Diamante diamante = new Diamante();
        Mapa tableroJuego = new Mapa(2,2);
        tableroJuego.ubicarEnCasillero(diamante, new Ubicacion(1,2));
        HashMap<Material, Integer> inventarioMaterialesJugador  = new HashMap<>();
        Ubicacion ubicacionJugador = new Ubicacion(1,1);
        Jugador jugador = new Jugador(pico, inventarioMaterialesJugador, ubicacionJugador);
        jugador.moverseALaDerecha(tableroJuego);
        assertThat(pico.getDurabilidad(), is(998));
    }
}