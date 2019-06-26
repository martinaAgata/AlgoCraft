package modelo.herramientas;

import modelo.estrategias.DesgasteAbrupto;
import modelo.estrategias.EstrategiaDesgaste;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMetalTests {

    private final int DURABILIDAD_PICO_METAL = 400;
    private final int FUERZA_PICO_METAL = 12;

    private EstrategiaDesgaste desgastePicoMetal;

    @Before
    public void setup() {
        desgastePicoMetal = new DesgasteAbrupto();
    }

    @Test
    public void testCrearPicoDeMetalConDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        assertThat(picoMetal.getDurabilidad(), is(DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testCrearPicoDeMetalConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        assertThat(picoMetal.getFuerza(), is(FUERZA_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraMaderaNoReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Madera madera = new Madera();
        picoMetal.usar(madera);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraPiedraNoReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void testPicoDeMetalSeUsaContraMetalNoReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Metal metal = new Metal();
        picoMetal.usar(metal);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMetalSeUsaContraMetal10VecesYSeRompe() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Metal metal = new Metal();
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
        picoMetal.usar(metal);
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMetalSeUsaContraMadera10VecesYSeRompe() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Madera madera = new Madera();
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
        picoMetal.usar(madera);
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMetalSeUsaContraPiedra10VecesYSeRompe() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(0);
        Pico picoMetal = constructor.construir();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
        picoMetal.usar(piedra);
    }

    @Test (expected = HerramientaRotaNoPuedeDesgastarseException.class)
    public void testPicoDeMetalSeUsaContraDiamante10VecesYSeRompe() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(desgastePicoMetal)
                .conFuerza(FUERZA_PICO_METAL);
        Pico picoMetal = constructor.construir();
        Diamante diamante = new Diamante();
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
        picoMetal.usar(diamante);
    }

}
