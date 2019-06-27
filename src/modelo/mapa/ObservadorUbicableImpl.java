package modelo.mapa;

import modelo.juego.Ubicable;

public class ObservadorUbicableImpl implements ObservadorUbicable {
    private Mapa mapa;

    public ObservadorUbicableImpl(Mapa mapa) {
        this.mapa = mapa;
    }

    public void ubicableMuerto(Ubicable ubicable) {
        mapa.eliminarDeCasillero(ubicable.getUbicacion());
    }
}
