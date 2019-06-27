package modelo.mapa;

import modelo.juego.Juego;
import modelo.juego.Ubicable;

public class ObservadorUbicableImpl implements ObservadorUbicable {
    private Juego juego;
    private Mapa mapa;

    public ObservadorUbicableImpl(Juego juego) {
        this.juego = juego;
        this.mapa = juego.obtenerMapa();
    }

    public void ubicableMuerto(Ubicable ubicable) {
        this.mapa.eliminarDeCasillero(ubicable.getUbicacion());
        this.juego.actualizarInventarios(ubicable);
    }
}
