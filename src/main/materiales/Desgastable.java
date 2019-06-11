package main.materiales;

import main.herramientas.*;

public interface Desgastable {

    public abstract Desgastable desgastarContra(Desgastable desgastable);
    public abstract Desgastable desgastarContra(Pico pico);
    public abstract Desgastable desgastarContra(Hacha pico);
    public abstract Desgastable desgastarContra(PicoFino pico);
    public abstract Desgastable desgastarContra(Madera madera);
    public abstract Desgastable desgastarContra(Piedra piedra);
    public abstract Desgastable desgastarContra(Metal metal);
    public abstract Desgastable desgastarContra(Diamante diamante);
}
