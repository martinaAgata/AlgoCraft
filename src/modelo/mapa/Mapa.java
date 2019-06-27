package modelo.mapa;

import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.juego.Ubicable;
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

    public Casillero obtenerCasillero(Ubicacion ubicacion) {
        if (!this.casilleros.containsKey(ubicacion))
            throw new NoExisteNingunCasilleroParaLaUbicacionDadaException("No existe un casillero en esa ubicacion");
        return this.casilleros.get(ubicacion);
    }

    public void ubicarEnCasillero(Ubicable ubicable, Ubicacion ubicacion) {
         this.obtenerCasillero(ubicacion).guardarUbicable(ubicable);
    }

    public Ubicable eliminarDeCasillero(Ubicacion ubicacion) {
        return (this.obtenerCasillero(ubicacion).eliminarUbicable());
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
