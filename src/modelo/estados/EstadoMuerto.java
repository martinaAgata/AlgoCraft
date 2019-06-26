package modelo.estados;

import modelo.exceptions.NoSePuedeDesgastarUnElementoConEstadoMuertoException;

public class EstadoMuerto implements Estado {

    public Estado desgastar(int fuerza) {
        throw new NoSePuedeDesgastarUnElementoConEstadoMuertoException("No puede desgastarse un elemento con estado muerto");
    }

    public int getDurabilidad() { return 0; }
}
