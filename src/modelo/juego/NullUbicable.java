package modelo.juego;

import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;

public class NullUbicable extends Ubicable {
    @Override
    public Ubicable guardarUbicable(Ubicable otroUbicable) {
        return otroUbicable;
    }
    @Override
    public Ubicable eliminarUbicable() {
        throw new NoSePuedeEliminarPorqueEstaVacioException("El casillero se encuentra vacío");
    }
}
