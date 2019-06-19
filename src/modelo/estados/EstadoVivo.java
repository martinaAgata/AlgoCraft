package modelo.estados;

public class EstadoVivo implements Estado {

    private int durabilidad;

    public EstadoVivo (int durabilidad) {
        this.durabilidad = durabilidad;
    }

    public Estado desgastar(int fuerza) {
        this.durabilidad -= fuerza;
        if(this.durabilidad <= 0) return new EstadoMuerto();
        return this;
    }
    public int getDurabilidad() {
        return this.durabilidad;
    }
}
