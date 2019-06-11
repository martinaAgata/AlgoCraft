package main.mapa;
import main.Jugador;
import main.Ubicable;
import main.materiales.Material;

import java.util.ArrayList;
import java.util.Random;

public class Mapa {
     private ArrayList<ArrayList<Casillero>> casilleros;
     private final int filas;
     private final int columnas;
     private final int x; // veremos estos nombres xd
     private final int y;

     private Mapa() {
         casilleros = new ArrayList<>();
         this.filas = 20;
         this.columnas = 20;
         this.inicializarMapa();
     }

     private void inicializarMapa() {
         for (int i=0; i<=this.filas; i++) {
             this.casilleros[i] = new ArrayList<>();
             for (int j=0; j<=this.columnas; j++) {
                 this.casilleros[i].push(new Casillero);
             }
         }
     }

    private void ubicarEnCasillero(Ubicable ubicable) {
        x = (int)(Math.random()*filas);
        y = (int)(Math.random()*columnas);
        casilleros[x][y].guardarUbicable(ubicable);
    }



}
