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
         for (int i=0; i<=this.filas; i++) {
             for (int j=0; j<=this.columnas; j++) {
                 this.casilleros.put(new Ubicacion(i, j), new Casillero());
             }
         }
     }

    public void ubicarEnCasilleroAleatorio(Ubicable ubicable) {
        int x = (int)(Math.random()*filas);
        int y = (int)(Math.random()*columnas);
        this.casilleros.get(new Ubicacion(x, y)).guardarUbicable(ubicable);
        // este get() devuelve una instancia de Casillero (esa guarda el Ubicable)
    }
    public void ubicarEnCasillero(Ubicable ubicable, Ubicacion ubicacion) {
        this.casilleros.get(ubicacion).guardarUbicable(ubicable);
        // este get() devuelve una instancia de Casillero (esa guarda el Ubicable)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapa mapa = (Mapa) o;
        return filas == mapa.filas &&
                columnas == mapa.columnas &&
                Objects.equals(casilleros, mapa.casilleros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(casilleros, filas, columnas);
    }
}
