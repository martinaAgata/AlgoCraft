package main;

import main.exceptions.HerramientaRotaError;

public class EstadoMuerto implements Estado {

    public Estado desgastar(int fuerza) {
        throw new HerramientaRotaError("No puede desgastarse una herramienta rota");
    }

    public int getDurabilidad() {
        return 0; // Ver si devolver una excepcion
    }
}
