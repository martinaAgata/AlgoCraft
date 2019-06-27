package modelo.juego;

import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;
import modelo.mapa.Ubicacion;

public class ObjetoUbicable extends Ubicable {

    public ObjetoUbicable(Ubicacion ubicacion) {
        super(ubicacion);
    }

    @Override
    public Ubicable guardarUbicable(Ubicable otroUbicable) {
        throw new NoSePuedeUbicarPorqueEstaOcupadoException("No se puede guardar en este casillero ya que se encuentra ocupado");
    }
    @Override
    public Ubicable eliminarUbicable() {
        return new NullUbicable(getUbicacion());
    }
}
