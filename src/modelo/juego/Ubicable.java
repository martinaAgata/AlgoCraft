package modelo.juego;

import modelo.mapa.Ubicacion;

public abstract class Ubicable {

    protected Ubicacion ubicacion;

    public Ubicable(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicable guardarUbicable(Ubicable otroUbicable) { return otroUbicable; }

    public Ubicable eliminarUbicable() { return new NullUbicable(getUbicacion()); }

    public boolean esIgualAUbicable(Ubicable ubicable) {
        if(this.getClass() == ubicable.getClass()) return true;
        return false;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
