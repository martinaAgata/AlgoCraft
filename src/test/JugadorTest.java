package test;

import org.junit.Test;

public class JugadorTest {

    /*Es la entidad controlable por el usuario, el cual puede moverse
    por el mapa, y conseguir materiales que haya en su camino.
    Al iniciar la partida, el jugador inicia con un hacha de madera
    en el inventario.
    El jugador debe poder desplazarse en todas las direcciones y puede moverse
    por todos los casilleros vacíos (es decir, sin ningún material).
    */
    @Test
    public void test01JugadorSeInicializaConUnItemEnElInventario(){
        Jugador jugador = Jugador nuevoJugadorConHachaMadera();
        assertEquals(jugador.getInventario().length(), 1);
    }
    @Test
    public void test02JugadorSeInicializaConUnHachaDeMadera(){
        Jugador jugador = Jugador nuevoJugadorConHachaMadera();
        Madera madera = new Madera();
        Integer durabilidadMadera = madera.getDurabilidad();
        jugador.desagastarMaterial(madera);
        assertEquals(madera.getDurabilidad() ,durabilidadMadera - 2);
    }
}