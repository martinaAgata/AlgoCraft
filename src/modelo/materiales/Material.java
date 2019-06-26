package modelo.materiales;
import modelo.estados.Estado;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.herramientas.Herramienta;
import modelo.juego.ObjetoUbicable;
import modelo.juego.Ubicable;
import modelo.mapa.Casillero;

public abstract class Material extends ObjetoUbicable implements Desgastable {

    protected Estado estado;
    protected Casillero casillero;

    public Material desgastarCon(Herramienta herramienta){ return this; }

    public void reducirDurabilidad(int fuerza) {
        if(estado.getDurabilidad() == 0) {
            casillero.eliminarUbicable();
            return;
        }
        estado = estado.desgastar(fuerza);
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }

}
