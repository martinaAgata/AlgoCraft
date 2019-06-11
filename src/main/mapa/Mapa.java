package main.mapa;
import main.Ubicable;
import java.util.ArrayList;

public class Mapa {
     private ArrayList<ArrayList<Casillero>> casilleros;
     private final int filas;
     private final int columnas;
     private final int x;
     private final int y;

     public Mapa() {
         casilleros = new ArrayList<>();
         this.filas = 20;
         this.columnas = 20;
         this.inicializarMapa();
     }

     public void inicializarMapa() {
         for (int i=0; i<=this.filas; i++) {
             this.casilleros[i] = new ArrayList<>();
             for (int j=0; j<=this.columnas; j++) {
                 this.casilleros[i].push(new Casillero);
             }
         }
     }

    public void ubicarEnCasillero(Ubicable ubicable) {
        x = (int)(Math.random()*filas);
        y = (int)(Math.random()*columnas);
        casilleros[x][y].guardarUbicable(ubicable);
    }



}
