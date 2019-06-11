package main.mapa;
import main.Ubicable;
import java.util.ArrayList;

public class Mapa {
     private ArrayList<ArrayList<Casillero>> casilleros;
     private final int filas;
     private final int columnas;
     private int y = 0;//No puede ser final ya que va a ser utilizada en una funcion que no es el constructor QUITAR
     private int x = 0;//No puede ser final ya que va a ser utilizada en una funcion que no es el constructor QUITAR

     public Mapa() {
         casilleros = new ArrayList<>();
         this.filas = 20;
         this.columnas = 20;
         this.inicializarMapa();
     }

     private void inicializarMapa() {
         for (int i=0; i<=this.filas; i++) {
             this.casilleros.add(i, new ArrayList<>());
             for (int j=0; j<=this.columnas; j++) {
                 //this.casilleros[i].push(new Casillero());
                 this.casilleros.get(i).add(j, new Casillero());
             }
         }
     }

    public void ubicarEnCasillero(Ubicable ubicable) {
        x = (int)(Math.random()*filas);
        y = (int)(Math.random()*columnas);
        //casilleros[x][y].guardarUbicable(ubicable);
        this.casilleros.get(x).get(y).guardarUbicable(ubicable);
    }



}
