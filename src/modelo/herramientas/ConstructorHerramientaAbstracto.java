package modelo.herramientas;

import modelo.estrategias.EstrategiaDesgaste;
import modelo.materiales.Material;

public abstract class ConstructorHerramientaAbstracto implements ConstructorHerramienta {

    protected int durabilidad;
    protected int fuerza;
    protected EstrategiaDesgaste desgaste;
    protected Material material;

    public ConstructorHerramientaAbstracto conDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
        return this;
    }

    public ConstructorHerramientaAbstracto conFuerza(int fuerza) {
        this.fuerza = fuerza;
        return this;
    }

    public ConstructorHerramientaAbstracto conDesgaste(EstrategiaDesgaste desgaste) {
        this.desgaste = desgaste;
        return this;
    }

    public ConstructorHerramientaAbstracto conMaterial(Material material) {
        this.material = material;
        return this;
    }
}
