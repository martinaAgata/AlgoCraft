package modelo.estados;

import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;

public class EstadoMuerto implements Estado {

    public Estado desgastar(int fuerza) {
        throw new HerramientaRotaNoPuedeDesgastarseException("No puede desgastarse una herramienta rota");
    }

    public int getDurabilidad() {
        return 0; // Ver si devolver una excepcion
    }
}