package modelo.estados;

public class EstadoVivo implements Estado {

    private int durabilidad;
    private Runnable ejecutarAlMorir = () -> {};

    public EstadoVivo (int durabilidad) {
        this.durabilidad = durabilidad;
    }

    public EstadoVivo(int durabilidad, Runnable ejecutarAlMorir) {
        this(durabilidad);
        this.ejecutarAlMorir = ejecutarAlMorir;
    }

    public Estado desgastar(int fuerza) {
        this.durabilidad -= fuerza;
        if(this.durabilidad <= 0) {
            ejecutarAlMorir.run();
            return new EstadoMuerto();
        }
        return this;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }
}
