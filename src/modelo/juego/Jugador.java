package modelo.juego;
import modelo.herramientas.Herramienta;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;

public class Jugador implements Ubicable {

    private Herramienta herramientaActual;
    private Ubicacion ubicacion;

    public Jugador(Herramienta herramientaInicial) {
        /*ConstructorHacha constructor = new ConstructorHacha();
        Herramienta hachaMadera = constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();*/

        this.herramientaActual = herramientaInicial;
    }



    public void setUbicacion(Ubicacion u) { this.ubicacion = u; }

    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }

    public void moverseALaDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionDerecha();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseALaIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionIzquierda();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseArriba(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionArriba();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseAbajo(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionAbajo();
        mapa.ubicarEnCasillero(this, ubicacion);
    }

    @Override
    public boolean esIgualAUbicable(Ubicable ubicable) {
        if(this.getClass() != ubicable.getClass()) return false;
        Jugador unJugador = (Jugador) ubicable;
        if(this.herramientaActual != unJugador.obtenerHerramientaActual()) return false;
        return true;
    }
}