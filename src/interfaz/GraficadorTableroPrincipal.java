package interfaz;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Material;

import java.util.HashMap;

public class GraficadorTableroPrincipal {
    private final Juego juego;
    private static final int TAM_BOTON = 30;

    public GraficadorTableroPrincipal(Juego juego) {
        this.juego = juego;
        // ver si guardar el jugador, u obtenerlo del juego, algo asi
        // ver si guardar mapa de algun modo
    }

    public void graficarMapa(Contenedor contenedor) {
        Mapa mapa = this.juego.obtenerMapa();
        int filas = mapa.obtenerCantidadFilas();
        int columnas = mapa.obtenerCantidadColumnas();

        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                Material material = (Material)mapa.obtenerCasillero(new Ubicacion(x, y)).obtenerUbicable();
                Rectangle r = new Rectangle();
                // DIBUJAR Y COLOCAR UBICABLE
                dibujarMaterial(r, material);
            }
        }
    }

    public void dibujarMaterial(Rectangle rectangle, Material material) {
        if (material == null) Image pasto = new Image(); // aca va una imagen que represente celda vacia
        HashMap<Material, String> imgSources = new HashMap();
        imgSources.put(,);

        }
    }
}
