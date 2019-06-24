package modelo.mapa;
import modelo.juego.Ubicable;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
     private Map<Ubicacion, Casillero> casilleros = new HashMap<>();
     private final int cantidadFilas;
     private final int cantidadColumnas;

     public Mapa(int cantidadFilas, int cantidadColumnas) {
         this.cantidadFilas = cantidadFilas;
         this.cantidadColumnas = cantidadColumnas;
         this.inicializarMapa();
     }

     private void inicializarMapa() {
         for (int i=1; i<=this.cantidadFilas; i++) {
             for (int j=1; j<=this.cantidadColumnas; j++) {
                 this.casilleros.put(new Ubicacion(i, j), new Casillero());
             }
         }
     }
/*
    public void ubicarEnCasilleroAleatorio(Ubicable ubicable) {
        int x = (int)(Math.random()*cantidadFilas + 1);
        int y = (int)(Math.random()*cantidadColumnas + 1);
        this.casilleros.get(new Ubicacion(x, y)).guardarUbicable(ubicable);
    }
*/

    public void ubicarEnCasillero(Ubicable ubicable, Ubicacion ubicacion) {
        this.casilleros.get(ubicacion).guardarUbicable(ubicable);
        // este get() devuelve una instancia de Casillero (esa guarda el Ubicable)
    }



    public Casillero obtenerCasillero(Ubicacion ubicacion) {
        return this.casilleros.get(ubicacion);
     }

    public Ubicable eliminarDeCasillero(Ubicacion ubicacion) {
        return (this.casilleros.get(ubicacion).eliminarUbicable());
    }

    public boolean esIgualA(Mapa mapa) {
        if (this == mapa) return true;
        if (mapa == null || getClass() != mapa.getClass()) return false;
        if (!(cantidadFilas == mapa.cantidadFilas && cantidadColumnas == mapa.cantidadColumnas)) return false;
        for (Ubicacion ubicacion : casilleros.keySet()) {
            if (!casilleros.get(ubicacion).esIgualA(mapa.casilleros.get(ubicacion))) return false;
        }
        return true;
    }

    public int obtenerCantidadFilas() {
         return cantidadFilas;
    }

    public int obtenerCantidadColumnas() {
         return cantidadColumnas;
    }
}
