package modelo.juego;

import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;

public class ObjetoUbicable extends Ubicable {
    @Override
    public Ubicable guardarUbicable(Ubicable otroUbicable) {
        throw new NoSePuedeUbicarPorqueEstaOcupadoException("No se puede guardar en este casillero ya que se encuentra ocupado");
    }
    @Override
    public Ubicable eliminarUbicable() {
        return new NullUbicable();
    }
}
