package main.mapa;
import main.Ubicable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Mapa {
     private Map<Ubicacion, Casillero> casilleros = new HashMap<>();
     private final int filas;
     private final int columnas;

     public Mapa(int cantidadFilas, int cantidadColumnas) {
         this.filas = cantidadFilas;
         this.columnas = cantidadColumnas;
         this.inicializarMapa();
     }

     private void inicializarMapa() {
         for (int i=1; i<=this.filas; i++) {
             for (int j=1; j<=this.columnas; j++) {
                 this.casilleros.put(new Ubicacion(i, j), new Casillero());
             }
         }
     }

    public void ubicarEnCasilleroAleatorio(Ubicable ubicable) {
        int x = (int)(Math.random()*filas + 1);
        int y = (int)(Math.random()*columnas + 1);
        this.casilleros.get(new Ubicacion(x, y)).guardarUbicable(ubicable);
        // este get() devuelve una instancia de Casillero (esa guarda el Ubicable)
    }
    public void ubicarEnCasillero(Ubicable ubicable, Ubicacion ubicacion) {
        this.casilleros.get(ubicacion).guardarUbicable(ubicable);
        // este get() devuelve una instancia de Casillero (esa guarda el Ubicable)
    }

    public void eliminarDeCasillero(Ubicacion ubicacion) {
        this.casilleros.get(ubicacion).eliminarUbicable();
        // este get() devuelve una instancia de Casillero (esa guarda el Ubicable)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapa mapa = (Mapa) o;
        if (!(filas == mapa.filas && columnas == mapa.columnas)) return false;
        for (Ubicacion ubicacion : casilleros.keySet()) {
            if (!casilleros.get(ubicacion).equals(mapa.casilleros.get(ubicacion)))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(casilleros, filas, columnas);
    }
}
