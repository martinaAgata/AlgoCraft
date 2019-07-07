package modelo.materiales;
import modelo.estados.Estado;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.juego.ObjetoUbicable;
import modelo.mapa.Ubicacion;

public abstract class Material extends ObjetoUbicable implements Desgastable {

    protected Estado estado;

    public Material(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public void reducirDurabilidad(int fuerza) {
        this.estado = this.estado.desgastar(fuerza);
        if(this.estado.getDurabilidad() == 0) throw new MaterialSeHaGastadoException();
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }

}
