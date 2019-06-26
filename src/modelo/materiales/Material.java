package modelo.materiales;
import modelo.estados.Estado;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.exceptions.NoSePuedeDesgastarUnElementoConEstadoMuertoException;
import modelo.herramientas.Herramienta;
import modelo.juego.ObjetoUbicable;
import modelo.juego.Ubicable;
import modelo.mapa.Casillero;

public abstract class Material extends ObjetoUbicable implements Desgastable {

    protected Estado estado;
    protected Casillero casillero;

    public Material desgastarCon(Herramienta herramienta){ return this; }

    public void reducirDurabilidad(int fuerza) {
        try {
            this.estado = this.estado.desgastar(fuerza);
        } catch (NoSePuedeDesgastarUnElementoConEstadoMuertoException e) {
            throw new MaterialSeHaGastadoException();
        }
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }

}
