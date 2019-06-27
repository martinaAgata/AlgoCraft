package modelo.materiales;
import modelo.estados.Estado;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.exceptions.NoSePuedeDesgastarUnElementoConEstadoMuertoException;
import modelo.herramientas.Herramienta;
import modelo.juego.ObjetoUbicable;
import modelo.mapa.Ubicacion;

public abstract class Material extends ObjetoUbicable implements Desgastable {

    protected Estado estado;

    public Material(Ubicacion ubicacion) {
        super(ubicacion);
    }

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
