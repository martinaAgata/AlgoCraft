package modelo.juego;

public abstract class Ubicable {

    public Ubicable guardarUbicable(Ubicable otroUbicable) { return otroUbicable; }

    public Ubicable eliminarUbicable() { return new NullUbicable(); }

    public boolean esIgualAUbicable(Ubicable ubicable) {
        if(this.getClass() == ubicable.getClass()) return true;
        return false;
    }
}
