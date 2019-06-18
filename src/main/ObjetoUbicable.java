package main;

public class ObjetoUbicable implements Ubicable {
    @Override
    public boolean esIgualAUbicable(Ubicable ubicable) {
        if(this.getClass() == ubicable.getClass()) return true;
        return false;
    }
}
