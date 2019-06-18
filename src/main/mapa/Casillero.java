package main.mapa;
import main.exceptions.CasilleroVacioException;
import main.Ubicable;
import main.exceptions.CasilleroEstaOcupadoException;

public class Casillero {

    private Ubicable ubicable = null;

    public void guardarUbicable(Ubicable ubicable) {
        if (this.ubicable != null) { throw new CasilleroEstaOcupadoException("No es posible guardar, el casillero se encuentra ocupado"); }
        this.ubicable = ubicable;
    }

    public Ubicable eliminarUbicable() {
        if (this.ubicable == null) { throw new CasilleroVacioException("No se puede eliminar nada de un casillero vacio"); }
        Ubicable eliminado = this.ubicable;
        this.ubicable = null;
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