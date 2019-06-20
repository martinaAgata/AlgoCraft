package modelo;

import modelo.exceptions.CasilleroEstaOcupadoException;
import modelo.herramientas.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JugadorTests {

    /*Es la entidad controlable por el usuario, el cual puede moverse
    por el mapa, y conseguir materiales que haya en su mapa.
    Al iniciar la partida, el jugador inicia con un hacha de madera
    en el inventario.
    El jugador debe poder desplazarse en todas las direcciones y puede moverse
    por todos los casilleros vacíos (es decir, sin ningún material).
    */
    @Test
    public void test01JugadorSeInicializaConUnItemEnElInventario() {
        ConstructorHerramientaAbstracto constructor = new ConstructorHacha();
        constructor.conMaterial(new Madera()).conDesgaste(DESGASTE_HACHA_MADERA)
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Jugador jugador = new Jugador(constructor.construir());
        //Terminar
    }

    @Test
    public void test02JugadorSeInicializaConUnHachaDeMadera() {
        ConstructorHerramientaAbstracto constructor = new ConstructorHacha();
        constructor.conMaterial(new Madera()).conDesgaste(DESGASTE_HACHA_MADERA)
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaInicial = (Hacha) constructor.construir();
        Jugador jugador = new Jugador(hachaInicial);
        assertThat(jugador.obtenerHerramientaActual(), is(hachaInicial));
    }
    @Test
    public void test04JugadorPuedeMoverseEnMapaNuevoHaciaArribaLuegoAbajo(){
        Mapa mapa = new Mapa(10,10);
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Jugador jugador = new Jugador(hachaInicial);
        Ubicacion ubicacionJugador = new Ubicacion(3,3);
        jugador.setUbicacion(ubicacionJugador);
        mapa.ubicarEnCasillero(jugador,ubicacionJugador);
        jugador.moverseArriba(mapa);
        jugador.moverseAbajo(mapa);
    }

    /*el jugador se inicializa en la posicion (1,6)*/

    @Test
    public void test03JugadorPuedeMoverseHaciaLaDerechaEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarJugador();
        juego.inicializarMapaConMateriales();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseALaDerecha(juego.obtenerMapa());
    }

    @Test
    public void test03JugadorPuedeMoverseHaciaArribaEnJuegoInicializado() {
        Juego juego = new Juego();
        juego.inicializarJugador();
        juego.inicializarMapaConMateriales();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseArriba(juego.obtenerMapa());
    }

    @Test //(expected = CasilleroEstaOcupadoException.class)
    public void test03JugadorMoverseHaciaAbajoEnJuegoInicializadoLanzaException() {
        Juego juego = new Juego();
        juego.inicializarJugador();
        juego.inicializarMapaConMateriales();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseAbajo(juego.obtenerMapa());
    }

 /*    @Test (expected = Exception.class)
     void test03JugadorNoPuedeMoverseHaciaLaIzquierdaEnJuegoInicializado() { //limite izquierdo del mapa
        Juego juego = new Juego();
        juego.inicializarJugador();
        juego.inicializarMapaConMateriales();
        Jugador jugador = juego.obtenerJugador();
        jugador.moverseALaIzquierda(juego.obtenerMapa());
    }*/



}