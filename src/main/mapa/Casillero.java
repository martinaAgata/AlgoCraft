package main.mapa;

public class Casillero {
    private EstadoCasillero estado;
    // se debe poder guardar un jugador o un material


    public Casillero() {
        this.estado = new EstadoLibre();
    }
}
