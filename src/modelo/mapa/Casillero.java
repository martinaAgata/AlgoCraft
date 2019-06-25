package modelo.mapa;

import modelo.juego.NullUbicable;
import modelo.juego.Ubicable;

public class Casillero {

    private Ubicable ubicable = new NullUbicable();

    public Ubicable obtenerUbicable() {
        return this.ubicable;
    }

    public void guardarUbicable(Ubicable ubicable) {
        this.ubicable = this.ubicable.guardarUbicable(ubicable);
    }

    public Ubicable eliminarUbicable() {
        Ubicable eliminado = this.ubicable;
        this.ubicable = this.ubicable.eliminarUbicable();
        return eliminado;
    }

    public boolean esIgualA(Casillero c) {
        if (this == c) return true;
        if (this.ubicable == null && c.ubicable ==  null)
            return true;
        if (this.ubicable == null || c.ubicable == null)
            return false;
        return this.ubicable.esIgualAUbicable(c.ubicable);
    }
}