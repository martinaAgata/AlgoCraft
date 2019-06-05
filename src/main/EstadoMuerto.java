package main;

public class EstadoMuerto implements Estado {


    public boolean sePuedeUsar() {
        return false;
    }

    public Estado desgastar(int fuerza) {
        throw new IllegalStateException("No puede desgastarse una herramienta rota"); // Chequear
    }
    public int getDurabilidad() {
        return 0; // Ver si devolver una excepcion
    }
}
