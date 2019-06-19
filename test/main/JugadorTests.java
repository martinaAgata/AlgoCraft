package main;

import main.herramientas.*;
import main.materiales.Madera;
import org.junit.Test;

import static main.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JugadorTests {

    /*Es la entidad controlable por el usuario, el cual puede moverse
    por el mapa, y conseguir materiales que haya en su camino.
    Al iniciar la partida, el jugador inicia con un hacha de madera
    en el inventario.
    El jugador debe poder desplazarse en todas las direcciones y puede moverse
    por todos los casilleros vacíos (es decir, sin ningún material).
    */
    @Test
    public void test01JugadorSeInicializaConUnItemEnElInventario(){
        ConstructorHerramientaAbstracto constructor = new ConstructorHacha();
        constructor.conMaterial(new Madera()).conDesgaste(DESGASTE_HACHA_MADERA)
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Jugador jugador = new Jugador(constructor.construir());
        //Terminar
    }
    
    @Test
    public void test02JugadorSeInicializaConUnHachaDeMadera(){
        ConstructorHerramientaAbstracto constructor = new ConstructorHacha();
        constructor.conMaterial(new Madera()).conDesgaste(DESGASTE_HACHA_MADERA)
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA);
        Hacha hachaInicial = (Hacha) constructor.construir();
        Jugador jugador = new Jugador(hachaInicial);
        assertThat(jugador.obtenerHerramientaActual(), is(hachaInicial));
    }
}