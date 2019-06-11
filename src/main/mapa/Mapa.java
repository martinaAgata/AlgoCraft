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
         for (int i=0; i<=this.filas; i++) { // ver si inicializar de 0 o 1
             for (int j=0; j<=this.columnas; j++) {
                 casilleros[i] = new ArrayList<Casillero>();
                 casilleros[i].push(new Casillero);
             }
         }
     }



}
