package main.mapa;
import java.util.ArrayList;

public class Mapa {
     private ArrayList<ArrayList<Casillero>> casilleros;
     private final int filas;
     private final int columnas;

     private Mapa() {
         casilleros = new ArrayList<>();
         this.filas = 20;
         this.columnas = 20;
         this.inicializarMapa();
     }

     private void inicializarMapa() {
         for (int i=0; i<=this.filas; i++) {
             casilleros[i] = new ArrayList<>();
             for (int j=0; j<=this.columnas; j++) {
                 casilleros[i].push(new Casillero);
             }
         }
     }
}
