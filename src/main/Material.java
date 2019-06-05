package main;

public abstract class Material implements Desgastable {

    private Estado estado;


    private int durabilidad;
    // hay que poder sacarlo de donde esta ( tablero del jugador) y ver si se murio

    protected void reducirDurabilidad(int fuerza){
        //aca podria ver el tema del estado
        durabilidad-=fuerza;
    }
}
