package main.mapa;
import java.util.ArrayList;

public class Mapa {
     private ArrayList<ArrayList> casilleros;
     private final int filas;
     private final int columnas;

     private Mapa() {
         casilleros = new ArrayList<ArrayList>();
         this.filas = 20;
         this.columnas = 20;
         this.inicializarMapa();
     }

     private void inicializarMapa() {
         for (int i=0; i<=this.filas; i++) {
             for (int j=0; j<=this.columnas; j++) {
                 this.filas[i] = new ArrayList<Casillero>();
                 this.filas[i].push(new Casillero);
             }
         }
     }
}
