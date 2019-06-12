package main.mapa;

import java.util.Objects;

public class Ubicacion {
    private final int x, y;

    public Ubicacion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return x == ubicacion.x &&
                y == ubicacion.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public derecha() {
        return new Ubicacion(this.x+1, this.y);
    }
    public izquierda() {
        return new Ubicacion(this.x-1, this.y);
    }
    public arriba() {
        return new Ubicacion(this.x, this.y+1);
    }
    public abajo() {
        return new Ubicacion(this.x, this.y-1);
    }
    public arribaDerecha() {
    }
    public arribaIzquierda() {
    }
    public abajoDerecha() {
    }
    public abajoIzquierda() {
    }
}
