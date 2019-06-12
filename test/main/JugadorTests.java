package main;

import main.herramientas.ConstructorHacha;
import main.herramientas.Hacha;
import main.herramientas.Herramienta;
import main.materiales.Madera;
import org.junit.Test;

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
        Jugador jugador = new Jugador();
        Herramienta herramienta = jugador.obtenerHerramientaActual();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
    }
    
    @Test
    public void test02JugadorSeInicializaConUnHachaDeMadera(){
        Jugador jugador = new Jugador();
        Madera madera = new Madera();
        Integer durabilidadMadera = madera.getDurabilidad();
    }
}